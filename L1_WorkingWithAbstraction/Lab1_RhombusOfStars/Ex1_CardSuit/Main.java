package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Ex1_CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suit:");
        Suit[] suits = Suit.values();

        for (Suit suit : suits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
