/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.dashboard.taskpane.expanded;

import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import java.awt.BorderLayout;
import java.awt.Color;
import com.root101.swing.material.components.taskpane.CollapseMenu;
import com.root101.swing.material.components.taskpane.TaskButton;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
