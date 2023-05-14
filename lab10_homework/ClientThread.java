package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Game game;
    public ClientThread(Socket socket) {
        this.socket = socket;
        game = new Game();
    }
    private void startGame() {
        game.start();
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String request = in.readLine();
                String response = "";

                if (request.equals("stop")) {
                    response = "Server stopped";
                    out.println(response);
                    System.exit(0);
                    break;
                }
                else if(request.equals("start")) {

                    startGame();
                    out.println("Server started");

                    System.out.println(game.getBoard());
                    String initialBoard = game.getBoardString();
                    out.println(initialBoard);

                }
                else if(request.equals("join")) {
                    //request the client to enter a username
                    out.println("Enter a username...");

                    String requestName = in.readLine(); //wtf is here?
                    System.out.println("CE E AICI: " + requestName);
                    if(requestName.equals("andi")) {
                        System.out.println("Am ajuns over here!!!!");
                        out.println("Game started");
                    }

                    //Extracting the (x, y) values
                    String requestMove = in.readLine();
                    String receivedInput = requestMove;
                    System.out.println("RecInput: " + receivedInput);
                    String[] numbers = receivedInput.split(" ");
                    int[] intNumbers = new int[2];
                    for (int i = 0; i < 2; i++) {
                        intNumbers[i] = Integer.parseInt(numbers[i]);
                        //System.out.println(intNumbers[i]);
                    }

                    //Making the actual move
                    game.makeMove(intNumbers[0], intNumbers[1]);
                    String updatedBoard = game.getBoardString();
                    System.out.println(game.getBoardString());
                    out.println(updatedBoard);
                    System.out.println("AM REALIZAT O MUTARE");
                }
                else {
                    response = "Invalid request: " + request;
                    out.println(response);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println(e); }
        }
    }
}
