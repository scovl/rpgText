import java.util.Scanner;
import java.util.Random;

public class Game {

	private static void playGame(){

		// cmd clear, cls
		System.out.print("\033[H\033[2J");
		System.out.flush();

		PlayerClass human = new PlayerClass();
		Enemy zumbi = new Enemy();
		human.name = "Vitor";
		zumbi.name = "Zumbi";


		String questionOne = (human.name + " estava andando de bike pela paulista e, de repente, se deparou com uma inacreditavel horda de Monstros. De repente, um " + zumbi.name + " veio em sua direcao.");

		System.out.println(questionOne);
		System.out.println("O que voce deseja fazer?");
		System.out.println("1 - Atacar o " + zumbi.name);
		System.out.println("2 - Fugir");
		System.out.printf("Escolha as opcoes 1 ou 2: ");

		while(true) {
			try {
				Scanner input = new Scanner(System.in);
				int numberChoice = input.nextInt();

				if(numberChoice == 1){
					Dices dados = new Dices();

					human.diceroll = dados.rollDice(3,6);
					zumbi.diceroll = dados.rollDice(3,6);

					System.out.println(human.name + " jogando dados para atacar " + zumbi.name);
					System.out.println("A soma das vezes que " + human.name + " jogou, deu: " + human.diceroll);
					System.out.println("A soma das vezes que " + zumbi.name + " jogou, deu: " + zumbi.diceroll);

					if(human.diceroll > zumbi.diceroll){
						human.weapon = "capacete";
						zumbi.weapon = "mordida";

						if(human.weapon == "capacete" && zumbi.weapon == "mordida"){
							human.damage = 15;
							zumbi.damage = 5;
						}

						int attack = zumbi.health - human.damage;

						System.out.println(human.name + " tira " + human.damage + " de dano do " + zumbi.name);
						System.out.println(zumbi.name + " está com " + attack + " de vida");

					} else if(human.diceroll < zumbi.diceroll) {
						System.out.println(zumbi.name + " ataca " + human.name);
					}
					break;

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
						default:
							System.out.println("Error");
							break;

					}
					System.out.println(string);
					break;

				} else {
					playGame();
					break;
				}
			} catch (Exception e) {
				playGame();
				break;
			}
		}
	}

	public static void main(String[] args){
		playGame();
	}
}
