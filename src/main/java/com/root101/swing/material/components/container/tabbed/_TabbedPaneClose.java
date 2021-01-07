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
 */package com.root101.swing.material.components.container.tabbed;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.root101.swing.util.interfaces.MaterialComponent;
import javax.swing.JButton;

/**
 * Componente extraido su logica de edisoncorSX.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _TabbedPaneClose extends JTabbedPane implements MaterialComponent {

    public static _TabbedPaneClose from() {
        return new _TabbedPaneClose();
    }

    private boolean confirmacion = false;
    protected Modelo modelo = Modelo.ROUND;

    public enum Modelo {

        RECT,
        ROUND
    }

    private class PanelTitle extends JPanel implements ActionListener {

        private JTabbedPane pane;

        public PanelTitle(String text, JTabbedPane tabbed) {
            this.pane = tabbed;
            JLabel label = new JLabel(text);
            label.getInsets().set(0, 0, 0, 10);
            JButton boton = new JButton();
            setOpaque(false);
            setLayout(new BorderLayout());
            add(label, "Center");
            boton.setBorderPainted(false);
            boton.setContentAreaFilled(false);
            boton.setMargin(new Insets(0, 0, 0, 0));
            switch (_TabbedPaneClose.this.modelo) {
                case RECT:
                    boton.setIcon(new ImageIcon(loadImage("/imgs/title_close.png")));
                    boton.setPressedIcon(new ImageIcon(getClass().getResource("/imgs/title_close_pressed.png")));
                    boton.setRolloverIcon(new ImageIcon(getClass().getResource("/imgs/title_close_over.png")));
                    break;
                case ROUND:
                    boton.setIcon(new ImageIcon(getClass().getResource("/imgs/button_close_16.png")));
                    boton.setPressedIcon(new ImageIcon(getClass().getResource("/imgs/button_close_pressed_16.png")));
                    boton.setRolloverIcon(new ImageIcon(getClass().getResource("/imgs/button_close_over_16.png")));
                    break;
            }
            boton.addActionListener(this);
            add(boton, "East");
        }

        public void actionPerformed(ActionEvent e) {
            if (!_TabbedPaneClose.this.isConfirmacion()) {
                this.pane.remove(this.pane.indexOfTabComponent(this));
            } else if (JOptionPane.showConfirmDialog(this.pane, "Desea remover el componente", "Remover", 0) == 0) {
                this.pane.remove(this.pane.indexOfTabComponent(this));
            }
        }
    }

    public void addTab(String title, Component component) {
        super.addTab(title, component);
        setTabComponentAt(getTabCount() - 1, new PanelTitle(title, this));
    }

    public boolean isConfirmacion() {
        return this.confirmacion;
    }

    public void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Modelo getModelo() {
        return this.modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    private static BufferedImage loadImage(String fileName) {
        try (InputStream inputStream = _TabbedPaneClose.class.getResourceAsStream(fileName)) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Image " + fileName + " wasn't loaded");
        }
    }
}
