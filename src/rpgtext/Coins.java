package rpgtext;

import java.util.Random;

public class Coins {
    private int amount;
    
    public Coins() {
        this.amount = 0;
    }
    
    public void addCoins(int enemyLevel) {
        Random rand = new Random();
        // Base de moedas: 10-30 + (level * 5-15)
        int baseCoins = rand.nextInt(21) + 10;
        int levelBonus = rand.nextInt(11) + 5;
        int reward = baseCoins + (enemyLevel * levelBonus);
        
        this.amount += reward;
        System.out.println("Voce ganhou " + reward + " moedas!");
    }
    
    public boolean spendCoins(int cost) {
        if (amount >= cost) {
            amount -= cost;
            return true;
        }
        System.out.println("Moedas insuficientes! Voce tem: " + amount);
        return false;
    }
    
    public int getAmount() {
        return amount;
    }
}
