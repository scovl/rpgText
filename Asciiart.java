public class Asciiart {
    public void barLife(int health){
        int bar = health / 10;

        System.out.print("Vida: ");
        for(int i = 0; i < bar; i++ ){
            System.out.print("█");
        }

        for(int i = 0; i < 10 - bar; i++ ){
            System.out.print("░");
        }
        System.out.println(" " + health);
    }

    public static void main(String[] args) {
        Asciiart asciiart = new Asciiart();
        asciiart.barLife(100);
        asciiart.barLife(75);
        asciiart.barLife(50);
        asciiart.barLife(25);
        asciiart.barLife(0);
    }
}
