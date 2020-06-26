package com.jhw.swing.material.components.table;

import com.jhw.swing.material.components.button._MaterialButtonDouble;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.material.components.textfield.validated._MaterialTextFieldIntegerPositive;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import com.jhw.utils.interfaces.Update;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTableByPage extends _PanelTransparent implements Update {

    public static final int SPINNER_DEFAULT = 50;
    private List<Object[]> rows = new ArrayList<>();

    public _MaterialTableByPage() {
        initComponents();
        addListeners();
        setPageVisibility(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table = new com.jhw.swing.material.components.table._MaterialTable();
        panelPages = new com.jhw.swing.material.components.container.panel._PanelTransparent();
        textFieldPage = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldIntegerPositive();
        labelTotPag = new com.jhw.swing.material.components.labels._MaterialLabel();
        buttonDouble = new com.jhw.swing.material.components.button._MaterialButtonDouble();
        spinner = new javax.swing.JSpinner();
        labelFilas = new com.jhw.swing.material.components.labels._MaterialLabel();
        labelSeparator = new com.jhw.swing.material.components.labels._MaterialLabel();

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
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.button._MaterialButtonDouble buttonDouble;
    private com.jhw.swing.material.components.labels._MaterialLabel labelFilas;
    private com.jhw.swing.material.components.labels._MaterialLabel labelSeparator;
    private com.jhw.swing.material.components.labels._MaterialLabel labelTotPag;
    private com.jhw.swing.material.components.container.panel._PanelTransparent panelPages;
    private javax.swing.JSpinner spinner;
    private com.jhw.swing.material.components.table._MaterialTable table;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldIntegerPositive textFieldPage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        labelTotPag.setText("de " + getMaxPages());
        fillTable();
    }

    private void fillTable() {
        getTable().getModel().setRowCount(0);//clear pero sin borrar el arreglo
        int page = textFieldPage.getInteger();
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

    public void addRow(Object[] row) {
        rows.add(row);
        getTable().addRow(row);
    }

    public void removeRow(int row) {
        int page = textFieldPage.getInteger() - 1;
        int maxPerPage = (int) spinner.getValue();
        int real = page * maxPerPage + row;
        rows.remove(real);
        getTable().removeRow(row);
    }

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
            textFieldPage.setInteger(actualPage);
            update();
        } catch (Exception e) {
        }
    }

    private void onButtonNextActionPerformed() {
        int actualPage = Integer.parseInt(textFieldPage.getText());
        int nextPage = Math.min(getMaxPages(), actualPage + 1);
        textFieldPage.setInteger(nextPage);
        update();
    }

    private void onButtonPrevActionPerformed() {
        int actualPage = Integer.parseInt(textFieldPage.getText());
        int prevPage = Math.max(1, actualPage - 1);
        textFieldPage.setInteger(prevPage);
        update();
    }

    private int getMaxPages() {
        return (int) Math.ceil((double) ((1.0d * rows.size()) / (1.0d * ((int) spinner.getValue()))));
    }

    public void clear() {
        rows = new ArrayList<>();
        table.clear();
    }

    public void setData(List<Object[]> rows) {
        this.rows = rows;
        update();
    }

    public JSpinner getSpinner() {
        return spinner;
    }

    public int getRowCount() {
        return table.getRowCount();
    }

    public _MaterialButtonDouble getButtonDouble() {
        return buttonDouble;
    }

    public _MaterialLabel getLabelFilas() {
        return labelFilas;
    }

    public _MaterialLabel getLabelSeparator() {
        return labelSeparator;
    }

    public _MaterialLabel getLabelTotPag() {
        return labelTotPag;
    }

    public _PanelTransparent getPanelPages() {
        return panelPages;
    }

    public _MaterialTable getTable() {
        return table;
    }

    public _MaterialTextFieldIntegerPositive getTextFieldPage() {
        return textFieldPage;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) table.getModel();
    }

    public void setModel(TableModel dataModel) {
        table.setModel(dataModel);
    }

    public TableColumnModel getColumnModel() {
        return table.getColumnModel();
    }

    public TableColumn getColumn(Object identifier) {
        return table.getColumn(identifier);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Object getValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }

    public int getRowHeight() {
        return table.getRowHeight();
    }

    public _MaterialScrollPaneCore getScrollPane() {
        return table.getScrollPane();
    }

    public JTable getJTable() {
        return table.getTable();
    }
}
