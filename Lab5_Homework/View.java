package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class View implements Command1 {
    @Override
    public void execute(Object obj1) {
        if (obj1 instanceof Document) {
            try {
                String location = ((Document) obj1).getLocation();
                File file = new File(location);
                if (!file.exists()) {
                    System.out.println("Error: " + location + " doesn't exist!");
                    return;
                }
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                System.out.println("Error opening document!!!");
            }
        }
    }
}
