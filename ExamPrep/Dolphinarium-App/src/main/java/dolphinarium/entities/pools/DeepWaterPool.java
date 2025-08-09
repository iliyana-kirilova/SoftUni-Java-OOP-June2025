package dolphinarium.entities.pools;



public class DeepWaterPool extends BasePool {
    private static final int INITIAL_CAPACITY = 5;

    public DeepWaterPool(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
