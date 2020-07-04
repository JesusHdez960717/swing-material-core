package com.jhw.swing.examples.application;

import com.clean.core.app.services.Navigation;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.examples.application.dashboard.DashBoardFormateer;
import com.jhw.swing.examples.model.CargoDetailView;
import com.jhw.swing.examples.model.CargoPanel;
import com.jhw.swing.examples.standars.MATERIAL_ICONS_EXAMPLE;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.button._MaterialButtonFlat;
import com.jhw.swing.material.components.button._MaterialButtonTransparent;
import com.jhw.swing.material.components.button._MaterialIconButtonRound;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.util.AbstractActionUtils;
import com.jhw.swing.util.JOP;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class SampleSwingModule implements AbstractSwingModule {

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app.dashboard());
        registerUpElements(app.dashboard());
        registerDownElements(app.dashboard());
    }

    private void registerMainElements(DashBoardSimple dash) {
        try {
            CollapseMenu menu1 = new CollapseMenu(MaterialIcons.ADD, "menu 1", dash);

            for (int i = 0; i < 9; i++) {
                String view_1_i = "view 1," + i;
                dash.addView(view_1_i, new CargoDetailView());
                menu1.addMenuItem(new AbstractAction("button 1," + i, MATERIAL_ICONS_EXAMPLE.getRandomIcon()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dash.showView(view_1_i);
                    }
                });
            }

            new SingleCollapseMenu(new AbstractAction("456", MaterialIcons.GIF) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Navigation.navigateTo("ABC", null);
                }
            }, dash);

        } catch (Exception e) {
        }
    }

    private void registerUpElements(DashBoardSimple dash) {
        _MaterialButton btn = new _MaterialButton();
        btn.setPreferredSize(new Dimension(100, 100));
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, btn);
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, new _MaterialButtonFlat());
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, new _MaterialIconButtonRound());
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, new _MaterialButtonTransparent());
    }

    private void registerDownElements(DashBoardSimple dash) {
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_GITKRAKEN));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_GIT));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_JAVA));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_NB));
    }

    @Override
    public void navigateTo(String string, Object o) {
        JOP.error("MOSTRAR LA VISTA " + string);
    }

}
