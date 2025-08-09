package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop {
    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        setWoodQuantity(woodQuantity);
        this.producedFurnitureCount = 0;
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
    }

    public void setProducedFurnitureCount(int producedFurnitureCount) {
        this.producedFurnitureCount = producedFurnitureCount;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return this.producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return this.woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
       this.woodQuantity += wood.getWoodQuantity();
    }

    @Override
    public void produce() {

    }

    public void setWoodQuantity(int woodQuantity) {
        if (woodQuantity<=0){
            woodQuantity = 0;
        }
        this.woodQuantity = woodQuantity;
    }
}
