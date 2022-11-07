class Player {
    String name;
	String weapon;
	int defense;
	int damage;
	int healthy;
	private boolean critical;
	
	public Player(){
		this.healthy = 100;
		this.defense = 10;
	}
	
	public String getAttackEnemy(Enemy enemy){
		int attack;
		int monsterAttack;
		
		if (isCritical()){
			enemy.setHealthy(enemy.getHealthy() - attack);
			message = (getName() + "ataque com um" + getWeapon() + " e investida " + attack + "critical damage!\n");
		} else {
			enemy.setHealthy(enemy.getHealthy() - attack);
			message = (getName() + "ataque com um" + getWeapon() + " e investida " + attack);
		}
		
		return message;
	}