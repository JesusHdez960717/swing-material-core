/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

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
  new PopupCircular(actions) {
      @Override
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
public class PopupCircular extends JPopupMenu {

    public static PopupCircular from(List<Action> actions) {
        return new PopupCircular(actions);
    }

    public PopupCircular(List<Action> actions) {
        this.setBorderPainted(false);

        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);

        List<JComponent> list = buildComponents(actions);
        PanelCircular panel = new PanelCircular(list, (int) list.get(0).getPreferredSize().getWidth());

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
                AWTUtilities.setWindowOpaque(w, false);
            } catch (Exception e) {
                System.out.println("Error poniendo el opaque a la ventana de popup, en realidad no afecta en nada.");
            }
        }
    }

}
