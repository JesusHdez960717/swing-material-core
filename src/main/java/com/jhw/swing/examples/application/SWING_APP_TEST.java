package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.services.EXCEPTION_SERVICE;
import com.jhw.swing.examples.application.services.NOTIF_SERV;
import com.jhw.swing.examples.application.services.NAV_SERVICE;
import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerService;
import com.clean.core.app.services.LoginHandler;
import com.clean.core.app.services.LoginHandlerService;
import com.clean.core.app.services.Navigation;
import com.clean.core.app.services.NavigationService;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationService;
import com.clean.core.domain.services.Resource;
import com.clean.core.domain.services.ResourceBundleUtils;
import com.clean.core.domain.services.ResourceService;
import com.clean.core.domain.services.ResourceServiceImpl;
import com.clean.swing.app.AbstractSwingModule;
import com.clean.swing.app.DefaultSwingApplication;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.swing.UIManager;
import com.clean.swing.app.RootView;
import com.jhw.swing.examples.application.services.LOGIN_SERVICE;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SWING_APP_TEST extends DefaultSwingApplication {

    private static RootView ROOT_VIEW;

    @Override
    public void startServices() throws Exception {
        ExceptionHandler.registerExceptionHandlerService(new EXCEPTION_SERVICE());

        Notification.registerNotificationService(new NOTIF_SERV());

        Navigation.registerNavigationService(new NAV_SERVICE());

        Resource.registerResourceService(new ResourceServiceImpl(ResourceBundleUtils.fromExternalFile(new File("E:\\Trabajos\\Projects\\GIT Projects Gradle\\messages"), ResourceBundleUtils.SPANISH)));

        LoginHandler.registerLoginHandlerService(new LOGIN_SERVICE());
    }

    @Override
    public void startRootView() throws Exception {
        ROOT_VIEW = new ROOT_VIEW_FRAME(this);
    }

    @Override
    public void startApplication() throws Exception {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());
    }

    @Override
    public void closeApplication() {
        System.out.println("Cerrando la aplicacion");
    }

    @Override
    public RootView rootView() {
        return ROOT_VIEW;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);//llamar al super para que coja el close windows
    }

}
