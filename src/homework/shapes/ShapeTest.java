package homework.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
    @Test
    void circleAreaIsCorrectTest() {
        Circle circle = new Circle(2.0);
        double expected = Math.PI * 4;
        assertEquals(expected, circle.area(), 0.0001);
    }

    @Test
    void rectangleAreaIsCorrectTest() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(12.0, rectangle.area());
    }

    @Test
    void circleNegativeRadiusTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Circle(-1.0));
        assertEquals("Радиус должен быть больше нуля.", exception.getMessage());
    }

    @Test
    void rectangleTZeroWidthTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5.0));
        assertEquals("Ширина и высота должны быть больше нуля.", exception.getMessage());
    }

    @Test
    void rectangleNegativeHeightTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Rectangle(4.0, -2.0));
        assertEquals("Ширина и высота должны быть больше нуля.", exception.getMessage());
    }

    @Test
    void circleAreaDoesNotThrowTest() {
        Shape circle = new Circle(0.01);
        assertDoesNotThrow(circle::displayArea);
    }

    @Test
    void rectangleAreaDoesNotThrowTest() {
        Shape rectangle = new Rectangle(0.01, 0.01);
        assertDoesNotThrow(rectangle::displayArea);
    }
}