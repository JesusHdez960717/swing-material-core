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

import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.Icon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialFileChooser extends MaterialFileChooser {

    public static MaterialFileChooser from() {
        return new _MaterialFileChooser();
    }

    private FileChooser fc;
    private static File lastFile = new File("");

    private final Consumer<List<File>> consumer = new Consumer<List<File>>() {
        @Override
        public void accept(List<File> t) {
            mergeFiles(t);
        }
    };

    private final List<File> selectedFiles = new ArrayList<>();

    private String upload = "Upload";

    public _MaterialFileChooser() {
        initComponents();
        addListeners();
        this.setTransferHandler(new FileDropHandler(consumer));
    }

    private void initComponents() {
        button = MaterialButtonsFactory.buildButton();

        button.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
        button.setBorderColor(MaterialColors.BROWN_700);
        button.setBorderThickness(2);
        button.setIcon(MaterialIcons.FILE_UPLOAD);
        button.setText(upload);

        this.add(button);
    }

    private MaterialButton button;

    @Override
    public MaterialFileChooser getFileChooser() {
        return this;
    }

    private void addListeners() {
        button.addActionListener((java.awt.event.ActionEvent evt) -> {
            onButtonAbrirActionPerformed();
        });
    }

    private void onButtonAbrirActionPerformed() {
        fc = new FileChooser(lastFile);
        fc.addConfirmListener((java.awt.event.ActionEvent evt) -> {
            mergeFiles(Arrays.asList(fc.getSelectedFiles()));
        });
    }

    @Override
    public void setText(String text) {
        button.setText(text);
        this.upload = text;
    }

    @Override
    public String getText() {
        return upload;
    }

    @Override
    public void setIcon(Icon icon) {
        button.setIcon(icon);
    }

    @Override
    public Icon getIcon() {
        return button.getIcon();
    }

    @Override
    public void clear() {
        selectedFiles.clear();
        setText(upload);
        if (fc != null) {
            fc.setSelectedFiles(null);
        }
    }

    @Override
    public void setSelectedFiles(List<File> files) {
        clear();
        selectedFiles.addAll(files);
    }

    @Override
    public List<File> getSelectedFiles() {
        return selectedFiles;
    }

    private void mergeFiles(List<File> newSelection) {
        for (File file : newSelection) {
            if (!selectedFiles.contains(file)) {
                selectedFiles.add(file);
            }
        }
        if (!getSelectedFiles().isEmpty()) {
            lastFile = getSelectedFiles().get(0).getParentFile();
            button.setText(upload + " (" + getSelectedFiles().size() + ")");
        }
    }

    @Override
    public List<File> getObject() {
        return getSelectedFiles();
    }

    @Override
    public void setObject(List<File> object) {
        setSelectedFiles(object);
    }

}
