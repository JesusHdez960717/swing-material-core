package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.components.scrollpane.SmoothScrollMouseWheelListener;
import com.jhw.swing.material.components.scrollpane._MaterialScrollBar;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.ui.componentsui.panel.MaterialPanelUI;
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskPaneMainContainer extends JXCollapsiblePane {

    private final JXTaskPaneContainer taskPane = new JXTaskPaneContainer();
    private final _MaterialScrollPaneCore scrollPane = new _MaterialScrollPaneCore();

    public TaskPaneMainContainer() {
        initComponents();
    }

    private void initComponents() {
        //sobreescribir el ui para que coja los colores
        taskPane.setUI(new MaterialPanelUI());

        //direction del collapse
        setDirection(JXCollapsiblePane.Direction.LEFT);

        //layout
        this.setLayout(new BorderLayout());

        //add el scroll
        this.add(scrollPane, BorderLayout.CENTER);

        //add el task pane al scroll
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setViewportView(taskPane);

        //retoques a la visual, quitados gap y border
        setComponentsGap(0);
        setInternalBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        //quita el border al scroll pane
        scrollPane.setBorder(null);
    }

    public void clear() {
        taskPane.removeAll();
    }

    public void setTaskPaneBackground(Color color) {
        this.taskPane.setBackground(color);
        this.scrollPane.getMaterialVerticalScrollBar().setBackgroundThumb(color);
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
