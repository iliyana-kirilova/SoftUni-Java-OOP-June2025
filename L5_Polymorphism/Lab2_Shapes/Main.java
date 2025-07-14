package Lab2_Shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape rectangle = new Rectangle(3, 5);

        System.out.println("Circle:");
        circle.calculatePerimeter();
        circle.calculateArea();

        System.out.println("Rectangle:");
        rectangle.calculatePerimeter();
        rectangle.calculateArea();
    }
}
