package automatedfileorganization.src;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Automated File Organization");
        System.out.println("Please select:");
        System.out.println("1. English");
        System.out.println("2. Spanish");
        int languaje = input.nextInt();
        
        switch(languaje){
            case 1:
                System.out.println("Please write your path to order");
                String directory = input.nextLine();
                
        }


    }
}
