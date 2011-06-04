package com.adrienbrault.jastermind.client;

import com.adrienbrault.jastermind.client.controller.GameController;
import com.adrienbrault.jastermind.client.ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 03/06/11 20:00
 */
public class Launcher {

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
        window.createNewGamePanel();
        currentGameController = new GameController(window.getCodePegChoicePanel(), window.getBoardPanel());
    }

}
