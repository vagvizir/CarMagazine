package org.example;

import org.example.models.Car;

import java.util.function.Predicate;

public class FilterCarMoney implements Predicate<Car> {
    @Override
    public boolean test(Car car) {
        return car.getPrice() > 499_000;
    }
}
