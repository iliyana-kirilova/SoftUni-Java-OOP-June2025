package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Ex3_CardsWithPower;

public class Card {
    private RankPower cardName;
    private SuitsPower cardSuit;
    private int power;

    public Card(RankPower cardName, SuitsPower cardSuit) {
        this.cardName = cardName;
        this.cardSuit = cardSuit;
    }

    public RankPower getCardName() {
        return this.cardName;
    }

    public SuitsPower getCardSuit() {
        return this.cardSuit;
    }

    public int getPower() {
        this.power = this.cardSuit.getPower() + this.cardName.getPower();
        return power;
    }
}
