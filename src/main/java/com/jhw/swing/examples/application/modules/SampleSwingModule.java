package com.jhw.swing.examples.application.modules;

import com.clean.core.app.services.Navigation;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.examples.model.CargoDetailView;
import com.jhw.swing.examples.standars.MATERIAL_ICONS_EXAMPLE;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.button._MaterialButtonFlat;
import com.jhw.swing.material.components.button._MaterialButtonTransparent;
import com.jhw.swing.material.components.button._MaterialIconButtonRound;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.util.AbstractActionUtils;
import com.jhw.swing.util.JOP;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class SampleSwingModule implements AbstractSwingModule {

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
        registerUpElements(app);
        //registerDownElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();
        CollapseMenu menu1 = new CollapseMenu(MaterialIcons.ADD, "menu 1");
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu1);
        for (int i = 0; i < 9; i++) {
            String view_1_i = "view 1," + i;
            dash.addView(view_1_i, new CargoDetailView());
            menu1.addMenuItem(new AbstractAction("button 1," + i, MATERIAL_ICONS_EXAMPLE.getRandomIcon()) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    app.navigateTo(view_1_i);
                }
            });
        }

        SingleCollapseMenu singleMenu = new SingleCollapseMenu(new AbstractAction("456", MaterialIcons.GIF) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo("ABC");
            }
        });
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, singleMenu);

    }

    private void registerUpElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, 
                new AbstractAction("Hello World", MaterialIcons.ANDROID.deriveIcon(Color.yellow)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(SampleModuleNavigator.NAV_TEST);
            }
        });
        dash.addKeyValue(DashboardConstants.UP_ELEMENT, new AbstractAction("Hello World", MaterialIcons.NAVIGATION) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo("view 1,6");
            }
        });
    }

    private void registerDownElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_GITKRAKEN));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_GIT));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_JAVA));
        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, AbstractActionUtils.from(MaterialIcons.TEC_NB));
    }

    SampleModuleNavigator navigator = new SampleModuleNavigator();

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
