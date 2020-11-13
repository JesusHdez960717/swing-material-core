package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import java.awt.Color;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.util.enums.GradientEnum;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardExtends extends DashBoardSimple {

    private Consumer<DashBoardExtends> dashBoardFormatter = (DashBoardExtends dash) -> {
    };

    private Consumer<UpPanel> upPanelFormatter = (UpPanel up) -> {
    };

    private Consumer<DownPanel> downPanelFormatter = (DownPanel down) -> {
    };

    public DashBoardExtends() {
        initComponents();
    }

    @Override
    public void format() {
        downPanel.format(downPanelFormatter);
        upPanel.format(upPanelFormatter);
        dashBoardFormatter.accept(this);
        dashboardCore.format();
    }

    public void setButtonFormatter(Consumer<TaskButton> buttonFormatter) {
        this.dashboardCore.setButtonFormatter(buttonFormatter);
    }

    public void setDashBoardFormatter(Consumer<DashBoardExtends> dashBoardFormatter) {
        this.dashBoardFormatter = dashBoardFormatter;
    }

    public void setUpPanelFormatter(Consumer<UpPanel> upPanelFormatter) {
        this.upPanelFormatter = upPanelFormatter;
    }

    public void setDownPanelFormatter(Consumer<DownPanel> downPanelFormatter) {
        this.downPanelFormatter = downPanelFormatter;
    }

    public void setMenuFormateer(Consumer<CollapseMenu> menuFormateer) {
        dashboardCore.setMenuFormatter(menuFormateer);
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
        this.dashboardCore.update(hm);
        //this.revalidate();
    }

    @Override
    public void deselectAll() {
        this.dashboardCore.deselectAll();
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

    @Override
    public Component getView(String string) {
        return dashboardCore.getView(string);
    }

    @Override
    public String getSelectedViewName() {
        return dashboardCore.getSelectedViewName();
    }

    @Override
    public void removeView(Component ct) {
        dashboardCore.removeView(ct);
    }

    @Override
    public Map<String, Component> getAll() {
        return dashboardCore.getAll();
    }

}
