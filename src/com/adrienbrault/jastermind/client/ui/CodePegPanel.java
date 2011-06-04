package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.CodePeg;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 15:27
 */
public class CodePegPanel extends PegPanel {

    CodePegPanel() {
        super();
    }

    CodePegPanel(CodePeg peg) {
        super(peg);
    }

    protected void setPreferredSize() {
        this.setPreferredSize(new Dimension(30, 30));
    }

}
