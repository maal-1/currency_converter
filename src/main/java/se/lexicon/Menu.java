package se.lexicon;

import java.util.Scanner;

public class Menu {

    public static void menu () {

        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("Choose one of the options below:" +
                    "\n1) Convert sek to usd" +
                    "\n2) Convert usd to sek" +
                    "\n3) Convert sek to euro" +
                    "\n4) Convert euro to sek" +
                    "\n0) Exit" +
                    "\nEnter your choice:");

            try {
                option = input.nextInt();

                if (option == 0) System.exit(0);

                if (validateOptionInput(option)) break;
                    //specify the exception type
                else throw new Exception();

            } catch (Exception e) {
                System.out.println("You have entered an invalid input!");
            }

        } while (true);

        System.out.println("Enter the amount:");
        double amount = input.nextDouble();
        double result = 0;


        switch (option) {
            case 1 -> result = Converter.sekToUsd(amount);
            case 2 -> result = Converter.usdToSek(amount);
            case 3 -> result = Converter.sekToEuro(amount);
            case 4 -> result = Converter.euroToSek(amount);
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        System.out.println("Result are: " + result);
    }

    private static boolean validateOptionInput(int option) {
        if (option > 0 && option < 5) return true;
        else return false;
    }


}