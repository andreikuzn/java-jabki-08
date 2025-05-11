package homework.files;

public class TextFile extends File {
    private String content;

    public TextFile(String name, String content) {
        super(name);
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Содержимое не может быть пустым.");
        }
        this.content = content;
    }

    @Override
    public long getSize() {
        return content.length();
    }
}