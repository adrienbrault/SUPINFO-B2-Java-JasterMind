package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.Peg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 13:03
 */
public class BoardLinePanel extends JPanel {

    protected PegPanel[] codePegPanels = new PegPanel[Peg.LINE_SIZE];
    protected PegPanel[] keyPegPanels = new PegPanel[Peg.LINE_SIZE];

    protected JPanel keyPegPanel;

    BoardLinePanel() {
        for (int i=0; i<Peg.LINE_SIZE; i++) {
            codePegPanels[i] = new CodePegPanel();
            this.add(codePegPanels[i]);
        }

        this.keyPegPanel = new JPanel();
        this.keyPegPanel.setPreferredSize(new Dimension(45, 45));
        this.add(this.keyPegPanel);

        for (int i=0; i<Peg.LINE_SIZE; i++) {
            keyPegPanels[i] = new KeyPegPanel();
            this.keyPegPanel.add(keyPegPanels[i]);
        }

        Color backgroundColor = new Color(160, 82, 45); // Brown.
        this.setBackground(backgroundColor);
        this.keyPegPanel.setBackground(backgroundColor);

        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackBorder);
        this.keyPegPanel.setBorder(blackBorder);
    }

    public PegPanel[] getCodePegPanels() {
        return codePegPanels;
    }

    public PegPanel[] getKeyPegPanels() {
        return keyPegPanels;
    }
}
