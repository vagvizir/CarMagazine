package org.example;

import jdk.swing.interop.SwingInterOpUtils;
import org.example.dao.BikeDaoJdbcImpl;
import org.example.models.Bike;
import org.example.service.*;
import org.example.models.Car;
import org.example.models.Person;
import org.example.util.Util;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BikeDaoJdbcImpl daoJdbc = new BikeDaoJdbcImpl();
        daoJdbc.createTable();

        CarService carService = new CarServiceImpl();
        Car carOne = new Car("BMW", 700, 1_000_000);
        Car carTwo = new Car("Mercedes", 500, 1_000_000);
        Car carThree = new Car("Mitsubishi", 300, 500_000);
        Car carFo = new Car("Opel", 250, 300_000);
        Car carFive = new Car("Lada", 150, 100_000);

        carService.saveCar(carOne, carThree, carTwo, carFive, carFo);






//        System.out.println(Util.filterCarMoney(carService.getCars()));
//        System.out.println(Util.filterCarPowerHorse(carService.getCars()));
//        System.out.println(Util.filterCarPowerHorseAndMoney(carService.getCars()));

//        Predicate<Car> sortedCarMoney = new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPrice() > 499_000;
//            }
//        };
//
//        Predicate<Car> sortedCarPowerHorse = new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPowerHorse() > 200;
//            }
//        };
//
//        Predicate<Car> sortedCarMoneyAndPowerHorse = new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPowerHorse() <= 300 && car.getPrice() <= 500_000;
//            }
//        };
//
//        System.out.println(Util.filterCar(carService.getCars(), sortedCarMoney));
//        System.out.println(Util.filterCar(carService.getCars(), sortedCarPowerHorse));
//        System.out.println(Util.filterCar(carService.getCars(), sortedCarMoneyAndPowerHorse));

//        System.out.println(Util.filterCar(carService.getCars(), new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPrice() > 499_000;
//            }
//        }));
//
//        System.out.println(Util.filterCar(carService.getCars(), new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPowerHorse() > 200;
//            }
//        }));
//
//        System.out.println(Util.filterCar(carService.getCars(), new Predicate<Car>() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPowerHorse() <= 300 && car.getPrice() <= 500_000;
//            }
//        }));

//        Predicate
//                                                                      boolean test(T t);

        System.out.println(Util.filterCar(carService.getCars(),
                (car) -> car.getPrice() > 499_000));
        System.out.println(Util.filterCar(carService.getCars(),
                (car) -> car.getPowerHorse() > 200));
        System.out.println(Util.filterCar(carService.getCars(),
                (car) -> car.getPowerHorse() <= 300 && car.getPrice() <= 500_000));








        BikeService bikeService = new BikeServiceImpl();
        Bike bikeOne = new Bike("Kawasaki", 200, 500_000);
        Bike bikeTwo = new Bike("Suzuki", 190, 450_000);
        Bike bikeThree = new Bike("Honda", 150, 430_000);
        Bike bikeFour = new Bike("Alpina", 230, 330_000);
        Bike bikeFive = new Bike("Java", 100, 150_000);

        bikeService.saveBike(bikeOne, bikeTwo, bikeThree, bikeFour, bikeFive);

        System.out.println(Util.filterBike(bikeService.getBikes(),
                (bike -> bike.getPrice() > 330_000)));
        System.out.println(Util.filterBike(bikeService.getBikes(),
                (bike -> bike.getPower() < 190)));
        System.out.println(Util.filterBike(bikeService.getBikes(),
                (bike -> bike.getPower() > 150 && bike.getPrice() > 450_000)));


        PersonServiceImpl personService = new PersonServiceImpl();
        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                "8800 555 55 55", 2_000_000);
        personService.savePerson(person);

        Person persontwo = new Person("Mike", "Smith", "Mike32d@gmail.com",
                "+1(545)452-7831", 3_500_000);
        personService.savePerson(persontwo);

//
//        System.out.println("Menu: ");
//        System.out.println("1. Добавить машину");
//        System.out.println("2. Добавить пользователя");
//        System.out.println("3. Купить машину");
//
//        int target = scanner.nextInt();
//
//        System.out.println(Arrays.toString(carService.getCars().toArray()));
//        System.out.println(personService.getPerson(0));
//
//        System.out.println(Arrays.toString(bikeService.getBikes().toArray()));
//        System.out.println((personService.getPerson(1)));


    }
}
