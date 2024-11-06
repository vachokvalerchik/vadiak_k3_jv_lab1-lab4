package labs.lab1;

import labs.lab4.PassengerBuilder;

import java.util.Objects;

/**
 * Клас, що представляє пасажира залізничного транспорту.
 */
public class Passenger {
    private  String name;
    private  String surname;
    private  int age;

    public Passenger(PassengerBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
    }

    public Passenger() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return age == passenger.age &&
                name.equals(passenger.name) &&
                surname.equals(passenger.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}