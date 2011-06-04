package com.adrienbrault.jastermind.client.ui;

import javax.swing.*;
import javax.swing.border.Border;
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

    protected JPanel gamePanel;
    protected BoardPanel boardPanel;
    protected CodePegChoicesPanel codePegChoicePanel;

    public MainFrame() {
        super();

        this.setTitle("JasterMind");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(34, 139, 34)); // Green.
        this.setMinimumSize(new Dimension(344, 527));

        this.addMenuBar();

        this.contentPanel = new JPanel();
        this.setContentPane(this.contentPanel);
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

    public void createGamePanel() {
        this.removeGamePanel();

        this.gamePanel = new JPanel(new BorderLayout());
        this.contentPanel.add(this.gamePanel);

        this.boardPanel = new BoardPanel();
        JPanel container = new JPanel();
        container.add(this.boardPanel);
        this.gamePanel.add(container, BorderLayout.CENTER);

        this.codePegChoicePanel = new CodePegChoicesPanel();
        this.gamePanel.add(codePegChoicePanel, BorderLayout.SOUTH);

        this.contentPanel.revalidate();
        this.contentPanel.repaint();
    }

    public void removeGamePanel() {
        if (this.gamePanel != null) {
            this.contentPanel.remove(this.gamePanel);
        }

        this.gamePanel = null;
        this.boardPanel = null;
        this.gamePanel = null;

        this.contentPanel.revalidate();
        this.contentPanel.repaint();
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
