package L8_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class Lab2_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);

            if (number < 0) {
                System.out.println("Invalid");
            } else {
                double sqrt = Math.sqrt(number);
                System.out.printf("%.2f%n", sqrt);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
