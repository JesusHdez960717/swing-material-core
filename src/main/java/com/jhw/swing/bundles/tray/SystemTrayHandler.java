/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.bundles.tray;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import static java.awt.Frame.*;

/**
 * @author Mohammad Faisal ermohammadfaisal.blogspot.com
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SystemTrayHandler {

    public static SystemTrayHandler installSystemTray(JFrame frame) {
        return new SystemTrayHandler(frame, new PopupMenu());
    }

    public static SystemTrayHandler installSystemTray(JFrame frame, PopupMenu popup) {
        return new SystemTrayHandler(frame, popup);
    }

    private final TrayIcon trayIcon;
    private final JFrame target;

    public SystemTrayHandler(JFrame target, PopupMenu popup) {
        this.target = target;

        addOpenCloseItems(popup);

        trayIcon = new TrayIcon(target.getIconImage(), "SystemTray Demo", popup);
        trayIcon.setImageAutoSize(true);

        trayIcon.addActionListener((ActionEvent e) -> {
            show();
        });
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked tryIcon");
            }
        });

        this.target.addWindowStateListener((WindowEvent e) -> {
            if (e.getNewState() == ICONIFIED || e.getNewState() == 7) {
                hideInTray();
            }
            if (e.getNewState() == MAXIMIZED_BOTH || e.getNewState() == NORMAL) {
                showFromTry();
            }
        });
    }

    /**
     * Esconde en el System tray el frame, por lo que agrega el trayIcon y pone
     * setVisible(false) al frame
     */
    private void hideInTray() {
        try {
            SystemTray.getSystemTray().add(trayIcon);
            this.target.setVisible(false);
            System.out.println("added to SystemTray");
        } catch (Exception ex) {
            System.out.println("unable to add to system tray");
        }
    }

    /**
     * Muestra el frame que esta en el SystemTray, por lo que remueve el icono
     * de la aplicacion del SystemTray y le pone el setVisible(true) al frame
     */
    private void showFromTry() {
        SystemTray.getSystemTray().remove(trayIcon);
        this.target.setVisible(true);
        System.out.println("Tray icon removed");
    }

    /**
     * Show action, setVisible(true), setExtendedState(JFrame.NORMAL).
     */
    private void show() {
        SystemTrayHandler.this.target.setVisible(true);
        SystemTrayHandler.this.target.setExtendedState(JFrame.NORMAL);
    }

    private void addOpenCloseItems(PopupMenu popup) {
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.out.println("Exiting....");
            System.exit(0);//TODO
        });
        popup.add(exitMenuItem);

        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.addActionListener((ActionEvent e) -> {
            show();
        });
        popup.add(openMenuItem);
    }

}
