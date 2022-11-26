class Enemy {
	private String name;
	private int health;
	private int attackDice;
	private int attackDiceSides;
	private int defenseDice;
	private int defenseDiceSides;
	// construtor
	public Enemy(){
		this.name = "Bolsonaro";
		this.health = 75;
		this.attackDice = 3;
		this.attackDiceSides = 20;
		this.defenseDice = 3;
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

		if(this.health <= 0){
			System.out.println( getName() + " morreu!!!");
			System.exit(0);
		}
	}

	public int getHealth() {
		return health;
	}
}