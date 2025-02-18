package rpgtext;

import java.util.Random;

class Enemy {
	private String name;
	private int health;
	private int attackDice;
	private int attackDiceSides;
	private int defenseDice;
	private int defenseDiceSides;

	private int level;

	private static final String[] ENEMY_NAMES = {
		"Bolsonaro", "Vampirao", "Zumbi Corrupto", "Politico Maligno",
		"Burocrata das Trevas", "Fiscal do Caos", "Troll da Inflacao",
		"Demonio da Corrupcao", "Capanga das Sombras", "Miliciano"
	};

	// construtor
	public Enemy(){
		Random rand = new Random();
		this.level = 1;
		this.name = ENEMY_NAMES[rand.nextInt(ENEMY_NAMES.length)];
		this.health = 50 + (25 * level);
		this.attackDice = 2 + level;
		this.attackDiceSides = 15 + (5 * level);
		this.defenseDice = 2 + level;
		this.defenseDiceSides = 6;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackDice() {
		return attackDice;
	}

	public int getAttackDiceSides() {
		return attackDiceSides;
	}


	public int getDefenseDice() {
		return defenseDice;
	}

	public int getDefenseDiceSides() {
		return defenseDiceSides;
	}

	public void takeDamage(int damage){
		this.health -= damage;

		if(this.health <= 0) {
			this.health = 0;  // Garante que a vida não fique negativa
			System.out.println(getName() + " morreu!!!");
		}
	}

	public int getHealth() {
		return health;
	}

	public int getLevel() {
		return level;
	}
}