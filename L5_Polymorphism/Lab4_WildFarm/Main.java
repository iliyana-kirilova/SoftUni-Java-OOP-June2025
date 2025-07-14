package Lab4_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!"end".equalsIgnoreCase(line)) {

            Animal animal = createAnimal(line);
            Food food = createFood(scanner.nextLine());

            animal.makeSound();
            animal.eat(food);

            animals.add(animal);
            line = scanner.nextLine();


        }
        animals.stream().forEach(animal -> System.out.println(animal.toString()));
    }

    private static Food createFood(String nextLine) {
        String[] tokens = nextLine.split("\\s+");
        String foodType = tokens[0];
        Integer quantity = Integer.parseInt(tokens[1]);

        return foodType.equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String line) {
        String[] tokens = line.split("\\s+");
        String type = tokens[0];
        String name = tokens[1];
        Double weight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        Animal animal;
        if (type.equals("Cat")) {
            animal = new Cat(name, type, weight, livingRegion, tokens[4]);
        } else if (type.equals("Mouse")) {
            animal = new Mouse(name, type, weight, livingRegion);
        } else if (type.equals("Tiger")) {
            animal = new Tiger(name, type, weight, livingRegion);
        } else {
            animal = new Zebra(name, type, weight, livingRegion);
        }

        return animal;
    }

}
