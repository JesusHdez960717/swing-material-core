package com.jhw.swing.material.components.table.editors_renders.money;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Deprecated
public class MoneyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JComponent item;
    private final HashMap<Integer, MoneyTableComponent> map = new HashMap<>();

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        if (!map.containsKey(row)) {
            map.put(row, (MoneyTableComponent) value);
        } else {
            if (value != null) {
                MoneyTableComponent obj = (MoneyTableComponent) map.get(row);
                if (obj != (MoneyTableComponent) value) {
                    map.put(row, (MoneyTableComponent) value);
                }
            }
        }
        JTextField textField = map.get(row).getEditorComponent();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        return textField;
    }
}
