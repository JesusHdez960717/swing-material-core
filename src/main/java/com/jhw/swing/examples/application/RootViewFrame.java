package com.jhw.swing.examples.application;

import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.clean.swing.utils.CardComponent;
import com.jhw.swing.examples.application.dashboard.DashBoardFormateer;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.util.JOP;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RootViewFrame extends JFrame implements com.clean.swing.app.RootView, CardComponent<Component> {

    private DashBoardSimple DASHBOARD;

    private final CardLayout cards = new CardLayout();

    public RootViewFrame() {
        initComponents();
        startDashboard();
        startLicence();
        startCompany();
        this.setVisible(true);
    }

    private void startDashboard() {
        DashBoardExtends dash = new DashBoardExtends();
        dash.setDashBoardFormatter(DashBoardFormateer.dashBoardFormatter);
        dash.setUpPanelFormatter(DashBoardFormateer.upPanelFormatter);
        dash.setDownPanelFormatter(DashBoardFormateer.downPanelFormatter);
        dash.setMenuFormateer(DashBoardFormateer.collapseMenuFormatter);
        dash.setButtonFormatter(DashBoardFormateer.buttonFormatter);

        DASHBOARD = dash;
        this.addView(DASH_NAME, DASHBOARD);
    }

    private void startLicence() {
        DASHBOARD.putKeyValue(DashboardConstants.DOWN_LICENCE, new AbstractAction("Vence en X Dias", MaterialIcons.SECURITY.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("ACTIVAR LICENCIA");
            }
        });
    }

    private void startCompany() {
        DASHBOARD.putKeyValue(DashboardConstants.UP_COMPANY, new AbstractAction("NOMBRE", MaterialIcons.PERSON.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("hello world");
            }
        });
    }

    private void initComponents() {
        this.panelContent = new JPanel();
        this.panelContent.setLayout(cards);

        this.setLayout(new BorderLayout());
        this.add(panelContent, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        pack();
    }

    private JPanel panelContent;

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    @Override
    public void showView(String name) {
        cards.show(panelContent, name);
    }

    @Override
    public void addView(String name, Component compoment) {
        panelContent.add(name, compoment);
    }

    @Override
    public DashBoardSimple dashboard() {
        return DASHBOARD;
    }

    @Override
    public void registerModule(AbstractSwingModule... modulesToInstall) {

    }

    @Override
    public void navigateTo(String string, Object o) {
        return;
    }

}
