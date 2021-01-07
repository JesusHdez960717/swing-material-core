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
package com.root101.swing.material.components.glasspane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import com.root101.swing.util.MaterialDrawingUtils;

/**
 *
 * @author Filthy Rich Clients Book
 */
public class CustomGlassPane extends JComponent {

    public CustomGlassPane() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        Rectangle clip = g.getClipBounds();
        Color alphaWhite = new Color(1.0f, 1.0f, 1.0f, 0.65f);
        g2.setColor(alphaWhite);
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }

    /**
     * Hide the Glass Pane. Set up it's visibility to false.
     */
    public void hideMe() {
        this.setVisible(false);
    }

    /**
     * Show the Glass Pane. Set up it's visibility to true.
     */
    public void showMe() {
        this.setVisible(true);
    }
}
