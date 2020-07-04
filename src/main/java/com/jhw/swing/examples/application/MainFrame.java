package com.jhw.swing.examples.application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainFrame extends JFrame {

    private final CardLayout cards = new CardLayout();

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        this.panelContent = new JPanel();
        this.panelContent.setLayout(cards);

        this.setLayout(new BorderLayout());
        this.add(panelContent, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        pack();
    }

    private JPanel panelContent;

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    public void showView(String name) {
        cards.show(panelContent, name);
    }

    public void addView(String name, Component compoment) {
        panelContent.add(name, compoment);
    }
}
