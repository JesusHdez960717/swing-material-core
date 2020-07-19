package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.services.EXCEPTION_SERVICE;
import com.jhw.swing.examples.application.services.NOTIF_SERV;
import com.jhw.swing.examples.application.services.NAV_SERVICE;
import com.clean.swing.app.DefaultSwingApplication;
import com.jhw.swing.ui.MaterialLookAndFeel;
import javax.swing.UIManager;
import com.jhw.swing.examples.application.services.LOGIN_SERVICE;
import com.jhw.swing.examples.application.services.RES_SERV;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SWING_APP_TEST extends DefaultSwingApplication {

    @Override
    public void init() throws Exception {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());
        initRootView(new ROOT_VIEW_FRAME(this));

        EXCEPTION_SERVICE.init();
        NOTIF_SERV.init();
        NAV_SERVICE.init();
        RES_SERV.init();
        LOGIN_SERVICE.init();
    }

    @Override
    public void closeApplication() {
        System.out.println("Cerrando la aplicacion");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);//llamar al super para que coja el close windows
    }

}
