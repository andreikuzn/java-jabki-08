package homework.sounds;

public class Dog implements SoundEmitter {
    @Override
    public void makeSound() {
        System.out.println("Собака: Гав-гав!");
    }
}