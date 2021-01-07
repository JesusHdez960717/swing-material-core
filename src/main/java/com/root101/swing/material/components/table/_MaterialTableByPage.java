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

import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.components.textfield.MaterialTextFactory;
import com.root101.swing.material.components.textfield.MaterialTextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialTableByPage extends MaterialTableByPage {

    public static _MaterialTableByPage from() {
        return new _MaterialTableByPage();
    }

    public static final int SPINNER_DEFAULT = 50;
    private List<Object[]> rows = new ArrayList<>();

    public _MaterialTableByPage() {
        initComponents();
        addListeners();
        setPageVisibility(false);
        this.setBorder(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        table = MaterialTableFactory.build();
        panelPages = MaterialContainersFactory.buildPanelTransparent();
        textFieldPage = MaterialTextFactory.build(Integer.class);
        labelTotPag = MaterialLabelsFactory.build();
        buttonDouble = MaterialButtonsFactory.buildDouble();
        spinner = new javax.swing.JSpinner();
        labelFilas = MaterialLabelsFactory.build();
        labelSeparator = MaterialLabelsFactory.build();

        textFieldPage.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        textFieldPage.setText("1");
        textFieldPage.setFont(new java.awt.Font("Roboto Regular", 0, 14)); // NOI18N
        textFieldPage.setHint("");
        textFieldPage.setLabel("");

        labelTotPag.setText("de 1000");

        spinner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinner.setModel(new javax.swing.SpinnerNumberModel(50, 10, 300, 5));

        labelFilas.setText("Filas por pagina:");

        labelSeparator.setBackground(new java.awt.Color(255, 255, 255));
        labelSeparator.setForeground(new java.awt.Color(153, 153, 153));
        labelSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeparator.setText("I");
        labelSeparator.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N

        javax.swing.GroupLayout panelPagesLayout = new javax.swing.GroupLayout(panelPages);
        panelPages.setLayout(panelPagesLayout);
        panelPagesLayout.setHorizontalGroup(
                panelPagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPagesLayout.createSequentialGroup()
                                .addComponent(buttonDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(textFieldPage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(labelTotPag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(labelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(labelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPagesLayout.setVerticalGroup(
                panelPagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPagesLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelPagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelFilas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelTotPag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelPagesLayout.createSequentialGroup()
                                                .addGroup(panelPagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(buttonDouble, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(textFieldPage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(labelSeparator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addComponent(panelPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private com.root101.swing.material.components.button._MaterialButtonDouble buttonDouble;
    private MaterialLabel labelFilas;
    private MaterialLabel labelSeparator;
    private MaterialLabel labelTotPag;
    private JPanel panelPages;
    private javax.swing.JSpinner spinner;
    private MaterialTable table;
    private MaterialTextField<Integer> textFieldPage;
    // End of variables declaration                   

    private void fillTable() {
        setRowCount(0);//clear pero sin borrar el arreglo
        int page = textFieldPage.getObject();
        int maxPerPage = (int) spinner.getValue();

        int elem = rows.size();

        int desde = (page - 1) * maxPerPage;
        desde = Math.min(desde, elem);

        int hasta = desde + maxPerPage;
        hasta = Math.min(hasta, elem);

        for (int i = desde; i < hasta; i++) {
            this.table.addRow(rows.get(i));
        }
    }

    @Override
    public void update() {
        labelTotPag.setText("de " + getMaxPages());
        fillTable();
    }

    @Override
    public JTable getTable() {
        return table.getTable();
    }

    @Override
    public void addRow(Object[] row) {
        rows.add(row);
        table.addRow(row);
    }

    @Override
    public void removeRow(int row) {
        int page = textFieldPage.getObject() - 1;
        int maxPerPage = (int) spinner.getValue();
        int real = page * maxPerPage + row;
        rows.remove(real);
        table.removeRow(row);
    }

    @Override
    public void setPageVisibility(boolean visible) {
        spinner.setValue(visible ? SPINNER_DEFAULT : Integer.MAX_VALUE);
        panelPages.setVisible(visible);
    }

    private void addListeners() {
        buttonDouble.getButtonLeft().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonPrevActionPerformed();
            }
        });
        buttonDouble.getButtonRight().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonNextActionPerformed();
            }
        });
        textFieldPage.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                onTextFieldPageKeyTyped();
            }
        });
        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                update();
            }
        });
    }

    private void onTextFieldPageKeyTyped() {
        try {
            int actualPage = Integer.parseInt(textFieldPage.getText());
            actualPage = Math.max(1, actualPage);
            actualPage = Math.min(actualPage, getMaxPages());
            textFieldPage.setObject(actualPage);
            update();
        } catch (Exception e) {
        }
    }

    private void onButtonNextActionPerformed() {
        int actualPage = Integer.parseInt(textFieldPage.getText());
        int nextPage = Math.min(getMaxPages(), actualPage + 1);
        textFieldPage.setObject(nextPage);
        update();
    }

    private void onButtonPrevActionPerformed() {
        int actualPage = Integer.parseInt(textFieldPage.getText());
        int prevPage = Math.max(1, actualPage - 1);
        textFieldPage.setObject(prevPage);
        update();
    }

    private int getMaxPages() {
        return (int) Math.ceil((double) ((1.0d * rows.size()) / (1.0d * ((int) spinner.getValue()))));
    }

    @Override
    public void clear() {
        rows.clear();
        table.clear();
    }

    @Override
    public void setData(List<Object[]> rows) {
        this.rows.clear();
        this.rows.addAll(rows);
        update();
    }

}
