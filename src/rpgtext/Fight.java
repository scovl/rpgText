package rpgtext;

public class Fight {
    private Player player;
    private Enemy enemy;
    private Dices dice;

    public Fight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.dice = new Dices();
    }

    public void startFight() {
        int playerDamage = dice.rollDice(player.getAttackDice(), player.getAttackDiceSides());
        int enemyDamage = dice.rollDice(enemy.getAttackDice(), enemy.getAttackDiceSides());

        enemy.takeDamage(playerDamage);
        System.out.println("Você causou " + playerDamage + " de dano!");
        
        player.takeDamage(enemyDamage);
        System.out.println(enemy.getName() + " causou " + enemyDamage + " de dano!");
    }

    public void fight(Player player, Enemy enemy){

        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            playerTurn(player, enemy);
            enemyTurn(player, enemy);
        }
    }


    private void enemyTurn(Player player, Enemy enemy){

        int enemyAttack = dice.rollDice(enemy.getAttackDice(), enemy.getAttackDiceSides());
        if(enemyAttack == 0){
            System.out.println("O " + enemy.getName() + " errou o ataque");
        }

        int playerDefense = dice.rollDice(player.getDefenseDice(), player.getDefenseDiceSides());

        // Damage
        int damage = enemyAttack - playerDefense;
        if(damage > 0){
            player.takeDamage(damage);
            System.out.println("O " + enemy.getName() + " atacou com " + enemyAttack + " e " + player.getName() + " defendeu com " + playerDefense +
                    " e sofreu " + damage + " de dano");
        } else {
            System.out.println("O " + enemy.getName() + " atacou com " + enemyAttack + " e " + player.getName() + " defendeu com " + playerDefense +
                    " e não sofreu dano");
            System.out.println(player.getName() + " tem " + player.getHealth() + " de vida");
        }
    }

    private void playerTurn(Player player, Enemy enemy){
        int playerAttack = dice.rollDice(player.getAttackDice(), player.getAttackDiceSides());
        if(playerAttack == 0){
            System.out.println("O " + player.getName() + " errou o ataque");
        }

        int enemyDefense = dice.rollDice(enemy.getDefenseDice(), enemy.getDefenseDiceSides());

        // Damage
        int damage = playerAttack - enemyDefense;
        if(damage > 0){
            enemy.takeDamage(damage);
            System.out.println("O " + player.getName() + " atacou com " + playerAttack + " e " + enemy.getName() + " defendeu com " + enemyDefense +
                    " e sofreu " + damage + " de dano");
        } else {
            System.out.println("O " + player.getName() + " atacou com " + playerAttack + " e " + enemy.getName() + " defendeu com " + enemyDefense +
                    " e não sofreu dano");
            System.out.println(enemy.getName() + " tem " + enemy.getHealth() + " de vida");
        }
    }

}