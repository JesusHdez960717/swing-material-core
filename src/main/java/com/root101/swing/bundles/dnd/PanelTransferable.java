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
package com.root101.swing.bundles.dnd;

import java.awt.datatransfer.*;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @author MadProgrammer@Stackoverflow
 */
public class PanelTransferable implements Transferable {

    private DataFlavor[] flavors = new DataFlavor[]{PanelDataFlavor.SHARED_INSTANCE};
    private JPanel panel;

    public PanelTransferable(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        // Okay, for this example, this is overkill, but makes it easier
        // to add new flavor support by subclassing
        boolean supported = false;

        for (DataFlavor mine : getTransferDataFlavors()) {
            if (mine.equals(flavor)) {
                supported = true;
                break;
            }
        }
        return supported;
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        Object data = null;
        if (isDataFlavorSupported(flavor)) {
            data = getPanel();
        } else {
            throw new UnsupportedFlavorException(flavor);
        }

        return data;
    }

}
