import java.util.Random;

public class Dices{
    public int rollDice(int choice, int nSides){
        int total = 0;
        int roll = 0;

        Random random = new Random();

        if(nSides >= 3){
            for(int i = 0; i < choice; i++){
                roll = random.nextInt(nSides);
                //System.out.println("Dado jogado:  " + roll);
                total = total + roll;

            }
        }
        return total;
    }
}
