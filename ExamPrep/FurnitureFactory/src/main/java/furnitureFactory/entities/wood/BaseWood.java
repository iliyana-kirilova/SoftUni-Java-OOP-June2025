package furnitureFactory.entities.wood;

public class BaseWood implements Wood{
    private int woodQuantity;

    public BaseWood(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }
}
