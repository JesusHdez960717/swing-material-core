package com.root101.swing.util;

import com.root101.utils.interfaces.Update;
import java.awt.Component;
import java.awt.Container;

/**
 * @Deprecated <br/>
 * Actualiza recursivamente una serie de elementos que implementes la interfaz
 * actualizable.
 *
 * @THIS <br/>
 * Ya no actualiza todos los componentes recursivamente, xq cada componente
 * tiene que saber quienes son los hijos que va a actualizar. Ahora solo se
 * limita a actualizar la lista de componentes, que eventualmente no va a
 * actualizar ninguno xq el bind direcot con el caso de uso
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
            if (toUpdate != null) {
                for (Update upd : toUpdate) {
                    if (upd != null) {
                        upd.update();
                    }
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
