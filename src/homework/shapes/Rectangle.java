package homework.shapes;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть больше нуля.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void displayArea() {
        System.out.printf("Прямоугольник (%.2f x %.2f): площадь = %.2f%n", width, height, area());
    }
}