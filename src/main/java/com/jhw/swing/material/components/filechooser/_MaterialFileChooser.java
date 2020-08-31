/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.filechooser;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFileChooser extends _MaterialButton implements BindableComponent<List<File>> {

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
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
        this.setBorderColor(MaterialColors.BROWN_700);
        this.setBorderThickness(2);
        this.setIcon(MaterialIcons.FILE_UPLOAD);
        this.setText(upload);
    }

    private void addListeners() {
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAbrirActionPerformed();
            }
        });
    }

    private void onButtonAbrirActionPerformed() {
        fc = new FileChooser(lastFile);
        fc.addConfirmListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeFiles(Arrays.asList(fc.getSelectedFiles()));
            }
        });
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public void clear() {
        selectedFiles.clear();
        setText(upload);
        if (fc != null) {
            fc.setSelectedFiles(null);
        }
    }

    public void setSelectedFiles(List<File> files) {
        clear();
        selectedFiles.addAll(files);
    }

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
            setText(upload + " (" + getSelectedFiles().size() + ")");
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
