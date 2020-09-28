/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.bundles.dnd;

import java.awt.Component;
import java.awt.Container;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
