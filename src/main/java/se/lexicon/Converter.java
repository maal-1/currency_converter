package se.lexicon;

public class Converter {

    private static double usdToSekRate = 11;
    private static double euroToSekRate = 11.45 ;


    public static double usdToSek(double amount) {
        return amount * usdToSekRate;
    }
    public static double sekToUsd(double amount) {
        return amount / usdToSekRate;
    }
    public static double euroToSek(double amount) {
        return amount * euroToSekRate;
    }

    public static double sekToEuro (double amount) {
        return amount / euroToSekRate;
    }
}
