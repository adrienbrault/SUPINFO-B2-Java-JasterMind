package com.adrienbrault.jastermind.client.ui;

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
    protected JMenuItem newGameMenuItem;

    protected BoardPanel boardPanel;
    protected CodePegChoicesPanel codePegChoicePanel;

    public MainFrame() {
        super();

        this.setTitle("JasterMind");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMenuBar();

        this.setBackground(new Color(34, 139, 34)); // Green.

        this.pack();
        this.setMinimumSize(new Dimension(344, 522));
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

        newGameMenuItem = new JMenuItem("New Game");
        fileMenu.add(newGameMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void createNewGamePanel() {
        this.contentPanel = new JPanel(new BorderLayout());
        this.setContentPane(this.contentPanel);

        this.addGameElements();
    }

    protected void addGameElements() {
        this.boardPanel = new BoardPanel();
        JPanel container = new JPanel();
        container.add(this.boardPanel);
        this.add(container, BorderLayout.CENTER);

        this.codePegChoicePanel = new CodePegChoicesPanel();
        this.add(codePegChoicePanel, BorderLayout.SOUTH);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public CodePegChoicesPanel getCodePegChoicePanel() {
        return codePegChoicePanel;
    }

    public void addNewGameActionListener(ActionListener actionListener) {
        this.newGameMenuItem.addActionListener(actionListener);
    }

}
