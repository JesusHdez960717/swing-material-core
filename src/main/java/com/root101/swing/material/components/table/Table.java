/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.table;

import com.root101.swing.material.components.scrollpane.MaterialScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface Table {

    public JTable getTable();

    public default DefaultTableModel getModel() {
        return (DefaultTableModel) getTable().getModel();
    }

    public default void setModel(TableModel dataModel) {
        getTable().setModel(dataModel);
    }

    public default TableColumn getColumn(Object identifier) {
        return getTable().getColumn(identifier);
    }

    public default TableColumnModel getColumnModel() {
        return getTable().getColumnModel();
    }

    public default int getSelectedRow() {
        return getTable().getSelectedRow();
    }

    public default Object getValueAt(int row, int column) {
        return getTable().getValueAt(row, column);
    }

    /**
     * Vacia la table, pone el row count en 0 (cero)
     */
    public default void clear() {
        getModel().setRowCount(0);
    }

    public default void setRowCount(int count) {
        getModel().setRowCount(count);
    }

    public default void addRow(Object[] row) {
        getModel().addRow(row);
    }

    public default void removeRow(int row) {
        getModel().removeRow(row);
    }

    public default int getRowHeight() {
        return getTable().getRowHeight();
    }

    public default int getRowCount() {
        return getTable().getRowCount();
    }

}
