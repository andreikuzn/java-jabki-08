package homework.sounds;

public class CarHorn implements SoundEmitter {
    @Override
    public void makeSound() {
        System.out.println("Автомобиль: Бииип-бииип!");
    }
}