/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.filechooser;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.effects.Iconable;
import com.root101.swing.util.interfaces.BindableComponent;
import java.io.File;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialFileChooser extends _PanelTransparent implements Iconable, BindableComponent<List<File>> {

    public abstract void setSelectedFiles(List<File> files);

    public abstract void clear();

    public abstract List<File> getSelectedFiles();

    public abstract MaterialFileChooser getFileChooser();

    public abstract void setText(String text);

    public abstract String getText();
}
