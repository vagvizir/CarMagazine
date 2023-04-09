package org.example.models;

public class Bike {
    public String model;
    public int power;
    public double price;

    public Bike(String model, int power, double price) {
        this.model = model;
        this.power = power;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model = '" + model + '\'' +
                ", power = " + power +
                ", price = " + price +
                '}';
    }
}
