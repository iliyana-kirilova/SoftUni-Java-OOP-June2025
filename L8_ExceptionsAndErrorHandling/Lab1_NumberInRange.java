package L8_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class Lab1_NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        int start = Integer.parseInt(firstLine.split(" ")[0]);
        int end = Integer.parseInt(firstLine.split(" ")[1]);

        System.out.printf("Range: [%d...%d]%n", start, end);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);

                if (number >= start && number <= end) {
                    System.out.println("Valid number: " + number);
                    break;
                } else {
                    System.out.println("Invalid number: " + number);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number: " + input);
            }
        }
    }
}
