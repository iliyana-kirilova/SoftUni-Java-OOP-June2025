package Lab2_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();
}
