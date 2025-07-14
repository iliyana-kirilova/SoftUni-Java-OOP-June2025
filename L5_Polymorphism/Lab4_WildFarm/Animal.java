package Lab4_WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    private String livingRegion;

    public Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.foodEaten = 0;
    }

    public abstract void makeSound();
    public abstract boolean canEat(Food food);

    public void eat(Food food){
        if (canEat(food)) {
            foodEaten += food.getQuantity();
        } else {
            System.out.println(getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName()
                , animalName
                , decimalFormat.format(animalWeight)
                , livingRegion
                , foodEaten);
    }
}
