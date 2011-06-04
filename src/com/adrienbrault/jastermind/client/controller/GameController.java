package com.adrienbrault.jastermind.client.controller;

import com.adrienbrault.jastermind.client.ui.BoardPanel;
import com.adrienbrault.jastermind.client.ui.CodePegChoicesPanel;
import com.adrienbrault.jastermind.client.ui.CodePegPanel;
import com.adrienbrault.jastermind.client.ui.PegPanel;
import com.adrienbrault.jastermind.model.CodePeg;
import com.adrienbrault.jastermind.server.ServerLauncher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        this.addCodePegChoicesListener();
    }

    protected void connectToServer() throws IOException {
        this.socket = new Socket("localhost", ServerLauncher.SERVER_PORT);
        System.out.println("Connected to the server.");

        this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());System.out.println("input str");
        this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());System.out.println("output str");
    }

    protected void addCodePegChoicesListener() {
        for (PegPanel codePegPanel : this.codePegChoicesPanel.getPegPanels()) {
            codePegPanel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    CodePegPanel codePegPanel = (CodePegPanel)actionEvent.getSource();
                    CodePeg codePeg = (CodePeg)codePegPanel.getPeg();
                    GameController.this.userClickedCodePegChoice(codePeg);
                }
            });
        }
    }

    protected void userClickedCodePegChoice(CodePeg codePeg) {
        System.out.println("clicked " + codePeg);
    }

    @Override
    public void finalize() {System.out.println("closing socket");
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
