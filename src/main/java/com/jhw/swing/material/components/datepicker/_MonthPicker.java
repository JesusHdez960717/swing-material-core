package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.combobox._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelComponent;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.DateSelected;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MonthPicker extends _PanelComponent implements BindableComponent<Date>, DateSelected {

    private final SimpleDateFormat SDF_MONTH = new SimpleDateFormat("MMMM");
    private final List<MES> months = new ArrayList<>(12);

    public _MonthPicker() {
        initComponents();
        createMonths();
        setMonths();
        setActualDate();
        setLabelMonth("Mes");
    }

    private void initComponents() {
        comboBoxMonths = new _MaterialComboBoxFiltrable<>();
        comboBoxYear = new _YearPicker();

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder();
        hlc.add(HorizontalLayoutComponent.builder(comboBoxMonths).gapRight(2).build());
        hlc.add(HorizontalLayoutComponent.builder(comboBoxYear).gapLeft(2).build());

        this.setComponent(hlc.build());
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private _MaterialComboBoxFiltrable<MES> comboBoxMonths;
    private _YearPicker comboBoxYear;
    // End of variables declaration                   

    public void addActionListener(java.awt.event.ActionListener listener) {
        comboBoxMonths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listener.actionPerformed(evt);
            }
        });
        comboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listener.actionPerformed(evt);
            }
        });
    }

    private void createMonths() {
        for (int i = 0; i < 12; i++) {
            months.add(new MES(getMonthString(i), i));//solo importa el mes
        }
    }

    private String getMonthString(int id) {
        return SDF_MONTH.format(new Date(2000, id, 15));
    }

    private void setMonths() {
        comboBoxMonths.setModel(months);
    }

    public JComboBox getComboBoxMonths() {
        return comboBoxMonths;
    }

    public JComboBox getComboBoxYear() {
        return comboBoxYear;
    }

    private void setActualDate() {
        Date hoy = new Date();
        comboBoxMonths.setSelectedItem(new MES(getMonthString(hoy.getMonth()), hoy.getMonth()));
    }

    public int getSelectedYear() {
        return (int) comboBoxYear.getSelectedItem();
    }

    public int getSelectedMonth() {
        return ((MES) comboBoxMonths.getSelectedItem()).id;
    }

    public String getSelectedMonthString() {
        return ((MES) comboBoxMonths.getSelectedItem()).mes;
    }

    public void setLabelMonth(String label) {
        comboBoxMonths.setLabel(label);
    }

    public void setLabelYear(String label) {
        comboBoxYear.setLabel(label);
    }

    @Override
    public Date getDate() {
        return new Date(getSelectedYear() - 1900, getSelectedMonth(), 1);
    }

    @Override
    public void setDate(Date date) {
        comboBoxMonths.setSelectedItem(new MES(getMonthString(date.getMonth()), date.getMonth()));
        comboBoxYear.setSelectedItem(date.getYear() + 1900);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.comboBoxMonths.setEnabled(enabled);
        this.comboBoxYear.setEnabled(enabled);
        super.setEnabled(enabled);
    }

    @Override
    public Date getObject() {
        return getDate();
    }

    @Override
    public void setObject(Date object) {
        setDate(object);
    }

    private class MES {

        String mes;
        int id;

        public MES(String mes, int id) {
            this.mes = mes;
            this.id = id;
        }

        @Override
        public String toString() {
            return mes;
        }
    }
}
