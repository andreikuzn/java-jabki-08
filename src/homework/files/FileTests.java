package homework.files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileTests {
    @Test
    void textFileSizeTest() {
        TextFile textFile = new TextFile("document.txt", "Hello World!");
        long expectedSize = "Hello World!".getBytes().length;
        assertEquals(expectedSize, textFile.getSize());
    }

    @Test
    void imageFileSizeTest() {
        ImageFile imageFile = new ImageFile("image.png", 100, 200, 4);
        long expectedSize = 100L * 200 * 4;
        assertEquals(expectedSize, imageFile.getSize());
    }

    @Test
    void calculateTotalSizeTest() {
        File[] files = new File[] {
                new TextFile("file1.txt", "ABC"), // 3 bytes
                new ImageFile("img.png", 10, 10, 1) // 100 bytes
        };

        long expectedTotal = 3 + 100;
        assertEquals(expectedTotal, FileUtils.calculateTotalSize(files));
    }

    @Test
    void invalidFileNameNullTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new TextFile(null, "content"));
        assertTrue(ex.getMessage().contains("Имя файла"));
    }

    @Test
    void invalidFileNameBlankTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ImageFile("   ", 1, 1, 1));
        assertTrue(ex.getMessage().contains("Имя файла"));
    }

    @Test
    void invalidTextContentNullTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new TextFile("a.txt", null));
        assertTrue(ex.getMessage().contains("Содержимое"));
    }

    @Test
    void invalidImageDimensionsTest() {
        assertThrows(IllegalArgumentException.class, () -> new ImageFile("img.png", 0, 100, 3));
        assertThrows(IllegalArgumentException.class, () -> new ImageFile("img.png", 100, -1, 3));
        assertThrows(IllegalArgumentException.class, () -> new ImageFile("img.png", 100, 100, 0));
    }

    @Test
    void nullArrayInFileUtilsTest() {
        assertThrows(IllegalArgumentException.class, () -> FileUtils.calculateTotalSize(null));
    }

    @Test
    void nullFileElementInArrayTest() {
        File[] files = new File[] {
                new TextFile("file.txt", "data"),
                null
        };
        assertThrows(IllegalArgumentException.class, () -> FileUtils.calculateTotalSize(files));
    }
}