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
package com.root101.swing.material.components.passwordfield;

import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.util.PersonalizationMaterial;
import com.root101.swing.derivable_icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Icon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialPasswordFieldIcon extends MaterialPasswordFieldIcon {

    public static MaterialPasswordFieldIcon from() {
        return new _MaterialPasswordFieldIcon();
    }

    public static float ICON_SIZE_REDUCTION = .4f;
    public static float ICON_WIDTH_REDUCTION = .55f;

    private Color originalIconColor = MaterialColors.BLACK;

    public _MaterialPasswordFieldIcon() {
        initComponents();
        setIcon(MaterialIcons.SECURITY);
    }

    private void initComponents() {
        this.setBorder(null);
        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        passwordField = MaterialPasswordFieldFactory.build();
        this.setLayout(new BorderLayout());
        this.add(passwordField, BorderLayout.CENTER);

        passwordField.addFocusListener(new FocusListener() {
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

    private MaterialPasswordField passwordField;
    private MaterialButtonIcon buttonIcon;

    @Override
    public void setIcon(Icon icon) {
        if (icon == null) {
            this.remove(buttonIcon);
            return;
        }
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.passwordField.getPreferredSize().getHeight();
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
    public MaterialPasswordField getPasswordField() {
        return passwordField;
    }

    @Override
    public Icon getIcon() {
        return buttonIcon.getIcon();
    }

    @Override
    public void paintLine(Graphics g2) {
        passwordField.paintLine(g2);
    }

    @Override
    public int getYLine(Graphics g2) {
        return passwordField.getYLine(g2);
    }

    @Override
    public void paintLabel(Graphics g) {
        passwordField.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        passwordField.paintHint(g);
    }

    @Override
    public void setEnabled(boolean enabled) {
        passwordField.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public int getMaxLength() {
        return passwordField.getMaxLength();
    }

    @Override
    public void setMaxLength(int maxLength) {
        passwordField.setMaxLength(maxLength);
    }

    @Override
    public String getLabel() {
        return passwordField.getLabel();
    }

    @Override
    public void setLabel(String label) {
        passwordField.setLabel(label);
    }

    @Override
    public String getHint() {
        return passwordField.getHint();
    }

    @Override
    public void setHint(String hint) {
        passwordField.setHint(hint);
    }

    @Override
    public Color getAccentFloatingLabel() {
        return passwordField.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        passwordField.setAccentFloatingLabel(accentColor);
    }

    @Override
    public String getExtra() {
        return passwordField.getExtra();
    }

    @Override
    public void setExtra(String extra) {
        passwordField.setExtra(extra);
    }

    @Override
    public void wrong() {
        passwordField.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        passwordField.wrong(wrongText);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        passwordField.paintWrong(g2, y);
    }

    @Override
    public Color getWrongColor() {
        return passwordField.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        passwordField.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        passwordField.clearWrong();
    }

    @Override
    public String getObject() {
        return passwordField.getObject();
    }

    @Override
    public void setObject(String object) {
        passwordField.setObject(object);
    }

}
