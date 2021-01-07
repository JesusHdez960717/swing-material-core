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
package com.root101.swing.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
