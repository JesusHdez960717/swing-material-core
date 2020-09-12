package com.jhw.swing.material.components.table;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.components.scrollpane.MaterialScrollPane;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTable extends _PanelTransparent {

    public _MaterialTable() {
        initComponents();
        addListeners();
    }

    private void initComponents() {

        scrollPane = MaterialScrollFactory.buildPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPane.setViewportView(table);

        this.setLayout(new BorderLayout());
        this.add(scrollPane);
        this.setPreferredSize(new Dimension(150, 200));

    }

    // Variables declaration - do not modify
    private MaterialScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration                   

    public MaterialScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(_MaterialScrollPaneCore scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) table.getModel();
    }

    public void setModel(TableModel dataModel) {
        table.setModel(dataModel);
    }

    public TableColumn getColumn(Object identifier) {
        return table.getColumn(identifier);
    }

    public TableColumnModel getColumnModel() {
        return table.getColumnModel();
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Object getValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }

    public void clear() {
        getModel().setRowCount(0);
    }

    public void addRow(Object[] row) {
        getModel().addRow(row);
    }

    public void removeRow(int row) {
        getModel().removeRow(row);
    }

    public int getRowHeight() {
        return table.getRowHeight();
    }

    public int getRowCount() {
        return table.getRowCount();
    }

    private void addListeners() {
        table.addMouseListener(new MouseAdapter() {
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
