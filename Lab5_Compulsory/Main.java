package org.example;
import java.io.IOException;
import javax.print.Doc;
import java.util.Scanner;
import java.io.File;

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

        catalog.add(doc1);
        catalog.add(doc2);

        System.out.println(catalog);

        CatalogUtil.save(catalog, "catalog.json");
        System.out.println("Catalog saved to catalog.json");

        Catalog loadedCatalog = CatalogUtil.load("catalog.json");
        System.out.println("Catalog loaded: ");
        System.out.println(loadedCatalog);

    }
}