/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;
import java.time.YearMonth;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _YearMonthPicker extends _PanelTransparent implements BindableComponent<YearMonth>, Wrong {

    public static _YearMonthPicker from() {
        return MaterialSwingInjector.getImplementation(_YearMonthPicker.class);
    }

    public _YearMonthPicker() {
        initComponents();
    }

    private void initComponents() {
        month = _MonthPicker.from();
        month.setBorder(new EmptyBorder(0, 0, 0, 5));
        year = _YearPicker.from();

        this.setLayout(new BorderLayout());
        this.add(year, BorderLayout.EAST);
        this.add(month);
    }

    private _MonthPicker month;
    private _YearPicker year;

    @Override
    public YearMonth getObject() {
        return YearMonth.of(year.getObject().getValue(), month.getObject().month);
    }

    @Override
    public void setObject(YearMonth object) {
        month.setObject(_Month.from(object.getMonthValue()));
        year.setObject(Year.from(object));
    }

    @Override
    public void wrong() {
        month.wrong();
        year.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        month.wrong(wrongText);
        year.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return month.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        month.setWrongColor(wrongColor);
        year.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        month.clearWrong();
        year.clearWrong();
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        month.paintWrong(g2, y);
        year.paintWrong(g2, y);
    }

}
