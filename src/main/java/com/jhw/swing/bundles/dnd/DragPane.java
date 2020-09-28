/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.bundles.dnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import javax.swing.JPanel;

public class DragPane extends JPanel {

    public DragPane() {
        System.out.println("DragPane = " + this.hashCode());
        setBackground(Color.RED);
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, new DragHandler(this));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }

}
