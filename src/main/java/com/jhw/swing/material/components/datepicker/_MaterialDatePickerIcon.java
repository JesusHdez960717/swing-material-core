/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialDatePickerIcon extends _PanelTransparent implements BindableComponent<Date>, Wrong, MaterialComponent {

    private Color originalIconColor = MaterialColors.BLACK;

    public _MaterialDatePickerIcon() {
        this("Fecha");
    }

    public _MaterialDatePickerIcon(String label) {
        initComponents();
        this.setLabel(label);
        this.setIcon(MaterialIcons.DATE_RANGE);
    }

    private void initComponents() {
        datePicker = new _MaterialDatePicker();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setLayout(new BorderLayout());
        this.add(datePicker, BorderLayout.CENTER);

        datePicker.getFormatedTextField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                buttonIcon.setForeground(getAccentFloatingLabel());
            }

            @Override
            public void focusLost(FocusEvent e) {
                buttonIcon.setForeground(originalIconColor);
            }
        });
    }

    private _MaterialDatePicker datePicker;
    private MaterialButtonIcon buttonIcon;

    public void setIcon(ImageIcon icon) {
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.datePicker.getFormatedTextField().getPreferredSize().getHeight();
        if (icon instanceof DerivableIcon) {
            buttonIcon.setIcon(((DerivableIcon) icon).deriveIcon(h * _MaterialTextFieldIcon.ICON_SIZE_REDUCTION));
            originalIconColor = ((DerivableIcon) icon).getColor();
        } else {
            buttonIcon.setIcon(icon);
        }
        int w = (int) (h * _MaterialTextFieldIcon.ICON_WIDTH_REDUCTION);
        buttonIcon.setPreferredSize(new Dimension(w, h));
        this.add(buttonIcon, BorderLayout.WEST);
    }

    @Override
    public void setEnabled(boolean enabled) {
        datePicker.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    public _MaterialFormatedTextField getFormatedTextField() {
        return datePicker.getFormatedTextField();
    }

    public void setLowerBound(Date lower) {
        datePicker.setLowerBound(lower);
    }

    public void setUpperBound(Date lower) {
        datePicker.setUpperBound(lower);
    }

    public void setDate(Date date) {
        datePicker.setDate(date);
    }

    public Date getDate() {
        return datePicker.getDate();
    }

    public int getMaxLength() {
        return datePicker.getMaxLength();
    }

    public String getLabel() {
        return datePicker.getLabel();
    }

    public void setLabel(String label) {
        datePicker.setLabel(label);
    }

    public String getHint() {
        return datePicker.getHint();
    }

    public void setHint(String hint) {
        datePicker.setHint(hint);
    }

    public Color getAccentFloatingLabel() {
        return datePicker.getAccentFloatingLabel();
    }

    public void setAccentFloatingLabel(Color accentColor) {
        datePicker.setAccentFloatingLabel(accentColor);
    }

    public String getExtra() {
        return datePicker.getExtra();
    }

    public void setExtra(String extra) {
        datePicker.setExtra(extra);
    }

    public void setMaxLength(int maxLength) {
        datePicker.setMaxLength(maxLength);
    }

    public void setText(String s) {
        datePicker.setText(s);
    }

    @Override
    public void wrong() {
        datePicker.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        datePicker.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return datePicker.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        datePicker.setWrongColor(wrongColor);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        datePicker.paintWrong(g2, y);
    }

    @Override
    public void clearWrong() {
        datePicker.clearWrong();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (datePicker != null) {
            datePicker.setForeground(fg);
        }
    }

    @Override
    public Date getObject() {
        return datePicker.getObject();
    }

    @Override
    public void setObject(Date object) {
        datePicker.setObject(object);
    }

}
