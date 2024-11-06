package labs.lab1;

import labs.lab4.TicketBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Клас, що представляє квиток на залізничний транспорт.
 */
public class Ticket implements Comparable<Ticket>{
    private  Passenger passenger;
    private  String flightNumber;
    private  String departureLocation;
    private  String destinationLocation;
    private  String departureDate;

    public Ticket(TicketBuilder builder) {
        this.passenger = builder.passenger;
        this.flightNumber = builder.flightNumber;
        this.departureLocation = builder.departureLocation;
        this.destinationLocation = builder.destinationLocation;
        this.departureDate = builder.departureDate;
    }

    public Ticket() {
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "passenger=" + passenger +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(passenger, ticket.passenger) &&
                flightNumber.equals(ticket.flightNumber) &&
                departureLocation.equals(ticket.departureLocation) &&
                destinationLocation.equals(ticket.destinationLocation) &&
                departureDate.equals(ticket.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, flightNumber, departureLocation, destinationLocation, departureDate);
    }
    @Override
    public int compareTo(Ticket other) {
        return this.departureDate.compareTo(other.departureDate);
    }
}