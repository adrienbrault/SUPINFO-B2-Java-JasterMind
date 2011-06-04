package com.adrienbrault.jastermind.server.ui;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 21:42
 */
public class ServerFrame extends JFrame {

    private static final long serialVersionUID = 7434721658331263349L;

	public ServerFrame() {
        JPanel contentPanel = new JPanel();
        this.setContentPane(contentPanel);

        JLabel label = new JLabel("The server running.");
        contentPanel.add(label);

        this.setTitle("JasterMindServer.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 50);
        this.setResizable(false);
    }

}
