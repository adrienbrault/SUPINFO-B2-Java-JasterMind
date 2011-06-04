package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.CodePeg;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 16:33
 */
public class CodePegChoicesPanel extends JPanel {

    protected PegPanel[] pegPanels = new PegPanel[CodePeg.values().length];

    CodePegChoicesPanel() {
        JPanel container = new JPanel();
        for (int i=0; i<CodePeg.values().length; i++) {
            this.pegPanels[i] = new CodePegPanel(CodePeg.values()[i]);
System.out.println(this.pegPanels[i].getPreferredSize());
            container.add(this.pegPanels[i]);
        }
        this.add(container);
    }

    public PegPanel[] getPegPanels() {
        return pegPanels;
    }
}
