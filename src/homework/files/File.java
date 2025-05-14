package homework.files;

public abstract class File {
    private String name;

    public File(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым или состоять из пробелов.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();
}