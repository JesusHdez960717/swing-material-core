/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultMouseAdapterInfo implements MouseAdapterInfo {

    private boolean isMousePressed = false;
    private boolean isMouseOver = false;

    public static DefaultMouseAdapterInfo from(JComponent target) {
        return new DefaultMouseAdapterInfo(target);
    }

    private DefaultMouseAdapterInfo(JComponent target) {
        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                isMousePressed = true;
                mousePressedInternal(mouseEvent);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                isMousePressed = false;
                mouseReleasedInternal(mouseEvent);
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                isMouseOver = true;
                mouseEnteredInternal(mouseEvent);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                isMouseOver = false;
                mouseExitedInternal(mouseEvent);
            }
        });
    }

    @Override
    public boolean isMousePressed() {
        return isMousePressed;
    }

    @Override
    public boolean isMouseOver() {
        return isMouseOver;
    }

    protected void mousePressedInternal(MouseEvent mouseEvent) {
    }

    protected void mouseReleasedInternal(MouseEvent mouseEvent) {
    }

    protected void mouseEnteredInternal(MouseEvent e) {
    }

    protected void mouseExitedInternal(MouseEvent e) {
    }

}
