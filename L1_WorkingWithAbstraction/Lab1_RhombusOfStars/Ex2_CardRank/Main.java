package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Ex2_CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        Rank[] cardRanks = Rank.values();

        for (Rank card : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
