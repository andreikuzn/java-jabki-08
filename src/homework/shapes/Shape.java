package homework.shapes;

public abstract class Shape {
    public abstract double area();

    public void displayArea() {
        System.out.println("Площадь: " + area());
    }
}