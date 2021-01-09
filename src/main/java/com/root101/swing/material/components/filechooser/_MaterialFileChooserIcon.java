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
package com.root101.swing.material.components.filechooser;

import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.material.standards.MaterialShadow;
import com.root101.swing.util.PersonalizationMaterial;
import com.root101.swing.derivable_icons.DerivableIcon;
import com.root101.swing.material.components.textfield._MaterialTextFieldIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialFileChooserIcon extends MaterialFileChooser {

    public static MaterialFileChooser from() {
        return new _MaterialFileChooserIcon();
    }

    public _MaterialFileChooserIcon() {
        initComponents();
        this.setIcon(MaterialIcons.FOLDER);
        addListeners();
    }

    private void initComponents() {
        fileChooser = MaterialFileChoosersFactory.build();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        buttonClear = MaterialButtonsFactory.buildIconTransparent();
        buttonClear.setIcon(MaterialIcons.CLEAR);

        buttonClear.setPreferredSize(new Dimension(buttonClear.getIcon().getIconWidth() * 2 - MaterialShadow.OFFSET_RIGHT, (int) buttonClear.getPreferredSize().getHeight()));

        this.setLayout(new BorderLayout());
        this.add(fileChooser);
        this.add(buttonClear, BorderLayout.EAST);
    }

    private MaterialFileChooser fileChooser;
    private MaterialButtonIcon buttonIcon;
    private MaterialButtonIcon buttonClear;

    @Override
    public MaterialFileChooser getFileChooser() {
        return fileChooser;
    }

    @Override
    public void setIcon(Icon icon) {
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }
        int h = (int) this.fileChooser.getPreferredSize().getHeight();
        if (icon instanceof DerivableIcon) {
            buttonIcon.setIcon(((DerivableIcon) icon).deriveIcon(h * _MaterialTextFieldIcon.ICON_SIZE_REDUCTION));
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
    public void setText(String text) {
        fileChooser.setText(text);
    }

    @Override
    public String getText() {
        return fileChooser.getText();
    }

    @Override
    public void setEnabled(boolean enabled) {
        fileChooser.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public void setSelectedFiles(List<File> files) {
        fileChooser.setSelectedFiles(files);
    }

    @Override
    public List<File> getSelectedFiles() {
        return fileChooser.getSelectedFiles();
    }

    @Override
    public List<File> getObject() {
        return fileChooser.getObject();
    }

    @Override
    public void setObject(List<File> object) {
        fileChooser.setObject(object);
    }

    @Override
    public void clear() {
        fileChooser.clear();
    }

    private void addListeners() {
        buttonClear.addActionListener((ActionEvent e) -> {
            clear();
        });
    }

}
