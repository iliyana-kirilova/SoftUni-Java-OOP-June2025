package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Ex3_CardsWithPower;

public enum SuitsPower {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;
    SuitsPower(int power){
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
