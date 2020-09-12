/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.Utils;
import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Popup extends JPopupMenu {

    private final List<Action> actions = new ArrayList<Action>();

    private int w = 200;

    public Popup() {
        this.setBorderPainted(false);

        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);

        this.setPreferredSize(new Dimension(w, w));

        for (int i = 0; i < 10; i++) {
            actions.add(new AbstractAction("" + i, MaterialIcons.ADD_A_PHOTO) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Click en el boton.");
                }
            });
        }
        Panel panel = new Panel();
        panel.setPreferredSize(new Dimension(w, w));
        panel.setUpActions(actions);
        this.setLayout(new BorderLayout());
        this.add(panel);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Window w = SwingUtilities.getWindowAncestor(this);
        if (b) {
            try {
                Point mousePos = MouseInfo.getPointerInfo().getLocation();

                Rectangle screen = Utils.getScreenSize();
                int x = (int) (mousePos.getX() - getPreferredSize().getWidth() / 2);
                x = Math.max(0, Math.min((int) (screen.getWidth() - getPreferredSize().getWidth()), x));

                int y = (int) (mousePos.getY() - getPreferredSize().getWidth() / 2);
                y = Math.max(0, Math.min((int) (screen.getHeight() - getPreferredSize().getHeight()), y));

                w.setLocation(x, y);//middle of the click
                AWTUtilities.setWindowOpaque(w, false);
            } catch (Exception e) {
            }
        }
    }

}
