/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.bundles.tray;

import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import static java.awt.Frame.*;
import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

/**
 * @author Mohammad Faisal ermohammadfaisal.blogspot.com
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
            }

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
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
            showNotification();
            System.out.println("Agregada App al SystemTray");
        } catch (Exception ex) {
            System.out.println("Error agregando la App al SystemTray");
        }
    }

    /**
     * Muestra el frame que esta en el SystemTray, por lo que remueve el icono
     * de la aplicacion del SystemTray y le pone el setVisible(true) al frame
     */
    private void showFromTry() {
        SystemTray.getSystemTray().remove(trayIcon);
        this.target.setVisible(true);
        System.out.println("Removido Tray Icon");
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

    private void showNotification() {
        if (PersonalizationHandler.getBoolean(Personalization.KEY_SHOW_NOTIF_AFTER_TRAY)) {
            trayIcon.displayMessage(target.getTitle(), "Minimizado a la barra de tareas", TrayIcon.MessageType.INFO);
        }
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
