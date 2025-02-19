package rpgtext;

class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int xp;
    private int level;
    private int potions;
    private Weapons weapon;
    private int attackDice;
    private int attackDiceSides;
    private int defenseDice;
    private int defenseDiceSides;
    private Coins coins;

    public Player(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.xp = 0;
        this.level = 1;
        this.potions = 3;
        this.weapon = new Weapons("Espada Básica", 10, 0);
        this.attackDice = 3;
        this.attackDiceSides = 20;
        this.defenseDice = 3;
        this.defenseDiceSides = 6;
        this.coins = new Coins();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefenseDice() {
        return defenseDice;
    }

    public int getDefenseDiceSides() {
        return defenseDiceSides;
    }

    public void takeDamage(int damage) {
        this.health -= damage;

        if (this.health <= 0) {
            System.out.println(getName() + " morreu!!!");
            System.exit(0);
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDice() {
        return attackDice;
    }

    public int getAttackDiceSides() {
        return attackDiceSides;
    }

    public void gainXp(int amount) {
        this.xp += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (xp >= level * 100) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        maxHealth += 20;
        health = maxHealth;
        System.out.println("LEVEL UP! Você alcançou o nível " + level);
    }

    public void usePotion() {
        if (potions > 0) {
            health = Math.min(maxHealth, health + 50);
            potions--;
            System.out.println("Poção usada! Vida atual: " + health);
        } else {
            System.out.println("Sem poções restantes!");
        }
    }

    public int getXp() {
        return xp;
    }

    public void addReward(Enemy enemy) {
        coins.addCoins(enemy.getLevel());
    }

    public int getCoins() {
        return coins.getAmount();
    }
}

