package labs.lab2;


import labs.lab1.Ticket;
import labs.lab1.Train;

import java.util.*;
import java.util.stream.Collectors;

public class Service {

    // Метод для отримання всіх квитків, відсортованих за датою відправлення
    public List<Ticket> getSortedTicketsByDepartureDate(List<Ticket> tickets) {
        return tickets.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Метод для отримання всіх поїздів, відсортованих за роком виробництва
    public List<Train> getSortedTrainsByYear(List<Train> trains) {
        return trains.stream()
                .sorted(Train.YearOfManufactureComparator)
                .collect(Collectors.toList());
    }

    // Метод для фільтрації квитків за місцем призначення
    public List<Ticket> filterTicketsByDestination(List<Ticket> tickets, String destination) {
        return tickets.stream()
                .filter(ticket -> ticket.getDestinationLocation().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }
}
