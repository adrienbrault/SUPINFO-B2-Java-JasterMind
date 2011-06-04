package com.adrienbrault.jastermind.server;

import com.adrienbrault.jastermind.server.ui.ServerFrame;

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

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT, 5);

            ServerFrame serverFrame = new ServerFrame();
            serverFrame.setVisible(true);

            handleRequests(serverSocket);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occured:\n" + e.getMessage() + "\n\nThe server will stop.", "Error.", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
