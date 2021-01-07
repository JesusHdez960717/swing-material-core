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
package com.root101.swing.material.components.datepicker;

import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.PersonalizationMaterial;
import com.root101.swing.derivable_icons.DerivableIcon;
import com.root101.swing.material.components.textfield._MaterialTextFieldIcon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.YearMonth;
import javax.swing.Icon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _YearMonthPickerIcon extends MaterialYearMonthPickerIcon {

    public static _YearMonthPickerIcon from() {
        return MaterialSwingInjector.getImplementation(_YearMonthPickerIcon.class);
    }
    private final FocusListener fl = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            buttonIcon.setForeground(getYearMonthPicker().getMonthPicker().getAccentFloatingLabel());
        }

        @Override
        public void focusLost(FocusEvent e) {
            buttonIcon.setForeground(originalIconColor);
        }
    };

    private Color originalIconColor = MaterialColors.BLACK;

    public _YearMonthPickerIcon() {
        initComponents();
        this.setIcon(MaterialIcons.DATE_RANGE);

        getYearMonthPicker().getMonthPicker().addFocusListener(fl);
        getYearMonthPicker().getYearPicker().addFocusListener(fl);
    }

    private void initComponents() {
        yearMonthPicker = _YearMonthPicker.from();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(yearMonthPicker, BorderLayout.CENTER);
    }

    private _YearMonthPicker yearMonthPicker;
    private MaterialButtonIcon buttonIcon;

    @Override
    public _YearMonthPicker getYearMonthPicker() {
        return yearMonthPicker;
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

        int h = (int) this.yearMonthPicker.getPreferredSize().getHeight();
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
        yearMonthPicker.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public void wrong() {
        yearMonthPicker.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        yearMonthPicker.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return yearMonthPicker.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        yearMonthPicker.setWrongColor(wrongColor);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        yearMonthPicker.paintWrong(g2, y);
    }

    @Override
    public void clearWrong() {
        yearMonthPicker.clearWrong();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (yearMonthPicker != null) {
            yearMonthPicker.setForeground(fg);
        }
    }

    @Override
    public YearMonth getObject() {
        return yearMonthPicker.getObject();
    }

    @Override
    public void setObject(YearMonth object) {
        yearMonthPicker.setObject(object);
    }
}
