package homework.sortables;

public class Person implements Sortable {
    private final int age;

    public Person(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст должен быть больше нуля.");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compare(Sortable other) {
        Person person = (Person) other;
        return Integer.compare(this.age, person.age);
    }

    @Override
    public String toString() {
        return String.format("Person(age= %s)", age);
    }
}