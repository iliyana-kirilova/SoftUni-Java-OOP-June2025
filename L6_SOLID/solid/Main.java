package solid;

import L6_SOLID.solid.calculator.Calculator;
import L6_SOLID.solid.calculator.CalorieCalculator;
import L6_SOLID.solid.calculator.QuantityCalculator;
import L6_SOLID.solid.printer.Printer;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new CalorieCalculator();
        Calculator calculator2 = new QuantityCalculator();

        Printer printer1 = new Printer(calculator);
        Printer printer2 = new Printer(calculator2);
    }
}
