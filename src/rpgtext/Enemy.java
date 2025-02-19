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

	public Enemy() {
		Random rand = new Random();
		this.level = rand.nextInt(3) + 1;  // Level 1 a 3
		this.name = ENEMY_NAMES[rand.nextInt(ENEMY_NAMES.length)];
		
		// Atributos base aleatórios
		int baseHealth = rand.nextInt(31) + 40;  // 40-70 de vida base
		int baseAttackDice = rand.nextInt(2) + 2;  // 2-3 dados base
		int baseAttackSides = rand.nextInt(6) + 15;  // d15-d20 base
		int baseDefenseDice = rand.nextInt(2) + 1;  // 1-2 dados base
		
		// Escala com level
		this.health = baseHealth + (20 * level);
		this.attackDice = baseAttackDice + level;
		this.attackDiceSides = baseAttackSides + (2 * level);
		this.defenseDice = baseDefenseDice + level;
		this.defenseDiceSides = 6;  // Mantém d6 para defesa
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