package com.jhw.swing.util;

import com.jhw.utils.interfaces.Update;
import java.awt.Component;
import java.awt.Container;

/**
 * Actualiza recursivamente una serie de elementos que implementes la interfaz
 * actualizable.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UpdateCascade {

    private final Update[] toUpdate;

    public UpdateCascade(Update... toUpdate) {
        this.toUpdate = toUpdate;
    }

    public static UpdateCascade from(Update... actualizables) {
        return new UpdateCascade(actualizables);
    }

    public void updateCascade() {
        try {
            for (Update act : toUpdate) {
                act.update();//actualiza todos
                if (act instanceof Container) {//si es container se mete adentro
                    updateCascadeRecursive((Container) act);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCascadeRecursive(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof Update) {//si el actaulizable lo actualiza
                ((Update) c).update();
            }
            if (c instanceof Container) {//si es panel se mete adentro
                updateCascadeRecursive((Container) c);
            }
        }
    }
}
