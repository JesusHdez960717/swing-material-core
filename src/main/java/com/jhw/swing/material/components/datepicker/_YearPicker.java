package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.util.interfaces.DateSelected;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _YearPicker extends _MaterialComboBoxFiltrable<Integer> implements DateSelected {

    private int minYear = 1800;
    private int maxYear = 2200;

    public _YearPicker() {
        setYears();
        setActualDate();
        setLabel("Año");
    }

    private void setYears() {
        List<Integer> model = new ArrayList<>(maxYear - minYear);
        for (int i = minYear; i <= maxYear; i++) {
            model.add(i);
        }
        setModel(model);
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

    private void setActualDate() {
        Date hoy = new Date();
        this.setSelectedItem(hoy.getYear() + 1900);
    }

    public int getSelectedYear() {
        return (int) getSelectedItem();
    }

    @Override
    public Date getDate() {
        return new Date(getSelectedYear() - 1900, 0, 1);
    }

    @Override
    public void setDate(Date date) {
        setSelectedItem(date.getYear() + 1900);
    }

}
