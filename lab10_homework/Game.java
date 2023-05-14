package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private boolean isFinished;
    private final int size = 8;
    private int currentPlayerIndex;
    public Game(){

    }
    public void start() {
        //initialize the game
        playerList = new ArrayList<>();
        board = new Board(size);
        isFinished = false;
        currentPlayerIndex = 0;
    }
    public void makeMove(int x, int y) {
        //make the move
        if(playerList.size() == 0) {
            throw new IllegalArgumentException("The game needs at least 1 player to join!");
        }
        Player player = playerList.get(currentPlayerIndex);
        board.makeMove(player, x, y);

        //check for winner
        for(Player p : playerList) {
            if(hasWon(p)) {
                //TODO: stop game
                isFinished = true;
                return;
            }
        }

        //switch player turn if there are 2 players
        if(playerList.size() == 2)
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }
    public void join(Player player) {
        //add player to game
        if(playerList.size() < 2) {
            playerList.add(player);
            System.out.println("New player joined the game...");
        }
        else {
            System.out.println("You cant have more than 2 players!");
            return;
        }

        //setting the colors
        if(playerList.get(0) != null)
            playerList.get(0).setColor('B');
        if(playerList.get(1) != null)
            playerList.get(1).setColor('W');
    }
    public boolean hasWon(Player player) {
        char color = player.getColor();
        char[][] gameBoard = board.getBoard();

        //Checking rows
        for (int i = 0; i < size; i++) {
            //won = false;
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == color)
                    count++;
            }
            if (count >= 5)
                return true;
        }

        //Checking columns
        for (int i = 0; i < size; i++) {
            //won = false;
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard[j][i] == color)
                    count++;
            }
            if (count >= 5)
                return true;
        }

        //Checking diagonals
        for(int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == color) {
                    // check top-left to bottom-right diagonal
                    if (i + 4 < size && j + 4 < size) {
                        if (gameBoard[i + 1][j + 1] == color &&
                                gameBoard[i + 2][j + 2] == color &&
                                gameBoard[i + 3][j + 3] == color &&
                                gameBoard[i + 4][j + 4] == color) {
                            return true;
                        }
                    }
                    // check top-right to bottom-left diagonal
                    if (i + 4 < size && j - 4 >= 0) {
                        if (gameBoard[i + 1][j - 1] == color &&
                                gameBoard[i + 2][j - 2] == color &&
                                gameBoard[i + 3][j - 3] == color &&
                                gameBoard[i + 4][j - 4] == color) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }
    public String getBoardString() {
        char[][] gameBoard = board.getBoard();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(gameBoard[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
