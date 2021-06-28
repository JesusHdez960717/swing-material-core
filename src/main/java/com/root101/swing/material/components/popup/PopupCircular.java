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
package com.root101.swing.material.components.popup;

import com.root101.swing.material.standards.MaterialColors;
//import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 * Si se quiere personalizar el componente que se le pasa por parámetro se
 * reimplementa el metodo buildComponent.
 * <pre>
 * new PopupCircular(actions) {
 * @Override
 *      protected JComponent buildComponent(Action act) {
 *          MaterialButton b = MaterialButtonsFactory.buildRound();
 *          b.setAction(act);
 *          return b;
 *      }
 *  }
 * </pre>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
            if (action instanceof AbstractAction) {
                AbstractAction a = (AbstractAction) action;
                if (a.getKeys() != null) {
                    Action aop = new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            a.actionPerformed(e);
                            setVisible(false);
                        }
                    };
                    for (Object key : a.getKeys()) {
                        String keyStr = (String) key;
                        aop.putValue(keyStr, a.getValue(keyStr));
                    }
                    comp.add(buildComponent(aop));
                } else {
                    comp.add(buildComponent(action));
                }
            } else {
                comp.add(buildComponent(action));
            }
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
                //AWTUtilities.setWindowOpaque(w, false);//TODO
            } catch (Exception e) {
                System.out.println("Error poniendo el opaque a la ventana de popup, en realidad no afecta en nada.");
            }
        }
    }

}
