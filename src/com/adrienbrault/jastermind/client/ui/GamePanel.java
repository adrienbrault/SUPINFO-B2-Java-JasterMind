package com.adrienbrault.jastermind.client.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 19:51
 */
public class GamePanel extends JPanel {

    protected BoardPanel boardPanel;
    protected CodePegChoicesPanel codePegChoicePanel;

    GamePanel() {
        super(new BorderLayout());
    }

    public void create() {
        this.remove();

        this.boardPanel = new BoardPanel();
        JPanel container = new JPanel();
        container.add(this.boardPanel);
        this.add(container, BorderLayout.CENTER);

        this.codePegChoicePanel = new CodePegChoicesPanel();
        this.add(codePegChoicePanel, BorderLayout.SOUTH);

        this.revalidate();
        this.repaint();
    }

    public void remove() {
        if (this.boardPanel != null) {
            this.remove(this.boardPanel);
        }
        if (this.codePegChoicePanel != null) {
            this.remove(this.codePegChoicePanel);
        }

        this.boardPanel = null;
        this.codePegChoicePanel = null;

        this.revalidate();
        this.repaint();
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public CodePegChoicesPanel getCodePegChoicePanel() {
        return codePegChoicePanel;
    }

}
