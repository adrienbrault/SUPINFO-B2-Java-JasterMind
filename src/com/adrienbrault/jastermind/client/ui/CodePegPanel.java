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

    private static final long serialVersionUID = -6725932124466081510L;

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
