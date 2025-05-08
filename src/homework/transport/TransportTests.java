package homework.transport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransportTests {
    @Test
    void bicycleMoveTest() {
        Bicycle bike = new Bicycle(20);
        assertEquals(20, bike.getSpeed());
    }

    @Test
    void airplaneMoveTest() {
        Airplane plane = new Airplane(900);
        assertEquals(900, plane.getSpeed());
    }

    @Test
    void invalidBicycleSpeedTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bicycle(0));
        assertTrue(exception.getMessage().contains("Скорость"));
    }

    @Test
    void invalidAirplaneSpeedTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Airplane(-100));
        assertTrue(exception.getMessage().contains("Скорость"));
    }

    @Test
    void startRaceWithValidVehiclesTest() {
        Transport[] vehicles = {
                new Bicycle(15),
                new Airplane(700)
        };

        assertDoesNotThrow(() -> RaceManager.startRace(vehicles));
    }

    @Test
    void startRaceWithNullArrayTest() {
        assertThrows(IllegalArgumentException.class, () -> RaceManager.startRace(null));
    }

    @Test
    void startRaceWithNullElementTest() {
        Transport[] vehicles = {
                new Bicycle(15),
                null
        };

        Exception ex = assertThrows(IllegalArgumentException.class, () -> RaceManager.startRace(vehicles));
        assertTrue(ex.getMessage().contains("Элемент с индексом"));
    }
}