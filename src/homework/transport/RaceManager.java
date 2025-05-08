package homework.transport;

public class RaceManager {
    public static void startRace(Transport[] vehicles) {
        if (vehicles == null) {
            throw new IllegalArgumentException("Список транспортных средств не может быть пустым.");
        }

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                throw new IllegalArgumentException(String.format("Элемент с индексом %s возвращает null.", i));
            }
            vehicles[i].move();
        }
    }
}