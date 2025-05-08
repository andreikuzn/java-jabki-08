package homework.transport;

public abstract class Transport {
    private int speed;

    public Transport(int speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорость должна быть больше нуля.");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void move();
}