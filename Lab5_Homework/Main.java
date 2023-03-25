package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("MyCatalog");
        var doc1 = new Document("01", "helloWorld", "helloWorld.txt");
        doc1.addTag("author", "J. R. R. Tolkien");
        doc1.addTag("year", "2001");
        doc1.addTag("type", "book");

        var doc2 = new Document("02", "articolHello", "articolHello.txt");
        doc2.addTag("author", "Frasinaru Cristian");
        doc2.addTag("year", "2020");
        doc2.addTag("type", "graph library");

        Command2 addCommand = new AddCommand();
        addCommand.execute(catalog, doc1);
        addCommand.execute(catalog, doc2);
        //catalog.add(doc1);
        //catalog.add(doc2);

        //System.out.println(catalog);

        Command1 listCommand = new ListCommand();
        listCommand.execute(catalog);

        Command2 saveCommand = new SaveCommand();
        saveCommand.execute(catalog, "catalog.json");
        //CatalogUtil.save(catalog, "catalog.json");

        Command2 reportCommand = new ReportCommand();
        reportCommand.execute(catalog, "report.html");

        System.out.println("Catalog saved to catalog.json");

        //pentru load nu am facut o clasa separata
        Catalog loadedCatalog = CatalogUtil.load("catalog.json");
        System.out.println("Catalog loaded: ");
        System.out.println(loadedCatalog);

    }
}