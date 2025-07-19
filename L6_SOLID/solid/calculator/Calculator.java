package L6_SOLID.solid.calculator;

import L6_SOLID.solid.products.Product;

import java.util.List;

public interface Calculator {
    double sum (List<Product> products);
    double average (List<Product> products);


}
