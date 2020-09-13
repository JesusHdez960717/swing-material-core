/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.Utils;
import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 * Si se quiere personalizar el componente que se le pasa por parámetro se
 * reimplementa el metodo buildComponent.
 * <pre>
 *  new Popup(actions) {
 *      @Override
 *      protected JComponent buildComponent(Action act) {
 *          MaterialButton b = MaterialButtonsFactory.buildRound();
 *          b.setAction(act);
 *          return b;
 *      }
 *  }
 * </pre>
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Popup extends JPopupMenu {

    public Popup(List<Action> actions) {
        this.setBorderPainted(false);

        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);

        List<JComponent> list = buildComponents(actions);
        Panel panel = new Panel(list, (int) list.get(0).getPreferredSize().getWidth());

        this.setPreferredSize(panel.getPreferredSize());

        this.setLayout(new BorderLayout());
        this.add(panel);
    }

    private List<JComponent> buildComponents(List<Action> actions) {
        List<JComponent> comp = new ArrayList<>();
        for (Action action : actions) {
            comp.add(buildComponent(action));
        }
        return comp;
    }

    protected JComponent buildComponent(Action act) {
        return ButtonSqrt.from(act);
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
