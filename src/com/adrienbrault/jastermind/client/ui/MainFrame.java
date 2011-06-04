package com.adrienbrault.jastermind.client.ui;

import com.apple.eawt.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: adrienbrault
 * @Date: 04/06/11 12:01
 */
public class MainFrame extends JFrame {

    protected JPanel contentPane;
    protected JMenuBar menuBar;

    public MainFrame() {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentPane = new JPanel();
        this.setContentPane(this.contentPane);

        this.setUpMenuBar();

        this.pack();
        this.setMinimumSize(this.getSize());
    }

    protected void setUpMenuBar() {
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

}
