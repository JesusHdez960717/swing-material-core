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

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
