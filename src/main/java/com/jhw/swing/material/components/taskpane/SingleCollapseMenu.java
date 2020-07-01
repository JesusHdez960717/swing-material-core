package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
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

    public SingleCollapseMenu(Action action, DashBoardTaskPane parent) {
        super((ImageIcon) action.getValue(Action.SMALL_ICON), action.getValue(Action.NAME).toString(), parent);
        this.action = action;
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
