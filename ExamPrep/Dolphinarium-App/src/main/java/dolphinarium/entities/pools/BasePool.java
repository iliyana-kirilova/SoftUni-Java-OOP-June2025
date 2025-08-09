package dolphinarium.entities.pools;

import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static dolphinarium.common.ExceptionMessages.*;

public abstract class BasePool implements Pool{
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new NullPointerException(POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return this.dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (dolphins.size()>this.capacity){
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }

        if (dolphin.getEnergy()<=0){
            throw new IllegalArgumentException(DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }

        this.dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        this.dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }
}
