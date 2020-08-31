package com.jhw.swing.material.components.filechooser;

import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FileChooser extends JFileChooser implements BindableComponent<File[]> {

    public FileChooser() {
        super(new File(""));
        configure();
    }

    public FileChooser(File currentDirectory) {
        super(currentDirectory);
        configure();
    }

    public FileChooser(String currentDirectoryPath) {
        super(currentDirectoryPath);
        configure();
    }

    public void addConfirmListener(ActionListener action) {
        int returnVal = this.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            action.actionPerformed(null);
        }
    }

    private void configure() {
        //this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.setMultiSelectionEnabled(true);
    }

    @Override
    public File[] getObject() {
        return getSelectedFiles();
    }

    @Override
    public void setObject(File[] object) {
        setSelectedFiles(object);
    }
}
