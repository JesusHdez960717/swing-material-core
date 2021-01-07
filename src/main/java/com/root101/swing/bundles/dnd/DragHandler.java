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

import java.awt.Container;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @author MadProgrammer@Stackoverflow
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
        setParent(parent);

        // Create our transferable wrapper
        Transferable transferable = new PanelTransferable(getPanel());
        // Start the "drag" process...
        DragSource ds = dge.getDragSource();
        ds.startDrag(dge, null, transferable, this);
        
        doDrag();
    }

    /**
     * Do the visual action of the drag, by default, remove the panel from it's
     * parent
     *
     * @deprecated
     */
    @Deprecated
    protected void doDrag() {
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
        if (dsde.getDropSuccess()) {
            dragSuccess();
        } else {
            dragFail();
        }
        getParent().invalidate();
        getParent().repaint();
    }

    /**
     * If success, by default, remove for good the panel from it's parent
     *
     * @deprecated
     */
    @Deprecated
    protected void dragSuccess() {
        getPanel().remove(getPanel());
    }

    /**
     * If the drag fail, by default add the component to it's parent in order to
     * return to it's original state
     *
     * @deprecated
     */
    @Deprecated
    protected void dragFail() {
        getParent().add(getPanel());
    }
}
