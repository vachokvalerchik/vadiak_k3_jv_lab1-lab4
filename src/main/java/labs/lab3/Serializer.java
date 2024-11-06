package labs.lab3;

import java.io.File;

public interface Serializer<T> {
    void serialize(T object, File file) throws Exception;
    T deserialize(File file) throws Exception;
}
