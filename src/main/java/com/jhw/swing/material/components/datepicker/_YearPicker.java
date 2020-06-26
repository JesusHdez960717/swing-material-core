package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.util.interfaces.DateSelected;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _YearPicker extends _PanelTransparent implements DateSelected {

    private int minYear = 1900;
    private int maxYear = 3000;

    public _YearPicker() {
        initComponents();
        setYear();
        setActualDate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxYear = new javax.swing.JComboBox();

        comboBoxYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxYear, javax.swing.GroupLayout.Alignment.TRAILING, 0, 120, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxYear, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxYear;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(java.awt.event.ActionListener listener) {
        comboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listener.actionPerformed(evt);
            }
        });
    }

    private void setYear() {
        comboBoxYear.removeAllItems();
        for (int i = minYear; i <= maxYear; i++) {
            comboBoxYear.addItem(i);
        }
    }

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public JComboBox getComboBoxYear() {
        return comboBoxYear;
    }

    public void setComboBoxYear(JComboBox comboBoxYear) {
        this.comboBoxYear = comboBoxYear;
    }

    private void setActualDate() {
        Date hoy = new Date();
        comboBoxYear.setSelectedIndex(hoy.getYear());
    }

    public int getSelectedYear() {
        return (int) comboBoxYear.getSelectedItem();
    }

    /**
     * Faltan por hacer las validaciones.
     *
     * @return
     */
    @Override
    public Date getDateValidated() {
        return new Date(getSelectedYear() - 1900, 0, 1);
    }

    @Override
    public Date getDate() {
        return new Date(getSelectedYear() - 1900, 0, 1);
    }

    @Override
    public void setDate(Date date) {
        comboBoxYear.setSelectedItem(date.getYear() + 1900);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.comboBoxYear.setEnabled(enabled);
        super.setEnabled(enabled);
    }
}
