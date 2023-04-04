package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean visited;
    private List<Token> tokens;
    public Cell() {
        this.visited = false;
        this.tokens = new ArrayList<>();
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Token> getTokens() {
        return tokens;
    }
    public void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }
    @Override
    public String toString() {
        return tokens.toString();
    }

}
