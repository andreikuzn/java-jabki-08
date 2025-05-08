package homework.transport;

public class Bicycle extends Transport {
    public Bicycle(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.printf("Велосипед едет со скоростью %s км/ч.\n", getSpeed());
    }
}