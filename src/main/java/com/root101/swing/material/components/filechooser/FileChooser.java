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

import com.root101.swing.util.interfaces.BindableComponent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
        this.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
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
