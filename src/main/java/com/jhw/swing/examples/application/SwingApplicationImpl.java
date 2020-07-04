package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.dashboard.DashBoardFormateer;
import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerService;
import com.clean.core.app.services.Navigation;
import com.clean.core.app.services.NavigationService;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationService;
import com.clean.core.domain.services.Resource;
import com.clean.core.domain.services.ResourceBundleUtils;
import com.clean.core.domain.services.ResourceService;
import com.clean.core.domain.services.ResourceServiceImpl;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.swing.util.AbstractActionUtils;
import com.jhw.swing.util.JOP;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SwingApplicationImpl implements AbstractSwingApplication {

    public static final String DASH_NAME = "DASHBOARD";
    public static final String LOGIN_NAME = "LOGIN";

    private static ExceptionHandlerService EXCEPTION_HANDLER;

    private static NotificationService NOTIFICATION;

    private static NavigationService NAVIGATION;

    private static ResourceService RESOURCE;

    private static MainFrame FRAME;

    private static DashBoardSimple DASHBOARD;

    private final static ArrayList<AbstractSwingModule> INSTALLED_MODULES = new ArrayList<>();

    @Override
    public void run() throws Exception {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        ExceptionHandler.registerExceptionHandlerService(new ExceptionService());
        EXCEPTION_HANDLER = ExceptionHandler.getExceptionHandlerService();

        Notification.registerNotificationService(new NotifService());
        NOTIFICATION = Notification.getNotificationService();

        Navigation.registerNavigationService(new NavServiceImp());
        NAVIGATION = Navigation.getNavigationService();

        Resource.registerResourceService(new ResourceServiceImpl(ResourceBundleUtils.fromExternalFile(new File("E:\\Trabajos\\Projects\\GIT Projects Gradle\\messages"), ResourceBundleUtils.SPANISH)));
        RESOURCE = Resource.getResourceService();

        FRAME = new MainFrame();
        registerDashBoard();

        FRAME.showView(DASH_NAME);
        FRAME.setVisible(true);
    }

    @Override
    public void navigateTo(String string, Object o) {
        for (AbstractSwingModule abstractSwingModule : INSTALLED_MODULES) {
            abstractSwingModule.navigateTo(string, o);
        }
    }

    private void registerDashBoard() {
        DashBoardExtends dash = new DashBoardExtends();
        dash.setDashBoardFormatter(DashBoardFormateer.dashBoardFormatter);
        dash.setUpPanelFormatter(DashBoardFormateer.upPanelFormatter);
        dash.setDownPanelFormatter(DashBoardFormateer.downPanelFormatter);
        dash.setMenuFormateer(DashBoardFormateer.collapseMenuFormatter);
        dash.setButtonFormatter(DashBoardFormateer.buttonFormatter);

        dash.putKeyValue(DashboardConstants.DOWN_LICENCE, new AbstractAction("Vence en X Dias", MaterialIcons.SECURITY.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("ACTIVAR LICENCIA");
            }
        });

        dash.putKeyValue(DashboardConstants.UP_COMPANY, new AbstractAction("NOMBRE", MaterialIcons.PERSON.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOP.error("hello world");
            }
        });
        DASHBOARD = dash;
        FRAME.addView(DASH_NAME, DASHBOARD);
    }

    @Override
    public void registerModule(AbstractSwingModule... moduleToInstall) {
        for (AbstractSwingModule modulo : moduleToInstall) {
            modulo.register(this);
            this.installedModules().add(modulo);
        }
        DASHBOARD.update(dashboard().getMap());//este es que al final actualiza todo
        DASHBOARD.format();
    }

    @Override
    public ExceptionHandlerService exceptionHandler() {
        return EXCEPTION_HANDLER;
    }

    @Override
    public ResourceService resource() {
        return RESOURCE;
    }

    @Override
    public NotificationService notification() {
        return NOTIFICATION;
    }

    @Override
    public NavigationService navigation() {
        return NAVIGATION;
    }

    @Override
    public DashBoardSimple dashboard() {
        return DASHBOARD;
    }

    @Override
    public List<AbstractSwingModule> installedModules() {
        return INSTALLED_MODULES;
    }

}
