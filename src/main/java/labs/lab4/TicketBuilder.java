package labs.lab4;


import labs.lab1.Passenger;
import labs.lab1.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Статичний клас Builder для створення об'єктів типу Ticket з валідацією полів.
 */
public class TicketBuilder {
    public Passenger passenger;
    public String flightNumber;
    public String departureLocation;
    public String destinationLocation;
    public String departureDate;

    public TicketBuilder setPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Invalid passenger: cannot be null.");
        }
        this.passenger = passenger;
        return this;
    }

    public TicketBuilder setFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid flight number: cannot be null or empty.");
        }
        // Можна додати регулярний вираз для перевірки формату номера рейсу
        if (!flightNumber.matches("^[A-Z]{1,2}\\d{1,4}$")) { // Наприклад, формат "A123" або "AB1234"
            throw new IllegalArgumentException("Invalid flight number: must match pattern [A-Z]{1,2}\\d{1,4}.");
        }
        this.flightNumber = flightNumber;
        return this;
    }

    public TicketBuilder setDepartureLocation(String departureLocation) {
        if (departureLocation == null || departureLocation.isEmpty()) {
            throw new IllegalArgumentException("Invalid departure location: cannot be null or empty.");
        }
        this.departureLocation = departureLocation;
        return this;
    }

    public TicketBuilder setDestinationLocation(String destinationLocation) {
        if (destinationLocation == null || destinationLocation.isEmpty()) {
            throw new IllegalArgumentException("Invalid destination location: cannot be null or empty.");
        }
        this.destinationLocation = destinationLocation;
        return this;
    }

    public TicketBuilder setDepartureDate(String departureDate) {
        if (departureDate == null || departureDate.isEmpty()) {
            throw new IllegalArgumentException("Invalid departure date: cannot be null or in the past.");
        }
        this.departureDate = departureDate;
        return this;
    }

    public Ticket build() {
        List<String> invalidFields = new ArrayList<>();

        if (passenger == null) {
            invalidFields.add("passenger");
        }

        if (flightNumber == null || flightNumber.isEmpty()) {
            invalidFields.add("flight number");
        } else if (!flightNumber.matches("^[A-Z]{1,2}\\d{1,4}$")) {
            invalidFields.add("flight number");
        }

        if (departureLocation == null || departureLocation.isEmpty()) {
            invalidFields.add("departure location");
        }

        if (destinationLocation == null || destinationLocation.isEmpty()) {
            invalidFields.add("destination location");
        }

        if (departureDate == null || departureDate.isEmpty()) {
            invalidFields.add("departure date");
        }

        if (!invalidFields.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + invalidFields);
        }

        return new Ticket(this);
    }
}
