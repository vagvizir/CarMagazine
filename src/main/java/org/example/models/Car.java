package org.example.models;

public class Car {
    private String name;
    private int powerHorse;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerHorse() {
        return powerHorse;
    }

    public void setPowerHorse(int powerHorse) {
        this.powerHorse = powerHorse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
