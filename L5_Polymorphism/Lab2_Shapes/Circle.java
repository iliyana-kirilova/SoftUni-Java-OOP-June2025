package Lab2_Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    public final double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        System.out.println(2* Math.PI * getRadius());
    }

    @Override
    public void calculateArea() {
        System.out.println(Math.PI * getRadius()*getRadius());
    }
}
