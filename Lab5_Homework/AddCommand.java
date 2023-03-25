package org.example;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command2 {
    @Override
    public void execute(Object obj1, Object obj2) {
        if(obj1 instanceof Catalog && obj2 instanceof Document)
        {
            List<Document> doc = new ArrayList<>();
            doc = ((Catalog) obj1).getDocuments();
            doc.add((Document) obj2);
            ((Catalog) obj1).setDocuments((ArrayList<Document>) doc);
        }
    }
}
