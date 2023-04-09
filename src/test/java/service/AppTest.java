package service;

import org.example.service.CarService;
import org.example.service.PersonServiceImpl;
import org.example.models.Car;
import org.example.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void addCarBaseDate() {
        CarService carService = new CarService();
        Car car = new Car("Lada", 100, 200_000);

        carService.carDB.add(car); // size == 1

        Assertions.assertEquals(carService.carDB.size(), 1);
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
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);
        CarService carService = new CarService();

        carService.carDB.add(new Car("Lada", 100, 200_000));
        carService.bayCar(person, 0);

        Assertions.assertEquals(person.money, 1_800_000);
        Assertions.assertTrue(carService.carDB.isEmpty());
    }
}