package labs.lab3;

import labs.lab1.Passenger;
import labs.lab1.Ticket;
import labs.lab4.PassengerBuilder;
import labs.lab4.TicketBuilder;

import java.io.File;
import java.time.LocalDateTime;

public class TestSerialize {
    public static void main(String[] args) {
        try {
            // Створення об'єкта Ticket
            Passenger passenger = new PassengerBuilder()
                    .setName("John")
                    .setSurname("Doe")
                    .setAge(30)
                    .build();

            Ticket ticket = new TicketBuilder()
                    .setPassenger(passenger)
                    .setFlightNumber("A123")
                    .setDepartureLocation("New York")
                    .setDestinationLocation("Los Angeles")
                    .setDepartureDate("2024-10-30")
                    .build();

            // Вказуємо директорію для зберігання файлів
            String directoryPath = System.getProperty("user.dir") + "\\src\\main\\java\\labs\\lab3\\file";
            File directory = new File(directoryPath);

            // Створюємо директорію, якщо вона не існує
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Серіалізація в JSON
            JsonSerializer jsonSerializer = new JsonSerializer();
            File jsonFile = new File(directory, "ticket.json");
            jsonSerializer.serialize(ticket, jsonFile);
            System.out.println("Ticket serialized to JSON.");

            // Десеріалізація з JSON
            Ticket deserializedTicketFromJson = jsonSerializer.deserialize(jsonFile);
            System.out.println("Deserialized from JSON: " + deserializedTicketFromJson);

            // Серіалізація в XML
            XmlSerializer xmlSerializer = new XmlSerializer();
            File xmlFile = new File(directory, "ticket.xml");
            xmlSerializer.serialize(ticket, xmlFile);
            System.out.println("Ticket serialized to XML.");

            // Десеріалізація з XML
            Ticket deserializedTicketFromXml = xmlSerializer.deserialize(xmlFile);
            System.out.println("Deserialized from XML: " + deserializedTicketFromXml);

            // Серіалізація в YAML
            YamlSerializer yamlSerializer = new YamlSerializer();
            File yamlFile = new File(directory, "ticket.yaml");
            yamlSerializer.serialize(ticket, yamlFile);
            System.out.println("Ticket serialized to YAML.");

            // Десеріалізація з YAML
            Ticket deserializedTicketFromYaml = yamlSerializer.deserialize(yamlFile);
            System.out.println("Deserialized from YAML: " + deserializedTicketFromYaml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}