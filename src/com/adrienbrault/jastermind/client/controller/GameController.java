package com.adrienbrault.jastermind.client.controller;

import com.adrienbrault.jastermind.client.ui.*;
import com.adrienbrault.jastermind.model.CodePeg;
import com.adrienbrault.jastermind.model.KeyPeg;
import com.adrienbrault.jastermind.model.Peg;
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

    protected GamePanel gamePanel;

    protected Socket socket;
    protected ObjectInputStream objectInputStream;
    protected ObjectOutputStream objectOutputStream;

    protected int currentRow = 0;
    protected int currentColumn = 0;

    public GameController(GamePanel gamePanel) throws IOException {
        this.gamePanel = gamePanel;

        this.connectToServer();

        this.addCodePegChoicesListener();
    }

    protected void connectToServer() throws IOException {
        this.socket = new Socket("localhost", ServerLauncher.SERVER_PORT);
        System.out.println("Socket opened.");

        this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
    }

    public void closeStreams() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Socket closed.");
    }

    protected void addCodePegChoicesListener() {
        for (PegPanel codePegPanel : this.gamePanel.getCodePegChoicePanel().getPegPanels()) {
            codePegPanel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    CodePegPanel codePegPanel = (CodePegPanel)actionEvent.getSource();
                    CodePeg codePeg = (CodePeg)codePegPanel.getPeg();
                    GameController.this.userClickedCodePegChoice(codePeg);
                }
            });
        }
    }

    protected void removeCodePegChoicesListeners() {
        for (PegPanel codePegPanel : this.gamePanel.getCodePegChoicePanel().getPegPanels()) {
            for (ActionListener actionListener : codePegPanel.getActionListeners()) {
                codePegPanel.removeActionListener(actionListener);
            }
        }
    }

    protected PegPanel getCodePegPanel(int row, int column) {
        return this.gamePanel.getBoardPanel().getBoardLinePanels()[row].getCodePegPanels()[column];
    }

    protected PegPanel getKeyPegPanel(int row, int column) {
        return this.gamePanel.getBoardPanel().getBoardLinePanels()[row].getKeyPegPanels()[column];
    }

    protected CodePeg[] getCurrentRowCodePegs() {
        CodePeg[] codePegs = new CodePeg[Peg.LINE_SIZE];

        for (int i=0; i<Peg.LINE_SIZE; i++) {
            PegPanel pegPanel = this.gamePanel.getBoardPanel().getBoardLinePanels()[this.currentRow].getCodePegPanels()[i];
            codePegs[i] = (CodePeg)pegPanel.getPeg();
        }

        return codePegs;
    }

    protected void userClickedCodePegChoice(CodePeg codePeg) {
        if (this.currentRow < Peg.TRY_NUMBER) {
            PegPanel codePegPanel = this.getCodePegPanel(this.currentRow, this.currentColumn);
            codePegPanel.setPeg(codePeg);

            this.currentColumn = (this.currentColumn + 1) % Peg.LINE_SIZE;
            if (this.currentColumn == 0) {
                this.checkRow();
                
                this.currentRow++;
                if (this.currentRow > Peg.TRY_NUMBER) {
                    this.gameEnded(false);
                }
            }
        }
    }

    protected void gameEnded(boolean hasUserWin) {
        this.removeCodePegChoicesListeners();
        this.closeStreams();
    }

    protected void checkRow() {
        try {
            this.objectOutputStream.writeObject(this.getCurrentRowCodePegs());

            KeyPeg[] keyPegs = (KeyPeg[])this.objectInputStream.readObject();

            for (int i=0; i<Peg.LINE_SIZE; i++) {
                this.getKeyPegPanel(this.currentRow, i).setPeg(keyPegs[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
