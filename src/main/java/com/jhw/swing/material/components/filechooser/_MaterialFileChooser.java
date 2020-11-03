/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.filechooser;

import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
