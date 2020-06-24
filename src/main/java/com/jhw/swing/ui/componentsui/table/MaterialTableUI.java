package com.jhw.swing.ui.componentsui.table;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;
import com.jhw.swing.util.Utils;

public class MaterialTableUI extends BasicTableUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTableUI();
    }

    /*
     DefaultComboBoxModel comboModel = new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3"});
     JComboBox combo = new JComboBox();
     combo.setUI(new MaterialComboBoxUI());
     combo.setModel(comboModel);
     TableColumn col = jTable1.getColumnModel().getColumn(2);
     col.setCellEditor(new DefaultCellEditor(combo));
     */
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JTable tab = (JTable) c;
        tab.setShowHorizontalLines(true);
        tab.setShowVerticalLines(false);

        //tab.setOpaque(false);
        //tab.setBorder(UIManager.getBorder("Table.border"));
        tab.setSelectionForeground(UIManager.getColor("Table.selectionForeground"));
        tab.setBackground(UIManager.getColor("Table.background"));
        tab.setFont(UIManager.getFont("Table.font"));
        tab.setGridColor(UIManager.getColor("Table.gridColor"));
        tab.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));

        tab.getTableHeader().setResizingAllowed(true);
        int rowHeight = UIManager.getInt("Table.rowHeight");
        if (rowHeight > 0) {
            tab.setRowHeight(rowHeight);
        } else {
            int fontH = Utils.fontMetrics(tab.getFont()).getAscent();
            tab.setRowHeight((int) (fontH * 2));
        }
        tab.setDefaultRenderer(Object.class, new MaterialTableCellRenderer());
        tab.setDefaultEditor(Object.class, new MaterialTableCellEditor());
        tab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
