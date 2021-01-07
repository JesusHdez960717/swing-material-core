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
package com.root101.swing.material.components.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
