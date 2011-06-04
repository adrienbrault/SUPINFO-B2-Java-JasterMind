package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.CodePeg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 16:33
 */
public class CodePegChoicesPanel extends JPanel {

    protected PegPanel[] pegPanels = new PegPanel[CodePeg.values().length];

    CodePegChoicesPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black,  2)); // 2px black border;
        this.setBackground(new Color(160, 82, 45)); // Brown.

        JPanel container = new JPanel();
        this.add(container);
        container.setBackground(this.getBackground());

        for (int i=0; i<CodePeg.values().length; i++) {
            this.pegPanels[i] = new CodePegPanel(CodePeg.values()[i]);

            container.add(this.pegPanels[i]);
        }
    }

    public PegPanel[] getPegPanels() {
        return pegPanels;
    }
}
