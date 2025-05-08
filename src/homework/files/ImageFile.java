package homework.files;

public class ImageFile extends File {
    private int width;
    private int height;
    private int bytesPerPixel;

    public ImageFile(String name, int width, int height, int bytesPerPixel) {
        super(name);
        if (width <= 0 || height <= 0 || bytesPerPixel <= 0) {
            throw new IllegalArgumentException("Ширина, высота и байты на пиксель должны быть больше нуля.");
        }
        this.width = width;
        this.height = height;
        this.bytesPerPixel = bytesPerPixel;
    }

    @Override
    public long getSize() {
        return (long) width * height * bytesPerPixel;
    }
}