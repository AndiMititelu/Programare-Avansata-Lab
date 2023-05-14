package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    ServerSocket serverSocket;
    public static final int PORT = 8100;
    public GameServer() throws IOException{
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        finally{
            serverSocket.close();
        }
        //game = new Game(9);
    }

    private void startGame() {
        Game game = new Game();
        game.start();
    }

    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer ();
        server.startGame();
    }

}
