package com.adrienbrault.jastermind.client.ui;

import com.adrienbrault.jastermind.model.CodePeg;
import com.adrienbrault.jastermind.model.KeyPeg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 12:01
 */
public class MainFrame extends JFrame {

    protected JPanel contentPanel;
    protected JMenuBar menuBar;

    protected BoardPanel boardPanel;
    protected JPanel choicePegPanel;

    public MainFrame() {
        super();

        this.setTitle("JasterMind");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentPanel = new JPanel(new BorderLayout());
        this.setBackground(new Color(34, 139, 34)); // Green.
        this.setContentPane(this.contentPanel);

        this.addMenuBar();

        this.addGameElements();

        this.pack();
        this.setMinimumSize(this.getSize());
    }

    protected void addMenuBar() {
        // Mac OS Specific.
        if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        // Creating menu.
        this.menuBar = new JMenuBar();
        this.setJMenuBar(this.menuBar);

        JMenu fileMenu = new JMenu("File");
        this.menuBar.add(fileMenu);

        JMenuItem newMenuItem = new JMenuItem("New Game");
        fileMenu.add(newMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    protected void addGameElements() {
        this.boardPanel = new BoardPanel();
        JPanel boardPanelContainer = new JPanel();
        boardPanelContainer.add(this.boardPanel);
        this.add(boardPanelContainer, BorderLayout.CENTER);

        this.choicePegPanel = new JPanel();
        this.add(choicePegPanel, BorderLayout.SOUTH);
    }

}
