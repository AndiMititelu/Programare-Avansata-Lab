package org.example;

public class Board {
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board[i][j] = '*';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void makeMove(Player player, int x, int y) {
        if(isValidMove(x, y)) {
            char color = player.getColor();
            board[x][y] = color;
        }
        else {
            System.out.println("Invalid move. Please try again.");
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == 'O';
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
