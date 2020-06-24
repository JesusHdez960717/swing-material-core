package com.jhw.swing.util;

import java.awt.Component;
import javax.swing.JPanel;
import com.jhw.swing.util.interfaces.Update;

/**
 * Actualiza recursivamente una serie de elementos que implementes la interfaz
 * actualizable.
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class UpdateCascade {

    private final Update[] actualizables;

    public UpdateCascade(Update act) {
        this(new Update[]{act});
    }

    public UpdateCascade(Update[] actualizables) {
        this.actualizables = actualizables;
    }

    public void updateCascade() {
        try {
            for (Update act : actualizables) {
                act.update();//actualiza todos
                if (act instanceof JPanel) {//si es panel se mete adentro
                    updateCascadeRecursive((JPanel) act);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCascadeRecursive(JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof Update) {//si el actaulizable lo actualiza
                ((Update) c).update();
            }
            if (c instanceof JPanel) {//si es panel se mete adentro
                updateCascadeRecursive((JPanel) c);
            }
        }
    }
}
