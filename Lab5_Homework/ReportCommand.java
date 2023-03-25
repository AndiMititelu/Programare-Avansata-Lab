package org.example;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//implements Command
public class ReportCommand implements Command2 {
    @Override
    public void execute(Object obj1, Object obj2) {
        try {
            if(obj1 instanceof Catalog && obj2 instanceof String) {
                // Create a configuration object and set the template directory
                Configuration config = new Configuration(Configuration.VERSION_2_3_31);
                config.setDirectoryForTemplateLoading(new File("templates"));

                // Load the template
                Template template = config.getTemplate("report.ftl");

                // Create a data model with the catalog's contents
                Map<String, Object> data = new HashMap<>();
                data.put("documents", ((Catalog) obj1).getDocuments());

                // Generate the report
                FileWriter writer = new FileWriter((String) obj2);
                template.process(data, writer);
                writer.close();
                System.out.println("Report saved to " + (String) obj2);
            }

        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        } catch (TemplateException e) {
            System.out.println("Error processing template: " + e.getMessage());
        }
    }
}
