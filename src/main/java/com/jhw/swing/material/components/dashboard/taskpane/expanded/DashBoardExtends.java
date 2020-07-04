package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import java.awt.Color;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import java.awt.Component;
import java.util.HashMap;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardExtends extends DashBoardSimple {

    public DashBoardExtends() {
        initComponents();
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

    @Override
    public void update(HashMap<String, Object> hm) {
        this.downPanel.update(hm);
        this.upPanel.update(hm);
        //this.dashboardCore.update(hm);
        //this.revalidate();
    }

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

    public void addMainElement(CollapseMenu mt) {
        dashboardCore.addMainElement(mt);
    }

    @Override
    public void addView(String string, Component jc) {
        dashboardCore.addView(string, jc);
    }

    @Override
    public void showView(String string) {
        dashboardCore.showView(string);
    }

}
