package dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin{
    //Can only swim in DeepWaterPool!

    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        super.jump();
        this.setEnergy(this.getEnergy() - 190);
    }
}
