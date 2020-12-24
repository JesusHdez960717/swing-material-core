package com.jhw.swing.material.components.table;

import com.jhw.swing.material.standards.MaterialColors;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTable extends MaterialTable {

    public static MaterialTable from() {
        return new _MaterialTable();
    }

    public _MaterialTable() {
        initComponents();
        addListeners();
        table.setAutoCreateRowSorter(true);
    }

    private void initComponents() {

        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        this.setViewportView(table);

        this.setPreferredSize(new Dimension(150, 200));
    }

    private javax.swing.JTable table;

    @Override
    public JTable getTable() {
        return table;
    }

    private void addListeners() {
        getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleRowClick(e);
            }
        });
    }

    private void handleRowClick(MouseEvent e) {
        int clickedRow = table.rowAtPoint(e.getPoint());
        if (e.getButton() == MouseEvent.BUTTON3) {//esto es solo para el click derecho, sino no lo proceso
            if (clickedRow >= 0 && clickedRow < table.getRowCount()) {
                table.setRowSelectionInterval(clickedRow, clickedRow);
            } else {
                table.clearSelection();
            }
        }
    }
}
