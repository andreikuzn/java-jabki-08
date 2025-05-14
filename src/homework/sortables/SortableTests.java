package homework.sortables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortableTests {
    @Test
    void personCompareTest() {
        Person person1 = new Person(25);
        Person person2 = new Person(30);
        Person person3 = new Person(20);

        assertTrue(person1.compare(person2) < 0);
        assertTrue(person2.compare(person1) > 0);
        assertTrue(person1.compare(person3) > 0);
        assertEquals(0, person1.compare(person1));
    }

    @Test
    void fileSizeCompareTest() {
        FileSize file1 = new FileSize(500);
        FileSize file2 = new FileSize(700);
        FileSize file3 = new FileSize(300);

        assertTrue(file1.compare(file2) < 0);
        assertTrue(file2.compare(file1) > 0);
        assertTrue(file1.compare(file3) > 0);
        assertEquals(0, file1.compare(file1));
    }

    @Test
    void sortPeopleTest() {
        Sortable[] people = {
                new Person(25),
                new Person(18),
                new Person(42)
        };

        SortUtils.sort(people);

        assertEquals(18, ((Person) people[0]).getAge());
        assertEquals(25, ((Person) people[1]).getAge());
        assertEquals(42, ((Person) people[2]).getAge());
    }

    @Test
    void sortFileSizesTest() {
        Sortable[] files = {
                new FileSize(1000),
                new FileSize(300),
                new FileSize(700)
        };

        SortUtils.sort(files);

        assertEquals(300, ((FileSize) files[0]).getSize());
        assertEquals(700, ((FileSize) files[1]).getSize());
        assertEquals(1000, ((FileSize) files[2]).getSize());
    }

    @Test
    void sortNullArrayTest() {
        assertThrows(IllegalArgumentException.class, () -> SortUtils.sort(null), "Массив не может быть null.");
    }

    @Test
    void sortArrayWithNullElementTest() {
        Sortable[] arrayWithNull = {
                new Person(25),
                null
        };

        assertThrows(IllegalArgumentException.class, () -> SortUtils.sort(arrayWithNull), "Элемент с индексом 1 возвращает null.");
    }

    @Test
    void sortEmptyArrayTest() {
        Sortable[] emptyArray = {};
        assertDoesNotThrow(() -> SortUtils.sort(emptyArray));
    }
}