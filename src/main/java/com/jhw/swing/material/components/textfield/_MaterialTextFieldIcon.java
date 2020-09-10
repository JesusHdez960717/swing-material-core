/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.material.standards.MaterialColors;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        ((RippleEffect) buttonIcon).setPaintRipple(false);

        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.CENTER);

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
    }

    private _MaterialTextField<T> textField;
    private JButton buttonIcon;

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

    @Override
    public void setEnabled(boolean enabled) {
        textField.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
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

    public Color getAccentFloatingLabel() {
        return textField.getAccentFloatingLabel();
    }

    public void setAccentFloatingLabel(Color accentColor) {
        textField.setAccentFloatingLabel(accentColor);
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
    public T getObject() {
        return textField.getObject();
    }

    @Override
    public void setObject(T object) {
        textField.setObject(object);
    }

}
