package dolphinarium.core;


import dolphinarium.entities.dolphins.BottleNoseDolphin;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.dolphins.SpinnerDolphin;
import dolphinarium.entities.dolphins.SpottedDolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.entities.foods.Herring;
import dolphinarium.entities.foods.Mackerel;
import dolphinarium.entities.foods.Squid;
import dolphinarium.entities.pools.DeepWaterPool;
import dolphinarium.entities.pools.Pool;
import dolphinarium.entities.pools.ShallowWaterPool;
import dolphinarium.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import static dolphinarium.common.ConstantMessages.*;
import static dolphinarium.common.ExceptionMessages.*;


//TODO Implement all methods
public class ControllerImpl implements Controller{

    private FoodRepositoryImpl foodRepository;
    private Collection<Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new ArrayList<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        if (!poolType.equals("DeepWaterPool") && !poolType.equals("ShallowWaterPool")){
            throw new NullPointerException(INVALID_POOL_TYPE);
        }

        Pool poolByName = getPoolByName(poolName);
        if (poolByName !=null){
            throw new NullPointerException(POOL_EXISTS);
        }

        Pool pool;
        if (poolType.equals("DeepWaterPool")) {
            pool = new DeepWaterPool(poolName);
        } else {
            pool = new ShallowWaterPool(poolName);
        }

        pools.add(pool);

        return String.format(SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    private Pool getPoolByName(String poolName) {
        return pools.stream()
                .filter(pool -> pool.getName().equals(poolName))
                .findFirst().orElse(null);
    }

    @Override
    public String buyFood(String foodType) {
        if (!foodType.equals("Squid") && !foodType.equals("Herring")&& !foodType.equals("Mackerel")){
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        Food food;
        switch (foodType){
            case "Squid":{
                food = new Squid();
                foodRepository.add(food);
            }
            case "Herring":{
                food = new Herring();
                foodRepository.add(food);
            }
            case "Mackerel":{
                food = new Mackerel();
                foodRepository.add(food);
            }
        }
        return String.format(SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Pool pool = getPoolByName(poolName);
        Food food = foodRepository.findByType(foodType);

        if (food==null){
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        pool.addFood(food);
        foodRepository.remove(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Pool pool = getPoolByName(poolName);
        Dolphin dolphin;

        for (Dolphin d : pool.getDolphins()) {
            if (d.getName().equals(dolphinName)){
                throw new IllegalArgumentException(DOLPHIN_EXISTS);
            }
        }

        switch (dolphinType){
            case "BottleNoseDolphin" -> dolphin = new BottleNoseDolphin(dolphinName, energy);
            case "SpottedDolphin" -> dolphin = new SpottedDolphin(dolphinName, energy);
            case "SpinnerDolphin" -> dolphin = new SpinnerDolphin(dolphinName, energy);
            default ->throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        }

        if (pool.getClass().getSimpleName().equals("DeepWaterPool")
                && dolphinType.equals("BottleNoseDolphin")
                || dolphinType.equals("SpottedDolphin")) {
            pool.addDolphin(dolphin);
        } else if (pool.getClass().getSimpleName().equals("ShallowWaterPool")
                && dolphinType.equals("SpinnerDolphin")) {
            pool.addDolphin(dolphin);
        } else {
            return POOL_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Pool pool = getPoolByName(poolName);

        Food currentFood = pool.getFoods()
                .stream().filter(food1 -> food1.getClass().getSimpleName().equals(food))
                .findFirst().orElse(null);

        if(currentFood==null){
            throw new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }

        for (Dolphin dolphin : pool.getDolphins()) {
            dolphin.eat(currentFood);
        }

        pool.getFoods().remove(currentFood);
        return String.format(DOLPHINS_FED, pool.getDolphins().size(), pool.getName());
    }

    @Override
    public String playWithDolphins(String poolName) {
        Pool pool = getPoolByName(poolName);
        int countRemovedDolphins = 0;

        if (pool.getDolphins() ==null){
            throw  new IllegalArgumentException(NO_DOLPHINS);
        }

        Iterator<Dolphin> iterator = pool.getDolphins().iterator();

        while (iterator.hasNext()) {
            Dolphin dolphin = iterator.next();
            dolphin.jump();

            if (dolphin.getEnergy() <= 0) {
                iterator.remove();
                countRemovedDolphins++;
            }
        }

        return String.format(DOLPHINS_PLAY, pool.getName(), countRemovedDolphins);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Pool pool : pools) {
            sb.append(String.format(DOLPHINS_FINAL, pool.getName()))
                    .append(System.lineSeparator());
            if (pool.getDolphins().isEmpty()){
                sb.append(String.format(NONE)).append(System.lineSeparator());
            }else {
                sb.append(pool.getDolphins().stream()
                        .map(dolphin -> dolphin.getName() + " - "+ dolphin.getEnergy())
                        .collect(Collectors.joining(DELIMITER)))
                   .append(System.lineSeparator());
            }
        }
        
        return sb.toString().trim();
    }
}
