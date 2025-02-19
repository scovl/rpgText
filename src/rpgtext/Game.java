package rpgtext;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

public class Game {
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
    private Player player;
    private Enemy enemy;
    private Fight fight;
    private Scanner scanner;
    private Asciiart ascii;

    public Game() {
        scanner = new Scanner(System.in);
        ascii = new Asciiart();
        configureLogger();
    }

    private void configureLogger() {
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(java.util.logging.LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        LOGGER.addHandler(handler);
    }

    private void log(String message) {
        LOGGER.info(message);
    }

    public void playGame() {
        showMainMenu();
    }

    private void clearScreen() {
        log("\033[H\033[2J");
    }

    private void showMainMenu() {
        boolean running = true;
        while (running) {
            clearScreen();
            log("\n=== RPG TEXT GAME ===");
            log("1. Novo Jogo");
            log("2. Carregar Jogo (Em desenvolvimento)");
            log("3. Sair");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createNewGame();
                    break;
                case 2:
                    log("Função ainda não implementada!");
                    break;
                case 3:
                    log("Obrigado por jogar!");
                    running = false;
                    break;
                default:
                    log("Opção inválida!");
            }
        }
    }

    private void createNewGame() {
        log("\nCrie seu personagem");
        log("Digite o nome do seu heroi: ");
        String name = scanner.nextLine();
        
        player = new Player(name);
        enemy = new Enemy();
        fight = new Fight(player, enemy);
        
        startGameLoop();
    }

    private void startGameLoop() {
        boolean playing = true;
        while (playing) {
            clearScreen();
            ascii.showBattle();
            log("\nVoce encontrou um " + enemy.getName() + "!");
            
            while (enemy.getHealth() > 0 && player.getHealth() > 0) {
                showBattleStatus();
                processBattleChoice();
                clearScreen();
            }
            
            if (player.getHealth() <= 0) {
                gameOver();
                playing = false;
            } else {
                player.gainXp(50);
                player.addReward(enemy);
                enemy = new Enemy();
                fight = new Fight(player, enemy);
            }
        }
    }

    private void showBattleStatus() {
        log("\n" + enemy.getName() + ":");
        ascii.barLife(enemy.getHealth());
        
        log("\n" + player.getName() + ":");
        ascii.barLife(player.getHealth());
        
        log("XP: " + player.getXp());
        log("Moedas: " + player.getCoins());
        log("\n1. Lutar");
        log("2. Fugir");
        log("3. Usar pocao (Vida atual: " + player.getHealth() + ")");
    }

    private void processBattleChoice() {
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                fight.startFight();
                break;
            case 2:
                tryToEscape();
                break;
            case 3:
                player.usePotion();
                break;
            default:
                log("Opção inválida!");
        }
    }

    private void tryToEscape() {
        Dices dice = new Dices();
        int escapeRoll = dice.rollDice(1, 6);
        
        if (escapeRoll > 4) {
            log("Voce conseguiu fugir!");
            enemy = new Enemy();
            fight = new Fight(player, enemy);
        } else {
            log("Voce nao conseguiu fugir!");
            int damage = enemy.getAttackDice();
            player.takeDamage(damage);
            log("Voce tomou " + damage + " de dano!");
        }
    }

    private void gameOver() {
        clearScreen();
        ascii.showGameOver();
        log("\n=== GAME OVER ===");
        log("1. Voltar ao Menu Principal");
        log("2. Sair do Jogo");
        
        int choice = scanner.nextInt();
        if (choice == 1) {
            showMainMenu();
        } else {
            log("Obrigado por jogar!");
            System.exit(0);
        }
    }
}

// TODO
//  Adicionar menu inicial do jogo (criar personagem, iniciar jogo, carregar jogo salvo)
//  Classe de armas, moedas
//  Adicionar nome e objetos em ascii art *
//  Implementar os dados para a opcao 2 (fugir)
//  Adicionar uma mecanica de XP
//  Adicionar uma mecanica de mana/life recover
//  Implementar o GAME OVER com a opcao de voltar ao menu ou sair do jogo
