package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.services.ExceptionServiceImplementation;
import com.jhw.swing.examples.application.services.NotificationServiceImplementation;
import com.jhw.swing.examples.application.services.NavigationServiceImplementation;
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
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.swing.UIManager;
import com.clean.swing.app.RootView;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SwingApplication implements AbstractSwingApplication {

    private static ExceptionHandlerService EXCEPTION_HANDLER;

    private static NotificationService NOTIFICATION;

    private static NavigationService NAVIGATION;

    private static ResourceService RESOURCE;

    private static RootView ROOT_VIEW;

    private final static ArrayList<AbstractSwingModule> INSTALLED_MODULES = new ArrayList<>();

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
    }

    @Override
    public void startRootView() throws Exception {
        ROOT_VIEW = new RootViewFrame();
    }

    @Override
    public void startApplication() throws Exception {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());
    }

    @Override
    public void navigateTo(String string, Object... o) {
        rootView().navigateTo(string, o);
        for (AbstractSwingModule abstractSwingModule : INSTALLED_MODULES) {
            abstractSwingModule.navigateTo(string, o);
        }
    }

    @Override
    public void registerModule(AbstractSwingModule... modulesToInstall) {
        for (AbstractSwingModule modulo : modulesToInstall) {
            modulo.register(this);
            this.installedModules().add(modulo);
        }
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
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
    public List<AbstractSwingModule> installedModules() {
        return INSTALLED_MODULES;
    }

}
