package L6_SOLID.solid.products.drinks;

public class Coke implements Drinks{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getLiters() {
        return milliliters/1000;
    }

    @Override
    public double getCalories() {
       double grams = milliliters*DENSITY;
       return CALORIES_PER_100_GRAMS/100*grams;
    }
}
