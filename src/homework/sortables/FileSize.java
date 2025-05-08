package homework.sortables;

public class FileSize implements Sortable {
    private final long size;

    public FileSize(long size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер должен быть больше нуля.");
        }
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    @Override
    public int compare(Sortable other) {
        FileSize fileSize = (FileSize) other;
        return Long.compare(this.size, fileSize.size);
    }

    @Override
    public String toString() {
        return String.format("FileSize(size= %s)", size);
    }
}