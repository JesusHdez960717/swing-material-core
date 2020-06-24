package com.jhw.swing.material.components.filechooser;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFileChooser extends JFileChooser {

    public _MaterialFileChooser() {
        super(new File(""));
        configure();
    }

    public _MaterialFileChooser(File currentDirectory) {
        super(currentDirectory);
        configure();
    }

    public _MaterialFileChooser(String currentDirectoryPath) {
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
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.setMultiSelectionEnabled(true);
    }
}
