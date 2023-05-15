package org.example;

public class Player {
    private String name;
    private char color; //culorile vor fi black, white: B & W
    public Player(String name) {
        this.name = name;
        //this.color = color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Player [name=" + name + ", color=" + color + "]";
    }
}
