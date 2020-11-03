package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.combobox.*;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _YearPicker extends _MaterialComboBox<Year> {

    public static _YearPicker from() {
        return MaterialSwingInjector.getImplementation(_YearPicker.class);
    }

    private Year minYear = Year.now().minusYears(10);
    private Year maxYear = Year.now().plusYears(10);

    public _YearPicker() {
        setYears();
        setLabel("Año");
    }

    private void setYears() {
        List<Year> model = new ArrayList<>();
        for (Year i = minYear; i.isBefore(maxYear); i = i.plusYears(1)) {
            model.add(Year.parse(String.valueOf(i)));
        }
        setModel(model);
        this.setSelectedItem(Year.now());
    }

    public Year getMinYear() {
        return minYear;
    }

    public void setMinYear(Year minYear) {
        this.minYear = minYear;
        this.setYears();
        this.setSelectedItem(minYear);
    }

    public Year getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Year maxYear) {
        this.maxYear = maxYear;
        this.setYears();
    }

}
