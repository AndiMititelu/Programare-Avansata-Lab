package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private char color; //culorile vor fi black, white: B & W
    public Player(String name) {
        this.name = name;
        //this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
