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

import java.awt.Component;
import java.awt.Container;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @author MadProgrammer@Stackoverflow
 */
public class DropHandler implements DropTargetListener, Serializable {

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        // Determine if we can actually process the contents coming in.
        // You could try and inspect the transferable as well, but 
        // there is an issue on the MacOS under some circumstances
        // where it does not actually bundle the data until you accept the
        // drop.
        if (dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)) {
            dtde.acceptDrag(DnDConstants.ACTION_MOVE);
        } else {
            dtde.rejectDrag();
        }
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        boolean success = false;
        // Basically, we want to unwrap the present...
        if (dtde.isDataFlavorSupported(PanelDataFlavor.SHARED_INSTANCE)) {
            Transferable transferable = dtde.getTransferable();
            try {
                Object data = transferable.getTransferData(PanelDataFlavor.SHARED_INSTANCE);
                if (data instanceof JPanel) {
                    JPanel panel = (JPanel) data;
                    DropTargetContext dtc = dtde.getDropTargetContext();
                    Component component = dtc.getComponent();
                    if (component instanceof JComponent) {
                        doDrop(panel, component);
                        success = true;
                        dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                    } else {
                        success = false;
                        dtde.rejectDrop();
                    }
                } else {
                    success = false;
                    dtde.rejectDrop();
                }
            } catch (Exception exp) {
                success = false;
                dtde.rejectDrop();
                exp.printStackTrace();
            }
        } else {
            success = false;
            dtde.rejectDrop();
        }
        dtde.dropComplete(success);
    }

    @Deprecated
    protected void doDrop(JPanel dragged, Component targetDrop) throws Exception {
        Container parent = dragged.getParent();
        if (parent != null) {
            parent.remove(dragged);
            parent.revalidate();
            parent.repaint();
        }
        ((JComponent) targetDrop).add(dragged);
        ((JComponent) targetDrop).invalidate();
        ((JComponent) targetDrop).repaint();
    }

}
