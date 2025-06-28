package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Lab2_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(new Point(coordinates[0],coordinates[1]),
                                            new Point(coordinates[2],coordinates[3]));

        int countPoints = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=countPoints ; i++) {
            processPoint(scanner, rectangle);

        }
    }

    private static void processPoint(Scanner scanner, Rectangle rectangle) {
        String coordinatesPoint = scanner.nextLine();
        int x = Integer.parseInt(coordinatesPoint.split("\\s+")[0]);
        int y = Integer.parseInt(coordinatesPoint.split("\\s+")[1]);

        Point pointToCheck = new Point(x, y);
        System.out.println(rectangle.contains(pointToCheck));
    }
}
