package org.example.util;

import org.example.models.Bike;
import org.example.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ModelsFilter {
    public static List<Car> filterCar(List<Car> cars, Predicate<Car> predicate) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }

        return result;
    }

    public static List<Bike> filterBike(List<Bike> bikes, Predicate<Bike> predicate) {
        List<Bike> result = new ArrayList<>();

        for (Bike bike : bikes) {
            if (predicate.test(bike)) {
                result.add(bike);
            }
        }
        return result;
    }
}
