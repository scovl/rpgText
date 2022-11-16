import java.util.Scanner;
import java.util.Random;

public class Main{
    private static void playGame(){
        Player player = new Player();
        player.name = "Lobo";
        
        Enemy zumbi = new Enemy();
        zumbi.name = "Zumbi";
        
        String questionOne = (player.name + " estava andando de bike pela paulista e, de repente, notei que ao invés de pedestres, haviam monstros, muitos monstros por toda parte. Esquivei-me de todos que consegui mas, infelizmente, logo a frente, apareceu um que aparentou ser uma espécie de ZUMBI para me atacar. O que você deseja fazer?");
        System.out.println(questionOne);
        System.out.println("1 - Atacar");
        System.out.println("2 - Fugir");
        System.out.printf("Escolha entre a opção 1 e 2: ");
        
        while(true){
            try{
            Scanner input = new Scanner(System.in);
            int numberChoice = input.nextInt();
            
            if(numberChoice == 1){
                Dices dados = new Dices();
                
                player.diceroll = dados.rollDice(3,4);
                zumbi.diceroll = dados.rollDice(3,4);
                
                System.out.println(player.name + " jogando dados para atacar " + zumbi.name);
                System.out.println("A soma das vezes que " + player.name + " jogou, deu: " + player.diceroll);
                System.out.println("A soma das vezes que " + zumbi.name + " jogou, deu: " + zumbi.diceroll);
                
                if(player.diceroll > zumbi.diceroll){
                    player.weapon = "capacete";
                    zumbi.weapon = "mordida";
                    
                    if(player.weapon == "capacete" && zumbi.weapon == "mordida"){
                        player.damage = 15;
                        zumbi.damage = 5 ;
                    }
                    
                    int attack = zumbi.healthy - player.damage;
                    System.out.println(player.name + " tira " + player.damage + " de dano do " +  zumbi.name);
                    System.out.println(zumbi.name + " está com " + attack + " de vida");
                    
                }
                
                
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
        playGame();
    }
}
