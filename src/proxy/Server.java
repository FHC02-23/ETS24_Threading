package proxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        WebProxy webProxy = new WebProxy();

        try (ServerSocket serverSocket = new ServerSocket(5678)){

            while (true) {

                System.out.println("Waiting for client");
                Socket client = serverSocket.accept();
                System.out.println("client connected");
                Thread th = new Thread(new ClientHandler(client, webProxy));
                th.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
