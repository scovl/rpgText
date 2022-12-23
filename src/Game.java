import java.util.Scanner;
import java.util.Random;

public class Game {
    public void playGame() {

        Player player = new Player();
        Enemy enemy = new Enemy();


        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                int numberChoice = input.nextInt();

                if (numberChoice == 1) {

                    Fight fight = new Fight();
                    fight.fight(player, enemy);

                } else if (numberChoice == 2) {
                    Random generator = new Random();
                    int x = generator.nextInt();

                    String string = null;
                    switch (x % 3) {
                        case 0:
                            string = "A";
                            break;
                        case 1:
                            string = "B";
                            break;
                        case 2:
                            string = "C";
                            break;
                    }
                    System.out.println(string);
                    break;
                } else {
                    playGame();
                }
            } catch (Exception e) {
                System.out.println("Caracatere inválido!!! Voltando ao Menu...");
                playGame();
            }
        }
    }
}

// TODO
//  Criar uma classe History e Menu <--
//  Adicionar menu inicial do jogo (criar personagem, iniciar jogo, carregar jogo salvo)
//  Classe de armas, moedas
//  Escolher o nome do jogo *
//  Adicionar nome e objetos em ascii art *
//  Implementar os dados para a opcao 2 (fugir)
//  Adicionar uma mecanica de XP
//  Adicionar uma mecanica de mana/life recover
//  Implementar o GAME OVER com a opcao de voltar ao menu ou sair do jogo



