package homework.sortables;

import java.util.Arrays;

public class SortUtils {
    public static void sort(Sortable[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не может возвращать null.");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new IllegalArgumentException(String.format("Элемент с индексом %s возвращает null.", i));
            }
        }

        Arrays.sort(array, Sortable::compare);
    }
}