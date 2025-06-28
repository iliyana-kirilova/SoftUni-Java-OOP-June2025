package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Lab3_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String command = scanner.nextLine();
        while (!command.equals("Exit")) {
            String[] commandParts = command.split(" ");

            studentSystem.parseCommand(commandParts);

            command = scanner.nextLine();
        }
    }
}
