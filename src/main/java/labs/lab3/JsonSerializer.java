package labs.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import labs.lab1.Ticket;

import java.io.File;

public class JsonSerializer implements Serializer<Ticket> {
    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Реєстрація модуля для Java 8 Date/Time
    }

    @Override
    public void serialize(Ticket ticket, File file) throws Exception {
        objectMapper.writeValue(file, ticket);
    }

    @Override
    public Ticket deserialize(File file) throws Exception {
        return objectMapper.readValue(file, Ticket.class);
    }
}