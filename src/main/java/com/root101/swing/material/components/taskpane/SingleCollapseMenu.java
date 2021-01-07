package com.root101.swing.material.components.taskpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXCollapsiblePane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SingleCollapseMenu extends CollapseMenu {

    private final Action action;

    public SingleCollapseMenu(Action action) {
        this(action, true);
    }

    public SingleCollapseMenu(Action action, boolean seleccionable) {
        super((ImageIcon) action.getValue(Action.SMALL_ICON), action.getValue(Action.NAME).toString());
        this.action = action;

        if (seleccionable) {
            getjButtonIcono().addActionListener(childSelectedListener);
            getjButtonNombre().addActionListener(childSelectedListener);
        }
    }

    @Override
    protected void configurateUI() {
        super.configurateUI();
        this.getjLabel1().setVisible(false);
        getjPanelCollapsible().getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION).actionPerformed(null);
    }

    @Override
    protected void addListeners() {
        this.getjButtonNombre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
        this.getjButtonIcono().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
    }
}
