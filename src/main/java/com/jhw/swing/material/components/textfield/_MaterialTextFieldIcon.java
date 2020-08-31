/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standards.MaterialColors;
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
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldIcon<T> extends _PanelTransparent implements BindableComponent<T>, Wrong, MaterialComponent {

    public static float ICON_SIZE_REDUCTION = .4f;
    public static float ICON_WIDTH_REDUCTION = .55f;

    private Color originalIconColor = MaterialColors.BLACK;

    public _MaterialTextFieldIcon() {
        this(String.class);
    }

    public _MaterialTextFieldIcon(Class clazz) {
        textField = new _MaterialTextField<>(clazz);
        initComponents();
    }

    public _MaterialTextFieldIcon(_MaterialTextField textField) {
        this.textField = textField;
        initComponents();
    }

    private void initComponents() {
        buttonIcon = new _MaterialButtonIconTransparent();

        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.CENTER);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                buttonIcon.setForeground(textField.getAccent());
            }

            @Override
            public void focusLost(FocusEvent e) {
                buttonIcon.setForeground(originalIconColor);
            }
        });
    }

    private _MaterialTextField<T> textField;
    private _MaterialButtonIconTransparent buttonIcon;

    public void setIcon(ImageIcon icon) {
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.textField.getPreferredSize().getHeight();
        if (icon instanceof DerivableIcon) {
            buttonIcon.setIcon(((DerivableIcon) icon).deriveIcon(h * ICON_SIZE_REDUCTION));
            originalIconColor = ((DerivableIcon) icon).getColor();
        } else {
            buttonIcon.setIcon(icon);
        }
        int w = (int) (h * ICON_WIDTH_REDUCTION);
        buttonIcon.setPreferredSize(new Dimension(w, h));
        this.add(buttonIcon, BorderLayout.WEST);
    }

    protected void setTextFiedl(_MaterialTextField<T> textField) {
        this.textField = textField;
    }

    //DELEGATE
    public String getText() {
        return textField.getText();
    }

    public Color getWrongColor() {
        return textField.getWrongColor();
    }

    public void setWrongColor(Color wrongColor) {
        textField.setWrongColor(wrongColor);
    }

    public String getWrongText() {
        return textField.getWrongText();
    }

    public void setWrongText(String wrongText) {
        textField.setWrongText(wrongText);
    }

    public int getMaxLength() {
        return textField.getMaxLength();
    }

    public void setMaxLength(int maxLength) {
        textField.setMaxLength(maxLength);
    }

    public String getLabel() {
        return textField.getLabel();
    }

    public void setLabel(String label) {
        textField.setLabel(label);
    }

    public String getHint() {
        return textField.getHint();
    }

    public void setHint(String hint) {
        textField.setHint(hint);
    }

    public Color getAccent() {
        return textField.getAccent();
    }

    public void setAccent(Color accentColor) {
        textField.setAccent(accentColor);
    }

    public void setRealForeground(Color fg) {
        textField.setRealForeground(fg);
    }

    public Color getRealForeground() {
        return textField.getRealForeground();
    }

    public String getExtra() {
        return textField.getExtra();
    }

    public void setExtra(String extra) {
        textField.setExtra(extra);
    }

    public void setText(String s) {
        textField.setText(s);
    }

    @Override
    public void wrong() {
        textField.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        textField.wrong(wrongText);
    }

    @Override
    public T getObject() {
        return textField.getObject();
    }

    @Override
    public void setObject(T object) {
        textField.setObject(object);
    }

}
