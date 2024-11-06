package labs.lab4;

import labs.lab1.Passenger;
import labs.lab1.Ticket;
import labs.lab1.Train;

import java.time.LocalDate;


public class TestBuilder {
    public static void main(String[] args) {
        testValidTrainBuilder();
        testInvalidTrainBuilder();

        testValidTicketBuilder();
        testInvalidTicketBuilder();
    }

    private static void testValidTrainBuilder() {
        try {
            Train train = new TrainBuilder()
                    .setTrainNumber("T123")
                    .setYearOfManufacture(2010)
                    .setLastRepairDate("2024-10-30")
                    .setDriverFullName("John Doe")
                    .build();

            System.out.println("Valid Train: " + train);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create valid train: " + e.getMessage());
        }
    }

    private static void testInvalidTrainBuilder() {
        try {
            Train invalidTrain = new TrainBuilder()
                    .setTrainNumber("") // Не валідне значення
                    .setYearOfManufacture(1800) // Не валідне значення
                    .setLastRepairDate("2024-01-01") // Не валідне значення
                    .setDriverFullName("") // Не валідне значення
                    .build();

        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected exception for invalid train: " + e.getMessage());
        }

        try {
            Train invalidTrain = new TrainBuilder()
                    .setTrainNumber("T123")
                    .setYearOfManufacture(2025) // Не валідне значення
                    .setLastRepairDate("2024-01-01")
                    .setDriverFullName("Jane") // Не валідне значення
                    .build();

            System.err.println(invalidTrain); // Цей рядок не повинен виконуватись
        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected exception for invalid driver name: " + e.getMessage());
        }
    }

    private static void testValidTicketBuilder() {
        try {
            // Створення пасажира
            Passenger passenger = new PassengerBuilder()
                    .setName("John")
                    .setSurname("Doe")
                    .setAge(30)
                    .build();

            // Створення квитка
            Ticket ticket = new TicketBuilder()
                    .setPassenger(passenger)
                    .setFlightNumber("A123")
                    .setDepartureLocation("New York")
                    .setDestinationLocation("Los Angeles")
                    .setDepartureDate("2024-01-01")
                    .build();

            System.out.println("Valid Ticket: " + ticket);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create valid ticket: " + e.getMessage());
        }
    }

    private static void testInvalidTicketBuilder() {
        try {
            // Спроба створити квиток без пасажира
            Ticket invalidTicket = new TicketBuilder()
                    .setFlightNumber("B456")
                    .setDepartureLocation("Chicago")
                    .setDestinationLocation("Miami")
                    .setDepartureDate("2024-01-01")
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected exception for invalid ticket: " + e.getMessage());
        }

        try {
            // Спроба створити квиток з невалідним номером рейсу
            Passenger passenger = new PassengerBuilder()
                    .setName("Jane")
                    .setSurname("Smith")
                    .setAge(25)
                    .build();

            Ticket invalidTicket = new TicketBuilder()
                    .setPassenger(passenger)
                    .setFlightNumber("") // Не валідне значення
                    .setDepartureLocation("Seattle")
                    .setDestinationLocation("San Francisco")
                    .setDepartureDate("2024-01-01")
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected exception for invalid flight number: " + e.getMessage());
        }

        try {
            // Спроба створити квиток з невалідною датою відправлення
            Ticket invalidTicket = new TicketBuilder()
                    .setPassenger(new PassengerBuilder().setName("Mark").setSurname("Johnson").setAge(40).build())
                    .setFlightNumber("C789")
                    .setDepartureLocation("Boston")
                    .setDestinationLocation("Houston")
                    .setDepartureDate("2024-01-01") // Не валідне значення
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected exception for invalid departure date: " + e.getMessage());
        }
    }
}