package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class GameClient {
    public static void main (String[] args) throws IOException {

        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try {
            Socket socket = new Socket(serverAddress, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


            while (true) {
                String command = keyboard.readLine();
                if (command.equals("exit")) {
                    break;
                }

                out.println(command);
                String response = in.readLine();
                System.out.println(response); //de comentat


                //--------------- Bulding the gameBoard ------------------------------


                if(response.equals("Server started")) {
                    System.out.println("Join the game...");
                    //Print the empty game board
                    StringBuilder boardResponse = new StringBuilder();
                    String line;
                    while (!(line = in.readLine()).isEmpty()) {
                        boardResponse.append(line).append("\n");
                    }
                    System.out.println(boardResponse);
                }
                else if(response.equals("Enter a username...")) {
                    System.out.println("Enter a username...");
                    String username = keyboard.readLine();
                    //BufferedReader username = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Test sending user: " + username);
                    //sending the username
                    out.println(username);
                    //in.readLine(); //BUGGG
                }
                else if(response.equals("Game started")) {
                    System.out.println("Enter (x, y) coordinates to make ur move...");
                    String move = keyboard.readLine();
                    out.println(move);

                    String boardAfterMove = in.readLine();
                    StringBuilder boardResponse = new StringBuilder();
                    String line;
                    while (!(line = in.readLine()).isEmpty()) {
                        boardResponse.append(line).append("\n");
                    }
                    System.out.println(boardResponse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}