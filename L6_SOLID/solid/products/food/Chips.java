package L6_SOLID.solid.products.food;

public class Chips implements Food{
    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }

    @Override
    public double getKilograms() {
        return grams/1000;
    }

    @Override
    public double getCalories() {
        return CALORIES_PER_100_GRAMS/100*grams;
    }
}
