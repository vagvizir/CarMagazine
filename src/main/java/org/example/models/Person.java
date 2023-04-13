package org.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private double money;

    public Person(String firstName, String lastName, String email, String number, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.money = money;
    }
}
