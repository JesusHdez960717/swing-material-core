package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardExtends extends JPanel {

    public DashBoardExtends() {
        initComponents();
        dashboardCore.setFormateer(new CollapseMenuFormateerImpl());
    }

    private void initComponents() {
        dashboardCore = new DashBoardTaskPane();
        downPanel = new DownPanel();

        this.setLayout(new BorderLayout());
        this.add(dashboardCore, BorderLayout.CENTER);
        this.add(downPanel, BorderLayout.SOUTH);
    }

    private DashBoardTaskPane dashboardCore;
    private DownPanel downPanel;

    public DashBoardTaskPane getDashboardCore() {
        return dashboardCore;
    }

}
