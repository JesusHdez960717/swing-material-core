package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.services.ExceptionServiceImplementation;
import com.jhw.swing.examples.application.services.NotificationServiceImplementation;
import com.jhw.swing.examples.application.services.NavigationServiceImplementation;
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
import com.jhw.swing.examples.application.services.LoginServiceImplementation;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SwingApplication extends DefaultSwingApplication {

    private static ExceptionHandlerService EXCEPTION_HANDLER;

    private static NotificationService NOTIFICATION;

    private static NavigationService NAVIGATION;

    private static ResourceService RESOURCE;

    private static LoginHandlerService LOGIN_HANDLER;

    private static RootView ROOT_VIEW;

    @Override
    public void startServices() throws Exception {
        ExceptionHandler.registerExceptionHandlerService(new ExceptionServiceImplementation());
        EXCEPTION_HANDLER = ExceptionHandler.getExceptionHandlerService();

        Notification.registerNotificationService(new NotificationServiceImplementation());
        NOTIFICATION = Notification.getNotificationService();

        Navigation.registerNavigationService(new NavigationServiceImplementation());
        NAVIGATION = Navigation.getNavigationService();

        Resource.registerResourceService(new ResourceServiceImpl(ResourceBundleUtils.fromExternalFile(new File("E:\\Trabajos\\Projects\\GIT Projects Gradle\\messages"), ResourceBundleUtils.SPANISH)));
        RESOURCE = Resource.getResourceService();

        LoginHandler.registerLoginHandlerService(new LoginServiceImplementation());
        LOGIN_HANDLER = LoginHandler.getLoginHandlerService();
    }

    @Override
    public void startRootView() throws Exception {
        ROOT_VIEW = new RootViewFrame(this);
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
    public LoginHandlerService login() {
        return LOGIN_HANDLER;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
    }

}
