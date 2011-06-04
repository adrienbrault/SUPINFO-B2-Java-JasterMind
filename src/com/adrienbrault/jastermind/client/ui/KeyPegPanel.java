package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.KeyPeg;
import com.adrienbrault.jastermind.model.Peg;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 15:27
 */
public class KeyPegPanel extends PegPanel {

    KeyPegPanel() {
        super();
    }

    KeyPegPanel(KeyPeg peg) {
        super(peg);
    }

    protected void setPreferredSize() {
        this.setPreferredSize(new Dimension(15, 15));
    }

    public void setPeg(Peg peg) {
        if (peg.getColor() != null) {
            super.setPeg(peg);
        }
    }

}
