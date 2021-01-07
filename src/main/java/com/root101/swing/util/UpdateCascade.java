/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * actualizar ninguno xq el bind directo con el caso de uso
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
