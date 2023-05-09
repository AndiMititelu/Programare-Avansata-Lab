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
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}