package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Car {
    private int id;
    private String model;
    private int powerHorse;
    private double price;

    public Car(int id, String model, int powerHorse, double price) {
        this.id = id;
        this.model = model;
        this.powerHorse = powerHorse;
        this.price = price;
    }
}
