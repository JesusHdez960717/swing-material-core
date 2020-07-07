package com.jhw.swing.examples.application;

import com.jhw.swing.material.components.login.DefaultLoginPanel;
import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.DefaultRootView;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.examples.application.dashboard.DashBoardFormateer;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.components.login._LoginPanel;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.notification.fade.NotificationDialogGeneral;
import com.jhw.swing.util.JOP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RootViewFrame extends DefaultRootView {

    public RootViewFrame(PropertyChangeListener listener) {
        super(listener);
        startLogin();
        startDashboard();
        startLicence();
        startCompany();
        //navigateTo(DASH_NAME);
        navigateTo(LOGIN_NAME);
    }

    private void startLogin() {
        setLogin(new DefaultLoginPanel());
    }

    private void startDashboard() {
        DashBoardExtends dash = new DashBoardExtends();
        dash.setDashBoardFormatter(DashBoardFormateer.dashBoardFormatter);
        dash.setUpPanelFormatter(DashBoardFormateer.upPanelFormatter);
        dash.setDownPanelFormatter(DashBoardFormateer.downPanelFormatter);
        dash.setMenuFormateer(DashBoardFormateer.collapseMenuFormatter);
        dash.setButtonFormatter(DashBoardFormateer.buttonFormatter);

        setDashBoard(dash);
    }

    private void startLicence() {
        dashboard().putKeyValue(DashboardConstants.DOWN_LICENCE, new AbstractAction("Vence en X Dias", MaterialIcons.SECURITY.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("ACTIVAR LICENCIA");
            }
        });
        firePropertyChange("licencia", null, null);
    }

    private void startCompany() {
        dashboard().putKeyValue(DashboardConstants.UP_COMPANY, new AbstractAction("NOMBRE", MaterialIcons.PERSON.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("hello world");
            }
        });
    }

}
