package service;

import org.example.service.CarService;
import org.example.service.CarServiceImpl;
import org.example.service.PersonServiceImpl;
import org.example.models.Car;
import org.example.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void addCarBaseDate() {
        CarService carService = new CarServiceImpl();
        Car car = new Car("Lada", 100, 200_000);

        carService.saveCar(car); // size == 1

        Assertions.assertEquals(carService.sizeDB(), 1);
    }

    @Test
    void addPersonBaseDate() {
        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        personService.savePerson(person);

        Assertions.assertEquals(personService.getPerson(0), person);
    }

    @Test
    void bayCar() {
        CarService carService = new CarServiceImpl();

        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        carService.saveCar(new Car("Lada", 100, 200_000));
        carService.bayCar(person, 0);

        Assertions.assertEquals(person.money, 1_800_000);
        Assertions.assertEquals(carService.sizeDB(), 0);
    }
}
