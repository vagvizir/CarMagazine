package org.example;

import org.example.service.CarService;
import org.example.service.PersonService;
import org.example.models.Car;
import org.example.models.Person;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarService carService = new CarService();
        Car carOne = new Car("BMW", 700, 1_000_000);
        Car carTwo = new Car("Mercedes", 500, 1_000_000);

        carService.carDB.add(carOne);
        carService.carDB.add(carTwo);

        PersonService personService = new PersonService();
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);

        personService.personDB.add(person);

        System.out.println("Menu: ");
        System.out.println("1. Добавить машину");
        System.out.println("2. Добавить пользователя");
        System.out.println("3. Купить машину");

        int target = scanner.nextInt();
    }
}
