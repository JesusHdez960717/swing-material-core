package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashboardExtendedDown;
import com.clean.swing.app.dashboard.DashboardExtendedUp;
import com.clean.swing.app.dashboard.DashboardSimple;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import java.awt.Color;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import java.awt.Component;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardExtends extends DashboardSimple<CollapseMenu> implements DashboardExtendedDown<Action>, DashboardExtendedUp<Component> {

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

    @Override
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

    @Override
    public void addDownElement(Action element) {
        downPanel.addDownElement(element);
    }

    @Override
    public void setLicence(Action action) {
        downPanel.setLicence(action);
    }

    @Override
    public void addUpElement(Component element) {
        upPanel.addUpElement(element);
    }

    @Override
    public void setCompany(Action action) {
        upPanel.setCompany(action);
    }

}
