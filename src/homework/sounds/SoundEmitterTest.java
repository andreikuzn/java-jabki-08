package homework.sounds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoundEmitterTest {
    @Test
    void dogMakesSoundTest() {
        SoundEmitter dog = new Dog();
        assertDoesNotThrow(dog::makeSound);
    }

    @Test
    void alarmClockMakesSoundTest() {
        SoundEmitter alarmClock = new AlarmClock();
        assertDoesNotThrow(alarmClock::makeSound);
    }

    @Test
    void carHornMakesSoundTest() {
        SoundEmitter carHorn = new CarHorn();
        assertDoesNotThrow(carHorn::makeSound);
    }

    @Test
    void playAllSoundsWithValidArrayTest() {
        SoundEmitter[] devices = {
                new Dog(),
                new AlarmClock(),
                new CarHorn()
        };
        assertDoesNotThrow(() -> SoundPlayer.playAllSounds(devices));
    }

    @Test
    void playAllSoundsWithNullArrayTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SoundPlayer.playAllSounds(null));
        assertEquals("Массив не может быть null.", exception.getMessage());
    }

    @Test
    void playAllSoundsWithNullElementTest() {
        SoundEmitter[] devices = {
                new Dog(),
                null,
                new CarHorn()
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SoundPlayer.playAllSounds(devices));
        assertEquals("Элемент с индексом 1 является null.", exception.getMessage());
    }
}