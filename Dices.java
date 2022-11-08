import java.util.Random;

public class Dices{
	
    public static int rollDice(int number, int nSides){ 
        int num = 0;
        int roll = 0;
        Random random = new Random(); 
		
        if(nSides >=3){ 
            for(int i = 0; i < number; i++){ 
                roll = random.nextInt(nSides)+1;
                //System.out.println("Dado jogado:  " + roll);
                num = num + roll; 
            } 
        } 
        return num;  
    } 
}

