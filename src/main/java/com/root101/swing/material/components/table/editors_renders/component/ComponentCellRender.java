package com.root101.swing.material.components.table.editors_renders.component;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
