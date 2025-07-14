package Lab4_WildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!canEat(food)){
            System.out.println("Zebras are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }
}
