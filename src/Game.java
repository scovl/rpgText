import java.util.Scanner;
import java.util.Random;

public class Game{
    public void playGame(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        String questionOne = (player.getName() + " estava andando de bike pela paulista e, de repente, notei que ao invés de pedestres, haviam monstros, muitos monstros por toda parte. Esquivei-me de todos que consegui mas, infelizmente, logo a frente, apareceu um que aparentou ser uma espécie de ZUMBI para me atacar. O que você deseja fazer?");
        System.out.println(questionOne);
        System.out.println("1 - Atacar");
        System.out.println("2 - Fugir");
        System.out.printf("Escolha entre a opção 1 e 2: ");

        while(true){
            try{
                Scanner input = new Scanner(System.in);
                int numberChoice = input.nextInt();

                if(numberChoice == 1){
                    Fight fight = new Fight();
                    fight.fight(player, enemy);

                } else if(numberChoice == 2){
                    Random generator = new Random();
                    int x = generator.nextInt();

                    String string = null;
                    switch (x%3){
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
            } catch (Exception e){
                System.out.println("Caracatere inválido!!! Voltando ao Menu...");
                playGame();
            }
        }
    }

    public static void main (String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
