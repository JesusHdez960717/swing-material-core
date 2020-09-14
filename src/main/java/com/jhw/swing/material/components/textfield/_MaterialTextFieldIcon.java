/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldIcon<T> extends MaterialTextField<T> {

    public static MaterialTextField from() {
        return new _MaterialTextFieldIcon();
    }

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

    protected _MaterialTextFieldIcon(MaterialTextField textField) {
        this.textField = textField;
        initComponents();
    }

    private void initComponents() {
        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.CENTER);
        this.setOpaque(false);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                buttonIcon.setForeground(getAccentFloatingLabel());
            }

            @Override
            public void focusLost(FocusEvent e) {
                buttonIcon.setForeground(originalIconColor);
            }
        });
        setIcon(MaterialIcons.EDIT);
    }

    private MaterialTextField<T> textField;
    private MaterialButtonIcon buttonIcon;

    @Override
    public void setIcon(Icon icon) {
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

    @Override
    public MaterialTextField getTextField() {
        return textField;
    }

    protected void setTextFiedl(_MaterialTextField<T> textField) {
        this.textField = textField;
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public void setEnabled(boolean enabled) {
        textField.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public int getMaxLength() {
        return textField.getMaxLength();
    }

    @Override
    public void setMaxLength(int maxLength) {
        textField.setMaxLength(maxLength);
    }

    @Override
    public String getLabel() {
        return textField.getLabel();
    }

    @Override
    public void setLabel(String label) {
        textField.setLabel(label);
    }

    @Override
    public String getHint() {
        return textField.getHint();
    }

    @Override
    public void setHint(String hint) {
        textField.setHint(hint);
    }

    @Override
    public Color getAccentFloatingLabel() {
        return textField.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        textField.setAccentFloatingLabel(accentColor);
    }

    @Override
    public String getExtra() {
        return textField.getExtra();
    }

    @Override
    public void setExtra(String extra) {
        textField.setExtra(extra);
    }

    @Override
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
    public void paintWrong(Graphics g2, int y) {
        textField.paintWrong(g2, y);
    }

    @Override
    public Color getWrongColor() {
        return textField.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        textField.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        textField.clearWrong();
    }

    @Override
    public T getObject() {
        return textField.getObject();
    }

    @Override
    public void setObject(T object) {
        textField.setObject(object);
    }

    @Override
    public Icon getIcon() {
        return buttonIcon.getIcon();
    }

    @Override
    public void paintLine(Graphics g2) {
        textField.paintLine(g2);
    }

    @Override
    public int getYLine(Graphics g2) {
        return textField.getYLine(g2);
    }

    @Override
    public void paintLabel(Graphics g) {
        textField.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        textField.paintHint(g);
    }

}
