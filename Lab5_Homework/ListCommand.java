package org.example;

public class ListCommand implements Command1 {
    @Override
    public void execute(Object obj) {
        if(obj instanceof Catalog)
            System.out.println(((Catalog) obj).getDocuments());
    }
}
