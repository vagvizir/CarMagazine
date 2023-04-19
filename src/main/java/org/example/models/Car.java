package org.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Car {
    private String name;
    private int powerHorse;
    private double price;

    public Car(String name, int powerHorse, double price) {
        this.price = price;
        this.name = name;
        this.powerHorse = powerHorse;
    }
}
