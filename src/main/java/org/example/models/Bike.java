package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bike {
    private String model;
    private int power;
    private double price;

    public Bike(String model, int power, double price) {
        this.model = model;
        this.power = power;
        this.price = price;
    }
}
