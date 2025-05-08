package homework.files;

public class FileUtils {
    public static long calculateTotalSize(File[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Массив файлов не может быть пустым.");
        }

        long total = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                throw new IllegalArgumentException(String.format("Файл на позиции %s возвращает null.", i));
            }
            total += files[i].getSize();
        }
        return total;
    }
}