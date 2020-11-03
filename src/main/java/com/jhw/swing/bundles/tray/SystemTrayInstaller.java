/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.bundles.tray;

import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import static java.awt.Frame.*;
import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

/**
 * @author Mohammad Faisal ermohammadfaisal.blogspot.com
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SystemTrayInstaller {

    public static SystemTrayInstaller installSystemTray(JFrame frame) {
        return SystemTrayInstaller.builder(frame).build();
    }

    private final TrayIcon trayIcon;
    private final JFrame target;

    public SystemTrayInstaller(JFrame target, JPopupMenu popup) {
        this.target = target;

        trayIcon = new TrayIcon(target.getIconImage(), target.getTitle());
        trayIcon.setImageAutoSize(true);

        trayIcon.addActionListener((ActionEvent e) -> {
            show();
        });
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
                System.out.println("release");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
                System.out.println("presed");
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.setLocation(e.getX(), (int) (e.getY() - popup.getPreferredSize().getWidth()));
                    popup.setInvoker(popup);
                    popup.setVisible(true);
                }
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
        target.setVisible(true);
        target.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static builder builder(JFrame frame) {
        return new builder(frame);
    }

    public static class builder {

        private final JFrame target;
        private JPopupMenu popup = new JPopupMenu();

        public builder(JFrame target) {
            this.target = target;
            addOpenCloseItems(popup);
        }

        public void popup(JPopupMenu popup) {
            this.popup = popup;
        }

        private void addOpenCloseItems(JPopupMenu popup) {
            popup.add(new AbstractAction("Cerrar", MaterialIcons.CLOSE) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    builder.this.target.dispatchEvent(new WindowEvent(builder.this.target, WindowEvent.WINDOW_CLOSING));
                }
            });
            popup.add(new AbstractAction("Abrir", MaterialIcons.OPEN_WITH) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    target.setVisible(true);
                    target.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            });
        }

        public SystemTrayInstaller build() {
            return new SystemTrayInstaller(target, popup);
        }
    }
}
