package se.lexicon;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Menu {

    private static Scanner input = new Scanner(System.in);

    public static void menu () {

        System.out.println("Currency Converter:");

        int option = getOption();
        double amount = getAmount();

        double result;

        switch (option) {
            case 1 -> result = Converter.sekToUsd(amount);
            case 2 -> result = Converter.usdToSek(amount);
            case 3 -> result = Converter.sekToEuro(amount);
            case 4 -> result = Converter.euroToSek(amount);
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("Result: " + String.format("%.2f", result) +
                "\nTime: " + currentDateTime.truncatedTo(ChronoUnit.MINUTES));
    }





    private static double getAmount() {
        double amount;
        while (true) {
            System.out.println("Enter the amount:");

            //validating user amount input
            try {

                amount = input.nextDouble();
                if (amount < 0) System.out.println("You have entered negative number!");
                else break;

            } catch (Exception e) {

                System.out.println("You have entered an invalid amount!");
                //flush bad input
                input.next();
            }
        }
        return amount;
    }




    private static int getOption() {
        int option;
        do {
            System.out.println("""
                    Choose one of the options below:
                    1) Convert sek to usd
                    2) Convert usd to sek
                    3) Convert sek to euro
                    4) Convert euro to sek
                    0) Exit
                    Enter your choice:""");

            try {
                option = input.nextInt();

                //terminate the program
                if (option == 0) System.exit(0);

                //validating user option input
                if (option > 0 && option < 5) break;
                else System.out.println("You have entered incorrect number!");


            } catch (Exception e) {
                System.out.println("You have entered an invalid input!");
                //flush bad input
                input.next();
            }

        } while (true);

        return option;
    }

}