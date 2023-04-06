package org.example.models;

public class Person {
    public String firstName;
    public String lastName;
    public String email;
    public String number;
    public double money;

    public Person(String firstName, String lastName, String email, String number, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.money = money;
    }
}
