import homework.files.File;
import homework.files.FileUtils;
import homework.files.ImageFile;
import homework.files.TextFile;
import homework.shapes.Circle;
import homework.shapes.Rectangle;
import homework.shapes.Shape;
import homework.sortables.FileSize;
import homework.sortables.Person;
import homework.sortables.SortUtils;
import homework.sortables.Sortable;
import homework.sounds.*;
import homework.transport.Airplane;
import homework.transport.Bicycle;
import homework.transport.RaceManager;
import homework.transport.Transport;
import workshop.payable.Playable;
import workshop.payable.Song;
import workshop.payment.CreditCardPayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * Абстрактный класс
         */

        /**
         * Абстрактный класс — это класс, который не может быть создан напрямую, и может содержать абстрактные методы (без реализации).
         *
         * Может содержать обычные методы с реализацией.
         * Может содержать поля.
         * Используется, когда нужно задать общее поведение + частично оставить реализацию подклассам.
         */
        CreditCardPayment payment = new CreditCardPayment(BigDecimal.TEN);
        payment.validate();
        payment.process();
        payment.complete();

        /**
         * Почему абстрактный класс здесь уместен?
         * Есть общее поведение для всех видов платежей: validate(), complete()
         * Метод processPayment() — обязательный, но зависит от реализации
         * Можно создавать новые типы оплаты (например, CryptoPayment) без переписывания остального кода.
         */

        /**
         * Интерфейсы (interface + implements)
         */

        /**
         * Интерфейс — это контракт поведения, который должен реализовать класс.
         * Он содержит только сигнатуры методов (по умолчанию).
         *
         * Нельзя хранить поля (кроме констант)
         * Класс реализует интерфейс с помощью implements
         * Класс может реализовывать несколько интерфейсов.
         */
        Song song = new Song("Песня про лето");
        song.play();

        Playable playable = new Song("Песня про весну!");
        playable.play();

        List<String> list = new ArrayList<>();

        /**
         * Все медиафайлы реализуют один контракт поведения — метод play().
         * Их можно группировать в общий список и воспроизводить единым способом, не зная, что это конкретно.
         */

        /**
         * Сравнение
         */

        /**
         * Используй абстрактный класс, если ты хочешь:
         * - зафиксировать часть поведения, но оставить реализацию остального на подклассы;
         * - объединить родственные классы с общими полями и логикой;
         * - дать конструктор или поля по умолчанию.
         **
         * Используй интерфейс, если ты хочешь:
         * - указать, что класс должен уметь делать, создать "поведенческий контракт";
         * - обеспечить множественное наследование поведения (Java допускает только один суперкласс, но много интерфейсов);
         *
         * Хочешь задать структуру + поведение? → Абстрактный класс
         * Хочешь задать только поведение? → Интерфейс
         */

        /**
         * Продвинутый уровень владения Java заключается в комбинирование этих подходов!
         */

        /**
         * Итоги (ООП)
         *
         * Класс это шаблон, а Объект его экземпляр
         *
         * 1. Инкапсуляция - скрываем детали реализации, предоставляем интерфейс
         * Модификаторы доступа (private, пустой, protected, public)
         *
         * 2. Наследование - новый класс наследует поведение и свойства родителя
         * extends
         *
         * 3. Полиморфизм - "Один интерфейс — много реализаций"
         * animal.makeSound() работает по-разному
         *
         * 4. Абстракция - работаем с сущностями через общие понятия, не детали
         * abstract class, interface
         */

        /**
         * ДЗ 8
         */

        // Фигуры
        Shape[] shapes = new Shape[] {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Circle(3.2),
                new Rectangle(2.5, 1.5)
        };

        for (Shape shape : shapes) {
            shape.displayArea();
        }

        System.out.println();

        // Звуки
        SoundEmitter[] soundDevices = new SoundEmitter[] {
                new Dog(),
                new AlarmClock(),
                new CarHorn()
        };
        SoundPlayer.playAllSounds(soundDevices);

        System.out.println();

        // Файлы
        File[] files = new File[] {
                new TextFile(" readme.txt ", "Пример текста"),
                new ImageFile("photo.jpg", 800, 600, 3),
                new TextFile("notes.txt", "Ещё один файл")
        };

        long totalSize = FileUtils.calculateTotalSize(files);
        System.out.printf("Общий размер всех файлов: %s байт\n", totalSize);

        System.out.println();

        // Транспорт
        Transport[] participants = new Transport[] {
                new Bicycle(25),
                new Airplane(800)
        };

        RaceManager.startRace(participants);

        System.out.println();

        // Сортировка
        Sortable[] people = {
                new Person(25),
                new Person(18),
                new Person(42)
        };

        Sortable[] file = {
                new FileSize(1000),
                new FileSize(300),
                new FileSize(700)
        };

        SortUtils.sort(people);
        SortUtils.sort(file);

        System.out.println("Сортировка по возрасту: " + Arrays.toString(people));
        System.out.println("Сортировка по размеру файла: " + Arrays.toString(file));
    }
}