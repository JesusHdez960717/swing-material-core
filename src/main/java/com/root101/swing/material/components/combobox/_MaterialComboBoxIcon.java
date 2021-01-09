/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.combobox;

import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.PersonalizationMaterial;
import com.root101.swing.derivable_icons.DerivableIcon;
import com.root101.swing.material.components.textfield._MaterialTextFieldIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialComboBoxIcon<T> extends MaterialComboBoxIcon<T> {

    public static _MaterialComboBoxIcon from() {
        return new _MaterialComboBoxIcon();
    }

    public static _MaterialComboBoxIcon from(MaterialComboBox comboBox) {
        return new _MaterialComboBoxIcon(comboBox);
    }

    private Color originalIconColor = MaterialColors.BLACK;

    public _MaterialComboBoxIcon() {
        this(MaterialComboBoxFactory.build());
    }

    public _MaterialComboBoxIcon(MaterialComboBox comboBox) {
        this.comboBox = comboBox;
        initComponents();
        //this.setIcon(MaterialIcons.COMPARE_ARROWS);

        getComboBox().addFocusListener(new FocusListener() {
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

    private void initComponents() {
        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(comboBox, BorderLayout.CENTER);
    }

    private MaterialComboBox<T> comboBox;
    private MaterialButtonIcon buttonIcon;

    @Override
    public MaterialComboBox<T> getComboBox() {
        return comboBox;
    }

    @Override
    public void setModel(ComboBoxModel<T> aModel) {
        comboBox.setModel(aModel);
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon == null) {
            this.remove(buttonIcon);
            return;
        }
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.comboBox.getPreferredSize().getHeight();
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
    public Icon getIcon() {
        return buttonIcon.getIcon();
    }

    @Override
    public void setEnabled(boolean enabled) {
        comboBox.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public String getLabel() {
        return comboBox.getLabel();
    }

    @Override
    public void setLabel(String label) {
        comboBox.setLabel(label);
    }

    @Override
    public String getHint() {
        return comboBox.getHint();
    }

    @Override
    public void setHint(String hint) {
        comboBox.setHint(hint);
    }

    @Override
    public Color getAccentFloatingLabel() {
        return comboBox.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        comboBox.setAccentFloatingLabel(accentColor);
    }

    @Override
    public void paintLabel(Graphics g) {
        comboBox.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        comboBox.paintHint(g);
    }

    @Override
    public void paintLine(Graphics g) {
        comboBox.paintLine(g);
    }

    @Override
    public int getYLine(Graphics g2) {
        return comboBox.getYLine(g2);
    }

    @Override
    public void wrong() {
        comboBox.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        comboBox.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return comboBox.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        comboBox.setWrongColor(wrongColor);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        comboBox.paintWrong(g2, y);
    }

    @Override
    public void clearWrong() {
        comboBox.clearWrong();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (comboBox != null) {
            comboBox.setForeground(fg);
        }
    }

    @Override
    public T getObject() {
        return getComboBox().getObject();
    }

    @Override
    public void setObject(T object) {
        getComboBox().setObject(object);
    }

    @Override
    public void addElement(T element) {
        getComboBox().addElement(element);
    }

}
