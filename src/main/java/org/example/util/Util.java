package org.example.util;

import org.example.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Util {
    public static List<Car> filterCar(List<Car> cars, Predicate<Car> predicate) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }

        return result;
    }

//    public static List<Car> filterCarPowerHorse(List<Car> cars) {
//        List<Car> result = new ArrayList<>();
//
//        for (Car car : cars) {
//            if (car.getPowerHorse() > 200) {
//                result.add(car);
//            }
//        }
//
//        return result;
//    }
//
//    public static List<Car> filterCarPowerHorseAndMoney(List<Car> cars) {
//        List<Car> result = new ArrayList<>();
//
//        for (Car car : cars) {
//            if (car.getPowerHorse() <= 300 && car.getPrice() <= 500_000) {
//                result.add(car);
//            }
//        }
//
//        return result;
//    }
}
