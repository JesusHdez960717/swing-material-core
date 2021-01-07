/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.examples;

import com.root101.swing.bundles.tray.SystemTrayInstaller;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.*;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.NORMAL;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mohammad Faisal ermohammadfaisal.blogspot.com,
 * facebook.com/m.faisal6621
 *
 */
public class EXAMPLE_SYSTEM_TRAY extends JFrame {

    EXAMPLE_SYSTEM_TRAY() {
        super("Title del frame");

        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(MaterialIcons.ADD.getImage());

        SystemTrayInstaller.builder(this).build();
        //SystemTrayHandler.installSystemTray(this);

        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());
        new EXAMPLE_SYSTEM_TRAY();
    }
}
