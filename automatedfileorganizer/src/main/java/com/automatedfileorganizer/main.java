package com.automatedfileorganizer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String directory;
        FileScanner scanner = new FileScanner();
        
        System.out.println("Automated File Organization");
        System.out.println("Please select:");
        System.out.println("1. English");
        System.out.println("2. Spanish");
        int languaje = input.nextInt();
        input.nextLine();
        
        switch(languaje){
            case 1:
                System.out.println("Please write your path to order");
                directory = input.nextLine();
                scanner.scan(directory);
            break;
            case 2:
                System.out.println("Porfavor ingresa el directorio a ordenar");
                directory = input.nextLine();
                scanner.scan(directory);
            break;
        default:
            System.out.println("Invalid option/Opción Inválida");
        break;
            }
            
        input.close();
        
    }
}
