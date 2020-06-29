package com.jhw.swing.material.components.taskpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskPaneContainer extends JXCollapsiblePane {

    private JXTaskPaneContainer taskPane = new JXTaskPaneContainer();

    public TaskPaneContainer() {
        setDirection(JXCollapsiblePane.Direction.LEFT);
        setMinimumSize(new Dimension(90, 0));
        this.setLayout(new BorderLayout());
        this.add(taskPane, BorderLayout.CENTER);
        this.getContentPane().setBackground(Color.yellow);
    }

    public void addMenuItem(CollapseMenu menu) {
        this.taskPane.add(menu);
    }
}
