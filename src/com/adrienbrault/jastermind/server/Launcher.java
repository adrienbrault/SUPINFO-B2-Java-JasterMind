package com.adrienbrault.jastermind.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 03/06/11 20:00
 */
public class Launcher {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2201, 5);

        handleRequests(serverSocket);
    }

    public static void handleRequests(ServerSocket serverSocket) throws IOException {
        System.out.println("Starts listening.");

        while (serverSocket != null) {
            Socket serviceSocket = serverSocket.accept();

            System.out.println("Connection accepted: " + serviceSocket);

            CodeMakerService service = new CodeMakerService(serviceSocket);
            Thread serviceThread = new Thread(service);

            serviceThread.start();
        }
    }

}
