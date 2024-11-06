package labs.lab3;


import labs.lab1.Ticket;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class YamlSerializer implements Serializer<Ticket> {
    private final Yaml yaml = new Yaml();

    @Override
    public void serialize(Ticket ticket, File file) throws Exception {
        try (FileWriter writer = new FileWriter(file)) {
            yaml.dump(ticket, writer);
        }
    }

    @Override
    public Ticket deserialize(File file) throws Exception {
        try (FileReader reader = new FileReader(file)) {
            return yaml.loadAs(reader, Ticket.class);
        }
    }
}