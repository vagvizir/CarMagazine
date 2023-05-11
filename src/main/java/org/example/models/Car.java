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
    private String name;
    private int powerHorse;
    private double price;

    public Car(int id, String name, int powerHorse, double price) {
        this.id = id;
        this.name = name;
        this.powerHorse = powerHorse;
        this.price = price;
    }
}
