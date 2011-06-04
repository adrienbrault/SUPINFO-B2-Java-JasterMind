package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.CodePeg;
import com.adrienbrault.jastermind.model.KeyPeg;
import com.adrienbrault.jastermind.model.Peg;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 13:05
 */
abstract public class PegPanel extends JPanel {

    final static Color defaultColor = Color.black;
    

    protected Peg peg;

    PegPanel() {
        
    }

    PegPanel(Peg peg) {
        this();

        this.peg = peg;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        // Draw shapes with antialiasing -> better look
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(this.peg != null ? this.peg.getColor() : defaultColor);

        graphics.fillOval(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
    }

    public Peg getPeg() {
        return peg;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
        this.revalidate();
    }
}
