package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

import static dolphinarium.common.ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;

    public BaseDolphin(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw  new NullPointerException(DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        if (energy<0){
            energy=0;
        }

        this.energy = energy;
    }

    @Override
    public void jump() {
        this.energy-=10;
    }

    @Override
    public void eat(Food food) {
        this.energy += food.getCalories();
    }
}
