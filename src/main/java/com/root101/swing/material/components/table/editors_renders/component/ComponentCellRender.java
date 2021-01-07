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
package com.root101.swing.material.components.table.editors_renders.component;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ComponentCellRender<T> extends DefaultTableCellRenderer implements TableCellRenderer {

    private final HashMap<Integer, T> map = new HashMap<>();
    private boolean paintBackground = true;

    public ComponentCellRender() {
    }

    /**
     * Este constructor se creo para en caso de que no se quiera pintar el
     * background de un componeente con el selected.<\br>
     * Por ejemplo, supongamos que se tienen dos componentes, uno boton y un
     * panel, el boton quiere que se pinte el background de acuerdo a si esta
     * seleccionado o no. Pero si el panel es para mostrar un color especifico
     * en dependencia de alguna propiedad, no tiene que pintar el background de
     * acuerdo al selected.
     *
     * @param paintBackground Booleano para saber si se pinta el background.
     */
    public ComponentCellRender(boolean paintBackground) {
        this.paintBackground = paintBackground;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (!map.containsKey(row)) {
            map.put(row, (T) value);
        } else {
            if (value != null) {
                Component obj = (Component) map.get(row);
                if (obj != (Component) value) {
                    map.put(row, (T) value);
                }
            }
        }
        Component panel = this.get(row);
        if (this.paintBackground) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        }
        return panel;
    }

    public Component get(int row) {
        return (Component) map.get(row);
    }
}
