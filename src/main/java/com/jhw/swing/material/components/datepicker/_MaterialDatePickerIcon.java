/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.util.interfaces.Wrong;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
        initComponents();
        this.setIcon(MaterialIcons.DATE_RANGE);
    }

    private void initComponents() {
        datePicker = new _MaterialDatePicker();
        
        buttonIcon = new _MaterialButtonIconTransparent();
        buttonIcon.setRippleColor(MaterialColors.TRANSPARENT);

        this.setLayout(new BorderLayout());
        this.add(datePicker, BorderLayout.CENTER);

        datePicker.getFormatedTextField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                buttonIcon.setForeground(getAccent());
            }

            @Override
            public void focusLost(FocusEvent e) {
                buttonIcon.setForeground(originalIconColor);
            }
        });
    }

    private _MaterialDatePicker datePicker;
    private _MaterialButtonIconTransparent buttonIcon;

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

    public Color getWrongColor() {
        return datePicker.getFormatedTextField().getWrongColor();
    }

    public void setWrongColor(Color wrongColor) {
        datePicker.getFormatedTextField().setWrongColor(wrongColor);
    }

    public String getWrongText() {
        return datePicker.getFormatedTextField().getWrongText();
    }

    public void setWrongText(String wrongText) {
        datePicker.getFormatedTextField().setWrongText(wrongText);
    }

    public int getMaxLength() {
        return datePicker.getFormatedTextField().getMaxLength();
    }

    public void setMaxLength(int maxLength) {
        datePicker.getFormatedTextField().setMaxLength(maxLength);
    }

    public String getLabel() {
        return datePicker.getFormatedTextField().getLabel();
    }

    public void setLabel(String label) {
        datePicker.getFormatedTextField().setLabel(label);
    }

    public String getHint() {
        return datePicker.getFormatedTextField().getHint();
    }

    public void setHint(String hint) {
        datePicker.getFormatedTextField().setHint(hint);
    }

    public Color getAccent() {
        return datePicker.getFormatedTextField().getAccent();
    }

    public void setAccent(Color accentColor) {
        datePicker.getFormatedTextField().setAccent(accentColor);
    }

    public void setRealForeground(Color fg) {
        datePicker.getFormatedTextField().setRealForeground(fg);
    }

    public Color getRealForeground() {
        return datePicker.getFormatedTextField().getRealForeground();
    }

    public String getExtra() {
        return datePicker.getFormatedTextField().getExtra();
    }

    public void setExtra(String extra) {
        datePicker.getFormatedTextField().setExtra(extra);
    }

    public void setLowerBound(Date lower) {
        datePicker.setLowerBound(lower);
    }

    public void setUpperBound(Date lower) {
        datePicker.setUpperBound(lower);
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
    public Date getObject() {
        return datePicker.getObject();
    }

    @Override
    public void setObject(Date object) {
        datePicker.setObject(object);
    }

}
