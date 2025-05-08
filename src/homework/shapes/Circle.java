package homework.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;

    }

    @Override
    public void displayArea() {
        System.out.printf("Круг (радиус %.2f): площадь = %.2f%n", radius, area());
    }
}