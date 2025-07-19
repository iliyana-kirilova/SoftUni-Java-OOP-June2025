package L6_SOLID.solid.calculator;

import L6_SOLID.solid.products.Product;
import L6_SOLID.solid.products.drinks.Drinks;
import L6_SOLID.solid.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            if (product instanceof Drinks){
                sum += (((Drinks) product).getLiters());
            } else if (product instanceof Food) {
                sum+=((Food) product).getKilograms();
            }
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
