package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command2{

    @Override
    public void execute(Object obj1, Object obj2) throws IOException {
        if(obj1 instanceof Catalog && obj2 instanceof String) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File((String) obj2), (Catalog) obj1);
        }
    }
}
