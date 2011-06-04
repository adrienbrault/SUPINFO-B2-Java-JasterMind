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

    private static final long serialVersionUID = -7278492502872181533L;

	protected JPanel contentPanel;

    protected JMenuBar menuBar;
    protected JMenuItem newGameMenuItem;

    protected GamePanel gamePanel;

    public MainFrame() {
        super();

        this.setTitle("JasterMind");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(34, 139, 34)); // Green.
        this.setMinimumSize(new Dimension(344, 527));

        this.addMenuBar();

        this.contentPanel = new JPanel(new BorderLayout());
        this.setContentPane(this.contentPanel);

        this.gamePanel = new GamePanel();
        this.contentPanel.add(this.gamePanel, BorderLayout.CENTER);
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

    public void addNewGameActionListener(ActionListener actionListener) {
        this.newGameMenuItem.addActionListener(actionListener);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
