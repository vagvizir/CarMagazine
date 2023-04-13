package service;

import org.example.service.CarService;
import org.example.service.CarServiceImpl;
import org.example.service.PersonService;
import org.example.service.PersonServiceImpl;
import org.example.models.Car;
import org.example.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    void addCarBaseDate() {
        CarService carService = new CarServiceImpl();
        Car car = new Car("Lada", 100, 200_000);

        carService.saveCar(car); // size == 1

        assertEquals(carService.sizeDB(), 1);
    }

    @Test
    void addPersonBaseDate() {
        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        personService.savePerson(person);

        assertEquals(personService.getPerson(0), person);
    }

    @Test
    void bayCar() {
        CarService carService = new CarServiceImpl();

        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        carService.saveCar(new Car("Lada", 100, 200_000));
        carService.bayCar(person, 0);

        assertEquals(person.getMoney(), 1_800_000);
        assertEquals(carService.sizeDB(), 0);
    }

    @Test
    void getPersonMaxAndMinMoney() {
        PersonService personService = new PersonServiceImpl();

        Person personTwo = new Person("Mike", "Smith", "Mike32d@gmail.com",
                "+1(545)452-7831", 3_500_000);
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        personService.savePerson(person, personTwo);

        assertEquals(personService.getMaxMoneyPerson(), personTwo);
        assertEquals(personService.getMinMoneyPerson(), person);
    }
}
