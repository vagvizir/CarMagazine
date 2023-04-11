package org.example.models;

public class Bike {
    private String model;
    private int power;
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
