package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import java.awt.Color;
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
        upPanel = new UpPanel();

        this.setLayout(new BorderLayout());
        this.add(dashboardCore, BorderLayout.CENTER);
        this.add(downPanel, BorderLayout.SOUTH);
        this.add(upPanel, BorderLayout.NORTH);
    }

    private DashBoardTaskPane dashboardCore;
    private DownPanel downPanel;
    private UpPanel upPanel;

    public DashBoardTaskPane getDashboardCore() {
        return dashboardCore;
    }

    public DownPanel getDownPanel() {
        return downPanel;
    }

    public UpPanel getUpPanel() {
        return upPanel;
    }

    public void setPanelSideMenuColor(Color background) {
        dashboardCore.setPanelSideMenuColor(background);
    }
}
