package com.jhw.swing.material.components.table.editors_renders.header;

import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import com.jhw.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class HeaderCellRender extends DefaultTableCellRenderer {

    private final _MaterialLabel label;

    /**
     * Default crea un label con los 3puntitos del more
     */
    public HeaderCellRender() {
        label = new _MaterialLabel();
        label.setIcon(MaterialIcons.MORE_HORIZ);
        label.setText("");
        estandarizarLabel();
    }

    public HeaderCellRender(_MaterialLabel label) {
        this.label = label;
        estandarizarLabel();
    }

    public HeaderCellRender(ImageIcon icon, String text) {
        _MaterialLabel labelAct = new _MaterialLabel();
        labelAct.setIcon(icon);
        labelAct.setText(text);
        labelAct.setHorizontalAlignment(SwingConstants.CENTER);
        this.label = labelAct;
        estandarizarLabel();
    }

    private void estandarizarLabel() {
        label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        label.setFont(UIManager.getFont("TableHeader.font"));
        label.setBackground(UIManager.getColor("TableHeader.background"));

        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return label;// como es uno fijo siempre mantiene el mismo
    }

}
