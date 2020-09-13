/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button.MaterialButton;
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
import javax.swing.JButton;
import javax.swing.JComponent;
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

    public Popup() {
        this.setBorderPainted(false);

        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);

        for (int i = 0; i < 8; i++) {
            actions.add(new AbstractAction("EXCEL", MaterialIcons.ADD_A_PHOTO) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Click en el boton.");
                }
            });
        }
        Panel panel = new Panel();

        List<JComponent> list = buildButtons();
        panel.setUpActions(list, (int) list.get(0).getPreferredSize().getWidth());
        this.setPreferredSize(panel.getPreferredSize());

        this.setLayout(new BorderLayout());
        this.add(panel);
    }

    private List<JComponent> buildButtons() {
        List<JComponent> comp = new ArrayList<>();
        for (Action action : actions) {
            comp.add(buildButton(action));
        }
        return comp;
    }

    private JButton buildButton(Action act) {
        return new Button(act);
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
