package labs.lab1;

import labs.lab4.PassengerBuilder;
import labs.lab4.TicketBuilder;
import labs.lab4.TrainBuilder;

public class TestClass {
    public static void main(String[] args) {
        Train train = new TrainBuilder()
                .setTrainNumber("T123")
                .setYearOfManufacture(2010)
                .setLastRepairDate("2024-10-30")
                .setDriverFullName("John Doe")
                .build();

        Passenger passenger = new PassengerBuilder()
                .setName("John")
                .setSurname("Doe")
                .setAge(30)
                .build();

        Ticket ticket1 = new TicketBuilder()
                .setPassenger(passenger)
                .setFlightNumber("A123")
                .setDepartureLocation("New York")
                .setDestinationLocation("Los Angeles")
                .setDepartureDate("2024-01-01")
                .build();

        Ticket ticket2 = new TicketBuilder()
                .setPassenger(passenger)
                .setFlightNumber("A123")
                .setDepartureLocation("New York")
                .setDestinationLocation("Los Angeles")
                .setDepartureDate("2024-01-01")
                .build();

        System.out.println("HashCode - Ticket1: " + ticket1.hashCode());
        System.out.println("Equals - Ticket1 and Ticket2: " + ticket1.equals(ticket2));

        System.out.println(" ");

        System.out.println(train);
        System.out.println(passenger);
        System.out.println(ticket1);
    }
}


