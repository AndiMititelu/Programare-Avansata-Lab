package org.example;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private String location; //file name or web page
    Map<String, String> tags;
    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        tags = new HashMap<>();
    }
    public Document() { }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    public Map<String, String> getTags() {
        return tags;
    }
    public void addTag(String tagName, String tagValue) {
        tags.put(tagName, tagValue);
    }
    @Override
    public String toString() {
        String result = "Document {ID: ";
        result += getId();
        result += ", Location ";
        result += getLocation();
        result += ", Name: ";
        result += getName();
        result += ", tags: ";
        result += getTags();
        result += "}";
        return result;
    }
}
