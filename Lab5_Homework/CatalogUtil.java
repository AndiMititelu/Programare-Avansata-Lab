package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;

public class CatalogUtil {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static void save(Catalog catalog, String path) throws IOException {
        mapper.writeValue(new File(path), catalog);
    }
    public static Catalog load(String path) throws IOException {
        return mapper.readValue(new File(path), Catalog.class);
    }

}
