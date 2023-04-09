package org.example;

import org.example.service.CarService;
import org.example.service.CarServiceImpl;
import org.example.service.PersonServiceImpl;
import org.example.models.Car;
import org.example.models.Person;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarService carService = new CarServiceImpl();
        Car carOne = new Car("BMW", 700, 1_000_000);
        Car carTwo = new Car("Mercedes", 500, 1_000_000);

        carService.saveCar(carOne);
        carService.saveCar(carTwo);

        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        personService.savePerson(person);

        System.out.println("Menu: ");
        System.out.println("1. Добавить машину");
        System.out.println("2. Добавить пользователя");
        System.out.println("3. Купить машину");

        int target = scanner.nextInt();

        System.out.println(Arrays.toString(carService.getCars().toArray()));
        System.out.println(personService.getPerson(0));
    }
}
