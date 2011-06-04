package com.adrienbrault.jastermind.server;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 03/06/11 20:00
 */
public class ServerLauncher {

    final public static int SERVER_PORT = 2202;

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        JPanel contentPanel = new JPanel();
        window.setContentPane(contentPanel);

        JLabel label = new JLabel("Server running.");
        contentPanel.add(label);

        window.setTitle("JasterMindServer.");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setResizable(false);

        window.setVisible(true);

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT, 5);

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

        System.out.println("Stops listening.");
    }

}
