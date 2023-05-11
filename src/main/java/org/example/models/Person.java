package org.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int number;
    private double money;

    public Person(int id, String firstName, String lastName, String email, int number, double money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.money = money;
    }
}
