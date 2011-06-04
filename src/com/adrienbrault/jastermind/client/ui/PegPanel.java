package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.Peg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 13:05
 */
abstract public class PegPanel extends JButton {

    final static Color defaultColor = Color.black;
    

    protected Peg peg;

    PegPanel() {
        this.setPreferredSize();
    }

    PegPanel(Peg peg) {
        this();
        
        this.peg = peg;
    }

    protected abstract void setPreferredSize();

    @Override
    public void paintComponent(Graphics graphics) {
        // Draw shapes with antialiasing -> better look
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (this.peg != null) {
            graphics.setColor(this.peg.getColor());

            graphics.fillOval(1, 1, this.getPreferredSize().width - 2, this.getPreferredSize().height - 2);
        }
        
        graphics.setColor(defaultColor);
        graphics.drawOval(1, 1, this.getPreferredSize().width - 2, this.getPreferredSize().height - 2);


    }

    public Peg getPeg() {
        return peg;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
        this.revalidate();
        this.repaint();
    }
}
