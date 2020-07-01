package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.components.scrollpane.SmoothScrollMouseWheelListener;
import com.jhw.swing.material.components.scrollpane._MaterialScrollBar;
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

    private JXTaskPaneContainer taskPane = new JXTaskPaneContainer();

    private _MaterialScrollBar scrollBar = new _MaterialScrollBar(Adjustable.VERTICAL);

    public TaskPaneMainContainer() {
        taskPane.setUI(new MaterialPanelUI());//sobreescribir el ui para que coja los colores
        setDirection(JXCollapsiblePane.Direction.LEFT);
        this.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane();
        pane.setVerticalScrollBar(scrollBar);//primero el scroll y despues el listener
        pane.addMouseWheelListener(new SmoothScrollMouseWheelListener(pane));
        pane.setBorder(null);

        this.add(pane, BorderLayout.CENTER);

        pane.setLayout(new ScrollPaneLayout());
        pane.setViewportView(taskPane);

        setComponentsGap(0);
        setInternalBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public void setTaskPaneBackground(Color color) {
        this.taskPane.setBackground(color);
        this.scrollBar.setBackgroundThumb(color);
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
