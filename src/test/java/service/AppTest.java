package service;

import org.example.service.*;
import org.example.models.Car;
import org.example.models.Person;
import org.example.models.Bike;
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

        try {
            удаление таблицы;
            Assertions.assertEquals(1, 1);
        } catch () {
            Assertions.assertEquals(1, 2);
        }
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

    @Test
    void getBikeMaxMinPricePower() {
        BikeService bikeService1 = new BikeServiceImpl();

        Bike bikeOne = new Bike("BMW", 230, 1_900_000);
        Bike bikeTwo = new Bike("Honda", 249, 1_850_000);

        bikeService1.saveBike(bikeOne, bikeTwo);

        assertEquals(bikeService1.getMaxBikePrice(), bikeOne);
        assertEquals(bikeService1.getMinBikePrice(),bikeTwo);
        assertEquals(bikeService1.getMinBikePower(),bikeOne);
        assertEquals(bikeService1.getMaxBikePower(),bikeTwo);
        // как передать bikeOne и bikeTwo из util / App / bikeServiceImpl или так не надо передавать?
    }

    @Test
    void getCarMaxMinPricePower() {
        CarService carService1 = new CarServiceImpl();

        Car carOne = new Car("Lada", 107, 1_200_000);
        Car carTwo = new Car("Cherry", 126, 3_200_000);

        carService1.saveCar(carOne, carTwo);

        assertEquals(carService1.getMaxCarPrice(), carTwo);
        assertEquals(carService1.getMinCarPrice(), carOne);
        assertEquals(carService1.getMaxCarPower(), carTwo);
        assertEquals(carService1.getMinCarPower(), carOne);
    }
}
