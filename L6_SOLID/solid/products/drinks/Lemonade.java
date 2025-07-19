package L6_SOLID.solid.products.drinks;

public class Lemonade implements Drinks{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getLiters() {
        return milliliters/100;
    }

    @Override
    public double getCalories() {
        double grams = milliliters*DENSITY;
        return CALORIES_PER_100_GRAMS/100*grams;
    }
}
