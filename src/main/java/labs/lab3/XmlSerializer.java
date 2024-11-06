package labs.lab3;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import labs.lab1.Ticket;

import java.io.File;

public class XmlSerializer implements Serializer<Ticket> {
    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule()); // Реєстрація модуля для Java 8 Date/Time
    }

    @Override
    public void serialize(Ticket ticket, File file) throws Exception {
        xmlMapper.writeValue(file, ticket); // Запис об'єкта в файл
    }

    @Override
    public Ticket deserialize(File file) throws Exception {
        return xmlMapper.readValue(file, Ticket.class); // Читання об'єкта з файлу
    }
}
