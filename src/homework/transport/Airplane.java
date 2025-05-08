package homework.transport;

public class Airplane extends Transport {
    public Airplane(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.printf("Самолёт летит со скоростью %s км/ч.\n", getSpeed());
    }
}