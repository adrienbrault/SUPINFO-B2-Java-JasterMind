package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.Peg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 13:03
 */
public class BoardPanel extends JPanel {

    protected BoardLinePanel[] boardLinePanels = new BoardLinePanel[Peg.TRY_NUMBER];

    BoardPanel() {
        for (int i=0; i<Peg.TRY_NUMBER; i++) {
            boardLinePanels[i] = new BoardLinePanel();
            this.add(boardLinePanels[i]);
        }

        this.setPreferredSize(new Dimension(300, 1000));
    }

    public BoardLinePanel[] getBoardLinePanels() {
        return boardLinePanels;
    }
}
