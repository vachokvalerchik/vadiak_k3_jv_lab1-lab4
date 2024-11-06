package labs.lab4;

import labs.lab1.Passenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Статичний клас Builder для створення об'єктів типу Passenger з валідацією полів.
 */
public class PassengerBuilder {
    public String name;
    public String surname;
    public int age;

    public PassengerBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name: cannot be null or empty.");
        }
        this.name = name;
        return this;
    }

    public PassengerBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Invalid surname: cannot be null or empty.");
        }
        this.surname = surname;
        return this;
    }

    public PassengerBuilder setAge(int age) {
        if (age < 0 || age > 120) { // Припустимо, що максимальний вік - 120 років
            throw new IllegalArgumentException("Invalid age: must be between 0 and 120.");
        }
        this.age = age;
        return this;
    }

    public Passenger build() {
        List<String> invalidFields = new ArrayList<>();

        if (name == null || name.isEmpty()) {
            invalidFields.add("name");
        }

        if (surname == null || surname.isEmpty()) {
            invalidFields.add("surname");
        }

        if (age < 0 || age > 120) {
            invalidFields.add("age");
        }

        if (!invalidFields.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + invalidFields);
        }

        return new Passenger(this);
    }
}
