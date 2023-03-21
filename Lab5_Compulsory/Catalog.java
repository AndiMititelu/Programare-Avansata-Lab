package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.*;

public class Catalog {
    private String name;
    private List<Document> documents;
    public Catalog(String name) {
        this.name = name;
        documents = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog() {
    }
    public List<Document> getDocuments() {
        return documents;
    }
    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
    public String getName() {
        return name;
    }
    public void add(Document doc) {
        documents.add(doc);
    }

    @Override
    public String toString() {
        StringBuilder documents = new StringBuilder();
        for(Document doc : getDocuments()) {
            documents.append(doc);
        }
        return "Catalog name: " + name + ", documents: " + documents;
    }

}

