package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final Object[][] locks;
    public ExplorationMap(int n) {
        this.matrix = new Cell[n][n];
        this.locks = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
                locks[i][j] = new Object();
            }
        }
        int size = n * n * n;
        List<Token> tokenValues = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            Token token = new Token(i);
            tokenValues.add(token);
        }
        Collections.shuffle(tokenValues);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j].addTokens(tokenValues);
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        //synchronized (matrix[row][col]) {
            List<Token> tokens = matrix[row][col].getTokens();
            //if (!tokens.isEmpty()) {
            if(!matrix[row][col].isVisited()) {
                if(!tokens.isEmpty()) {
                    System.out.println(robot.getName() + " visited cell (" + row + ", " + col + ") and extracted tokens: " + tokens);
                    matrix[row][col].setVisited(true);
                    return true;
                }
                else {
                    System.out.println(robot.getName() + " visited cell (" + row + ", " + col + ") but it was empty");
                }
            } else {
                System.out.println(robot.getName() + " visited cell (" + row + ", " + col + ") but it was already visited");
                //matrix[row][col].setVisited(false);

            }
            return false;
        //}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : matrix) {
            for(Cell cell : row) {
                for (Token token : cell.getTokens()) {
                    sb.append(token).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
