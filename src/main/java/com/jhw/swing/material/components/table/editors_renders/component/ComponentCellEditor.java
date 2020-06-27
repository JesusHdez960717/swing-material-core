package com.jhw.swing.material.components.table.editors_renders.component;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ComponentCellEditor<T> extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 1L;

    private boolean paintBackground = true;

    private final ComponentCellRender render;

    public ComponentCellEditor(ComponentCellRender render) {
        this.render = render;
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
    public ComponentCellEditor(ComponentCellRender render, boolean paintBackground) {
        this.render = render;
        this.paintBackground = paintBackground;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        Component panel = (Component) render.get(row);
        if (this.paintBackground) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        }
        return panel;
    }
}
