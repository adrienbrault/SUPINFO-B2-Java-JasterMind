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
public class PegPanel extends JPanel {

    protected Peg peg;

    PegPanel() {
        this.setPreferredSize(getPegDimension(null));
    }

    PegPanel(Peg peg) {
        this.setPeg(peg);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        if (this.peg == null) {
            return;
        }
        
        graphics.setColor(this.peg.getColor());

        graphics.fillOval(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
    }

    public Peg getPeg() {
        return peg;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
        this.setPreferredSize(getPegDimension(peg));
    }

    final Dimension getPegDimension(Peg peg) {
        Dimension dimension;

        if (peg != null && peg.getClass() == CodePeg.class) {
            dimension = new Dimension(15, 15);
        } else {
            dimension = new Dimension(30, 30);
        }

        return dimension;
    }
}
