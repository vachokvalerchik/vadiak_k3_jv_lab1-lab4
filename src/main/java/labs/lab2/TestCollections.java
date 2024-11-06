package labs.lab2;


import labs.lab1.Passenger;
import labs.lab1.Ticket;
import labs.lab1.Train;
import labs.lab4.PassengerBuilder;
import labs.lab4.TicketBuilder;
import labs.lab4.TrainBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        Service service = new Service();

        // Створення списку квитків
        List<Ticket> tickets = new ArrayList<>();

        Passenger passenger1 = new PassengerBuilder()
                .setName("John")
                .setSurname("Doe")
                .setAge(30)
                .build();

        tickets.add(new TicketBuilder()
                .setPassenger(passenger1)
                .setFlightNumber("A123")
                .setDepartureLocation("New York")
                .setDestinationLocation("Los Angeles")
                .setDepartureDate("2024-10-31")
                .build());

        Passenger passenger2 = new PassengerBuilder()
                .setName("Jane")
                .setSurname("Smith")
                .setAge(25)
                .build();

        tickets.add(new TicketBuilder()
                .setPassenger(passenger2)
                .setFlightNumber("B456")
                .setDepartureLocation("Chicago")
                .setDestinationLocation("Miami")
                .setDepartureDate("2024-10-31")
                .build());

        // Отримання відсортованих квитків за датою відправлення
        List<Ticket> sortedTickets = service.getSortedTicketsByDepartureDate(tickets);
        System.out.println("Sorted Tickets by Departure Date:");
        sortedTickets.forEach(System.out::println);

        // Створення списку поїздів
        List<Train> trains = new ArrayList<>();

        trains.add(new TrainBuilder()
                .setTrainNumber("T001")
                .setYearOfManufacture(2015)
                .setLastRepairDate("2024-11-11")
                .setDriverFullName("Alex Johnson")
                .build());

        trains.add(new TrainBuilder()
                .setTrainNumber("T002")
                .setYearOfManufacture(2010)
                .setLastRepairDate("2024-06-11")
                .setDriverFullName("Mike Brown")
                .build());

        // Отримання відсортованих поїздів за роком виробництва
        List<Train> sortedTrains = service.getSortedTrainsByYear(trains);
        System.out.println("\nSorted Trains by Year of Manufacture:");
        sortedTrains.forEach(System.out::println);

        // Фільтрація квитків за місцем призначення
        List<Ticket> filteredTickets = service.filterTicketsByDestination(tickets, "Miami");
        System.out.println("\nFiltered Tickets to Miami:");
        filteredTickets.forEach(System.out::println);
    }
}
