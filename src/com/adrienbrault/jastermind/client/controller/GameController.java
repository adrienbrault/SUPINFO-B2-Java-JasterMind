package com.adrienbrault.jastermind.client.controller;

import com.adrienbrault.jastermind.client.ui.BoardPanel;
import com.adrienbrault.jastermind.client.ui.CodePegChoicesPanel;
import com.adrienbrault.jastermind.server.ServerLauncher;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 17:16
 */
public class GameController {

    protected CodePegChoicesPanel codePegChoicesPanel;
    protected BoardPanel boardPanel;

    protected Socket socket;
    protected ObjectInputStream objectInputStream;
    protected ObjectOutputStream objectOutputStream;

    public GameController(CodePegChoicesPanel codePegChoicesPanel, BoardPanel boardPanel) throws IOException {
        this.codePegChoicesPanel = codePegChoicesPanel;
        this.boardPanel = boardPanel;

        this.connectToServer();
    }

    protected void connectToServer() throws IOException {
        this.socket = new Socket("localhost", ServerLauncher.SERVER_PORT);
        System.out.println("Connected to the server.");

        this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
    }

}
