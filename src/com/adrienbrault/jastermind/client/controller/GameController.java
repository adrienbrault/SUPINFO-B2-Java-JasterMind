package com.adrienbrault.jastermind.client.controller;

import com.adrienbrault.jastermind.client.ui.BoardPanel;
import com.adrienbrault.jastermind.client.ui.CodePegChoicesPanel;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 17:16
 */
public class GameController {

    protected CodePegChoicesPanel codePegChoicesPanel;
    protected BoardPanel boardPanel;

    public GameController(CodePegChoicesPanel codePegChoicesPanel, BoardPanel boardPanel) {
        this.codePegChoicesPanel = codePegChoicesPanel;
        this.boardPanel = boardPanel;
    }

}
