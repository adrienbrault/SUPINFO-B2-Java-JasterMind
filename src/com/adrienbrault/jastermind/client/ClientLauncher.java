package com.adrienbrault.jastermind.client;

import com.adrienbrault.jastermind.client.controller.GameController;
import com.adrienbrault.jastermind.client.ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.net.ConnectException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 03/06/11 20:00
 */
public class ClientLauncher {

    static protected GameController currentGameController;
    static protected MainFrame window;

    public static void main(String[] args) {
        window = new MainFrame();
        window.setVisible(true);

        window.addNewGameActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                startNewGame();
            }
        });
    }

    protected static void startNewGame() {
        try {
            window.getGamePanel().create();

            if (currentGameController != null) {
                currentGameController.closeStreams();
            }
            
            currentGameController = new GameController(window.getGamePanel());
        } catch (ConnectException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The new game failed to start.\nMaybe the server isn't running.", "Error", JOptionPane.ERROR_MESSAGE);
            window.getGamePanel().remove();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The new game failed to start.", "Error", JOptionPane.ERROR_MESSAGE);
            window.getGamePanel().remove();
        }
    }

}
