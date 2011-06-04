package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.KeyPeg;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 15:27
 */
public class KeyPegPanel extends PegPanel {

    private static final long serialVersionUID = 8692452525952705250L;

	KeyPegPanel() {
        super();
    }

    KeyPegPanel(KeyPeg peg) {
        super(peg);
    }

    protected void setPreferredSize() {
        this.setPreferredSize(new Dimension(15, 15));
    }

}
