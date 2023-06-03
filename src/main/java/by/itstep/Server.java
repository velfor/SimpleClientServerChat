package by.itstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  extends Thread{
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(1234)) { // использование try with resources
            System.out.println("Server started");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    System.out.println("Client connected");
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received message from client: " + inputLine + "\n");
                        out.println(inputLine);
                        if (inputLine.equals("exit")) { // проверка на сообщение exit
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}