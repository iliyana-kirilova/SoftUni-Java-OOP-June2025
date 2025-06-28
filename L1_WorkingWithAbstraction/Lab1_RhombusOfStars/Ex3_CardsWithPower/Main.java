package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Ex3_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RankPower cardName = RankPower.valueOf(scanner.nextLine());
        SuitsPower cardSuit = SuitsPower.valueOf(scanner.nextLine());

        /*String cardName = scanner.nextLine();
        String cardSuit = scanner.nextLine();
        int cardPower = RankPower.valueOf(cardName).getPower() + SuitsPower.valueOf(cardSuit).getPower();*/

        Card card = new Card(cardName, cardSuit);
        System.out.printf("Card name: %s of %s; Card power: %d", cardName, cardSuit, card.getPower());
    }
}
