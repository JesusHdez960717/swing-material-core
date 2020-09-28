/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.bundles.dnd;

import java.awt.Container;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DragHandler implements DragGestureListener, DragSourceListener, Serializable {

    private Container parent;
    private final JPanel child;

    public DragHandler(JPanel child) {
        this.child = child;
    }

    public JPanel getPanel() {
        return child;
    }

    public void setParent(Container parent) {
        this.parent = parent;
    }

    public Container getParent() {
        return parent;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        // When the drag begins, we need to grab a reference to the
        // parent container so we can return it if the drop
        // is rejected
        Container parent = getPanel().getParent();
        System.out.println("parent = " + parent.hashCode());
        setParent(parent);

        // Remove the panel from the parent.  If we don't do this, it
        // can cause serialization issues.  We could overcome this
        // by allowing the drop target to remove the component, but that's
        // an argument for another day
        // This is causing a NullPointerException on MacOS 10.13.3/Java 8
        //      parent.remove(getPanel());
        //      // Update the display
        //      parent.invalidate();
        //      parent.repaint();
        // Create our transferable wrapper
        System.out.println("Drag " + getPanel().hashCode());
        Transferable transferable = new PanelTransferable(getPanel());
        // Start the "drag" process...
        DragSource ds = dge.getDragSource();
        ds.startDrag(dge, null, transferable, this);

        parent.remove(getPanel());
        // Update the display
        parent.invalidate();
        parent.repaint();
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragExit(DragSourceEvent dse) {
    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
        // If the drop was not successful, we need to
        // return the component back to it's previous
        // parent
        if (!dsde.getDropSuccess()) {
            getParent().add(getPanel());
        } else {
            getPanel().remove(getPanel());
        }
        getParent().invalidate();
        getParent().repaint();
    }
}
