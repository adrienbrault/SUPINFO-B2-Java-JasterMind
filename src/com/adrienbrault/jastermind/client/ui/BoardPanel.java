package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.Peg;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 13:03
 */
public class BoardPanel extends JPanel {

    private static final long serialVersionUID = -5068942359257501992L;
	
    protected BoardLinePanel[] boardLinePanels = new BoardLinePanel[Peg.TRY_NUMBER];

    BoardPanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i=Peg.TRY_NUMBER-1; i>=0; i--) {
            boardLinePanels[i] = new BoardLinePanel();
            this.add(boardLinePanels[i]);
        }
    }

    public BoardLinePanel[] getBoardLinePanels() {
        return boardLinePanels;
    }
}
