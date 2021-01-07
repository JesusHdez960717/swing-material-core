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

import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.TransferHandler;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class FileDropHandler extends TransferHandler {

    private final Consumer<List<File>> consumer;

    public static FileDropHandler from(Consumer<List<File>> consumer) {
        return new FileDropHandler(consumer);
    }

    public FileDropHandler(Consumer<List<File>> consumer) {
        this.consumer = consumer;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        for (DataFlavor flavor : support.getDataFlavors()) {
            if (flavor.isFlavorJavaFileListType()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean importData(TransferSupport support) {
        if (!this.canImport(support)) {
            return false;
        }
        List<File> files = new ArrayList<>();
        try {
            files = (List<File>) support.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
        } catch (Exception e) {
            return false;
        }
        consumer.accept(files);
        return true;
    }

}
