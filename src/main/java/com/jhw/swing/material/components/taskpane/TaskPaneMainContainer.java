package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.ui.componentsui.panel.MaterialPanelUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.Border;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.VerticalLayout;
import org.jdesktop.swingx.plaf.TaskPaneContainerUI;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskPaneMainContainer extends JXCollapsiblePane {

    private JXTaskPaneContainer taskPane = new JXTaskPaneContainer();

    public TaskPaneMainContainer() {
        taskPane.setUI(new MaterialPanelUI());//sobreescribir el ui para que coja los colores
        setDirection(JXCollapsiblePane.Direction.LEFT);
        this.setLayout(new BorderLayout());
        this.add(taskPane, BorderLayout.CENTER);

        setComponentsGap(0);
        setInternalBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public void setTaskPaneBackground(Color color) {
        this.taskPane.setBackground(color);
    }

    public void setComponentsGap(int gap) {
        if (taskPane.getLayout() != null && taskPane.getLayout() instanceof VerticalLayout) {
            ((VerticalLayout) taskPane.getLayout()).setGap(gap);
        }
    }

    public void setInternalBorder(Border border) {
        taskPane.setBorder(border);
    }

    public void addItem(CollapseMenu menu) {
        this.taskPane.add(menu);
    }
}
