package by.itstep;

import java.io.*;
import java.net.*;

public class Client extends Thread {
    @Override
    public void run(){
        try {
            // создаем клиентский сокет и подключаемся к серверу по адресу localhost и порту 1234
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server");
            // создаем поток ввода для чтения данных от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // создаем поток вывода для отправки данных серверу
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello, server!"); // отправляем сообщение серверу

            String response = in.readLine(); // читаем ответное сообщение от сервера
            System.out.println("Received message from server: " + response+"\n");

            out.println("exit"); // отправляем сообщение серверу

            response = in.readLine(); // читаем ответное сообщение от сервера
            System.out.println("Received message from server: " + response+"\n");

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
