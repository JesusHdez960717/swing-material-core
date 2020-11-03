package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.injection.MaterialSwingInjector;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Hay que usar _Month xq el java.time.Month tiene los meses como enum en
 * ingles, x lo que hay que usar un wrapper y sobreescribir el toString
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MonthPicker extends MaterialMonthPicker {

    public static _MonthPicker from() {
        return MaterialSwingInjector.getImplementation(_MonthPicker.class);
    }

    public _MonthPicker() {
        setMonths();
        setLabel("Mes");
    }

    private void setMonths() {
        List<_Month> model = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            model.add(_Month.from(i));
        }
        setModel(model);
        this.setSelectedItem(_Month.from(Month.from(YearMonth.now()).getValue()));
    }

}
