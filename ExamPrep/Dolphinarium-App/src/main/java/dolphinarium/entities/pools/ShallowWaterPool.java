package dolphinarium.entities.pools;

public class ShallowWaterPool extends BasePool{
    private static final int INITIAL_CAPACITY = 2;

    public ShallowWaterPool(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
