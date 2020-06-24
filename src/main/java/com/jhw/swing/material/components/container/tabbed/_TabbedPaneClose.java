package com.jhw.swing.material.components.container.tabbed;

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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su lógica de edisoncorSX.
 */
public class _TabbedPaneClose extends JTabbedPane implements MaterialComponent {

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
