package org.example.models;

public class Car {
    public String name;
    public int powerHorse;
    public double price;

    public Car(String name, int powerHorse, double price) {
        this.price = price;
        this.name = name;
        this.powerHorse = powerHorse;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", powerHorse=" + powerHorse +
                ", price=" + price +
                '}';
    }
}
