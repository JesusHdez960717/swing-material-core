/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.datepicker;

import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;
import java.time.YearMonth;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _YearMonthPicker extends MaterialYearMonthPicker {

    public static _YearMonthPicker from() {
        return MaterialSwingInjector.getImplementation(_YearMonthPicker.class);
    }

    public _YearMonthPicker() {
        initComponents();
    }

    private void initComponents() {
        monthPicker = _MonthPicker.from();
        
        yearPicker = _YearPicker.from();

        this.setLayout(new BorderLayout());
        this.add(yearPicker, BorderLayout.EAST);
        this.add(monthPicker);
    }

    private _MonthPicker monthPicker;
    private _YearPicker yearPicker;

    @Override
    public YearMonth getObject() {
        return YearMonth.of(yearPicker.getObject().getValue(), monthPicker.getObject().month);
    }

    @Override
    public void setObject(YearMonth object) {
        monthPicker.setObject(_Month.from(object.getMonthValue()));
        yearPicker.setObject(Year.from(object));
    }

    @Override
    public void wrong() {
        monthPicker.wrong();
        yearPicker.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        monthPicker.wrong(wrongText);
        yearPicker.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return monthPicker.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        monthPicker.setWrongColor(wrongColor);
        yearPicker.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        monthPicker.clearWrong();
        yearPicker.clearWrong();
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        monthPicker.paintWrong(g2, y);
        yearPicker.paintWrong(g2, y);
    }

    @Override
    public MaterialMonthPicker getMonthPicker() {
        return monthPicker;
    }

    @Override
    public MaterialYearPicker getYearPicker() {
        return yearPicker;
    }

}
