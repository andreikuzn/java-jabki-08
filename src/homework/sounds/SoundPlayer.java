package homework.sounds;

public class SoundPlayer {
    public static void playAllSounds(SoundEmitter[] devices) {
        if (devices == null) {
            throw new IllegalArgumentException("Массив не может быть null.");
        }
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] == null) {
                throw new IllegalArgumentException("Элемент с индексом " + i + " является null.");
            }
            devices[i].makeSound();
        }
    }
}