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

    private static final long serialVersionUID = 6515216729364254105L;
	
    protected PegPanel[] pegPanels = new PegPanel[CodePeg.values().length];

    CodePegChoicesPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black,  2)); // 2px black border;
        this.setBackground(new Color(160, 82, 45)); // Brown.

        this.setLayout(new GridLayout(1, this.pegPanels.length));

        for (int i=0; i<CodePeg.values().length; i++) {
            this.pegPanels[i] = new CodePegPanel(CodePeg.values()[i]);

            this.add(this.pegPanels[i]);
        }

        Dimension size = this.getPreferredSize();
        size.width += 100;
        this.setPreferredSize(size);
    }

    public PegPanel[] getPegPanels() {
        return pegPanels;
    }
}
