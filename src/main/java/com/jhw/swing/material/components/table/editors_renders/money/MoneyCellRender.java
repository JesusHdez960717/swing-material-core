package com.jhw.swing.material.components.table.editors_renders.money;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MoneyCellRender extends DefaultTableCellRenderer implements TableCellRenderer {

    private final HashMap<Integer, MoneyTableComponent> map = new HashMap<>();

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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
        _PanelGradient panel = map.get(row).getRenderComponent();
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}
