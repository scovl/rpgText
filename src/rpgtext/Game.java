package rpgtext;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private Enemy enemy;
    private Fight fight;
    private Scanner scanner;
    private Asciiart ascii;

    public Game() {
        scanner = new Scanner(System.in);
        ascii = new Asciiart();
    }

    public void playGame() {
        showMainMenu();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void showMainMenu() {
        while (true) {
            clearScreen();
            System.out.println("\n=== RPG TEXT GAME ===");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Carregar Jogo (Em desenvolvimento)");
            System.out.println("3. Sair");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createNewGame();
                    break;
                case 2:
                    System.out.println("Função ainda não implementada!");
                    break;
                case 3:
                    System.out.println("Obrigado por jogar!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void createNewGame() {
        System.out.println("\nCrie seu personagem");
        System.out.print("Digite o nome do seu heroi: ");
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
            System.out.println("\nVoce encontrou um " + enemy.getName() + "!");
            
            while (enemy.getHealth() > 0 && player.getHealth() > 0) {
                showBattleStatus();
                processBattleChoice();
                clearScreen();
            }
            
            if (player.getHealth() <= 0) {
                gameOver();
                playing = false;  // Encerra o loop após game over
            } else {
                player.gainXp(50);
                enemy = new Enemy();
                fight = new Fight(player, enemy);
            }
        }
    }

    private void showBattleStatus() {
        System.out.println("\n" + enemy.getName() + ":");
        ascii.barLife(enemy.getHealth());
        
        System.out.println("\n" + player.getName() + ":");
        ascii.barLife(player.getHealth());
        
        System.out.println("XP: " + player.getXp());
        System.out.println("\n1. Lutar");
        System.out.println("2. Fugir");
        System.out.println("3. Usar pocao (Vida atual: " + player.getHealth() + ")");
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
                System.out.println("Opção inválida!");
        }
    }

    private void tryToEscape() {
        Dices dice = new Dices();
        int escapeRoll = dice.rollDice(1, 6);
        
        if (escapeRoll > 4) {
            System.out.println("Voce conseguiu fugir!");
            enemy = new Enemy();
            fight = new Fight(player, enemy);
        } else {
            System.out.println("Voce nao conseguiu fugir!");
            int damage = enemy.getAttackDice();
            player.takeDamage(damage);
            System.out.println("Voce tomou " + damage + " de dano!");
        }
    }

    private void gameOver() {
        clearScreen();
        ascii.showGameOver();
        System.out.println("\n=== GAME OVER ===");
        System.out.println("1. Voltar ao Menu Principal");
        System.out.println("2. Sair do Jogo");
        
        int choice = scanner.nextInt();
        if (choice == 1) {
            showMainMenu();
        } else {
            System.out.println("Obrigado por jogar!");
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
