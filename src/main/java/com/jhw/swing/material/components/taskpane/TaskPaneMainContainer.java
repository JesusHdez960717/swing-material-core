package com.jhw.swing.material.components.taskpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.Border;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskPaneMainContainer extends JXCollapsiblePane {

    private JXTaskPaneContainer taskPane = new JXTaskPaneContainer();

    public TaskPaneMainContainer() {
        setDirection(JXCollapsiblePane.Direction.LEFT);
        this.setLayout(new BorderLayout());
        this.add(taskPane, BorderLayout.CENTER);

        setComponentsGap(0);
        setInternalBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        this.setBackground(Color.red);
        this.getContentPane().setBackground(Color.red);
        taskPane.setBackground(Color.red);
    }

    public void setComponentsGap(int gap) {
        ((VerticalLayout) taskPane.getLayout()).setGap(gap);
    }

    public void setInternalBorder(Border border) {
        taskPane.setBorder(border);
    }

    public void addItem(CollapseMenu menu) {
        this.taskPane.add(menu);
    }
}
