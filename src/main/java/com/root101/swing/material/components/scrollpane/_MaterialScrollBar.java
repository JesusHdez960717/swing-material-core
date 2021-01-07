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
package com.root101.swing.material.components.scrollpane;

import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.MaterialDrawingUtils;
import java.awt.Adjustable;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialScrollBar extends MaterialScrollBar {

    public static MaterialScrollBar from(int orientation) {
        return new _MaterialScrollBar(orientation);
    }

    public static int THUMB_WIDTH_FOCUSED = 10;
    public static int THUMB_WIDTH_UNFOCUSED = 5;

    private int width = 5;
    private boolean pressed = false;
    private boolean entered = false;

    private Color background = MaterialColors.WHITE;
    private Color foreground = MaterialColors.GREY_600;

    public _MaterialScrollBar(Color background, int orientation) {
        this(background, MaterialColors.GREY_600, orientation);
    }

    public _MaterialScrollBar(int orientation) {
        this(MaterialColors.WHITE, MaterialColors.GREY_600, orientation);
    }

    public _MaterialScrollBar(Color background, Color foreground, int orientation) {
        super(orientation);
        this.setBackgroundThumb(background);
        this.setForegroundThumb(foreground);

        setPreferredSize(new Dimension(width, width));

        setUI(new BasicScrollBarUI() {
            @Override
            protected BasicScrollBarUI.ScrollListener createScrollListener() {
                setUnitIncrement(56);
                setBlockIncrement(560);
                return super.createScrollListener();
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(getBackgroundThumb());
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton dummyButton = new JButton();
                dummyButton.setPreferredSize(new Dimension(0, 0));
                return dummyButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton dummyButton = new JButton();
                dummyButton.setPreferredSize(new Dimension(0, 0));
                return dummyButton;
            }

            @Override
            protected Dimension getMinimumThumbSize() {
                return new Dimension(0, 0);//se crea de verdad en el doAdjust del constructor
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                if (!thumbBounds.isEmpty() && this.scrollbar.isEnabled()) {
                    Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

                    boolean isVertical = _MaterialScrollBar.this.getOrientation()
                            == Adjustable.VERTICAL;
                    g2.setColor(getForegroundThumb());
                    g2.fillRoundRect(thumbBounds.x, thumbBounds.y,
                            isVertical ? width : thumbBounds.width, isVertical ? thumbBounds.height : width,
                            isVertical ? thumbBounds.width : thumbBounds.height,
                            isVertical ? thumbBounds.width : thumbBounds.height);
                }
            }

            @Override
            public void layoutContainer(Container scrollbarContainer) {
                super.layoutContainer(scrollbarContainer);
                incrButton.setBounds(0, 0, 0, 0);
                decrButton.setBounds(0, 0, 0, 0);
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered();
                super.mouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited();
                super.mouseExited(evt);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                registerMouseReleased();
                super.mouseReleased(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                registerMousePressed();
                super.mousePressed(e);
            }

        });
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        doAdjust();
    }

    @Override
    public Color getBackgroundThumb() {
        return background;
    }

    @Override
    public void setBackgroundThumb(Color background) {
        this.background = background;
        repaint();
    }

    @Override
    public Color getForegroundThumb() {
        return foreground;
    }

    @Override
    public void setForegroundThumb(Color foreground) {
        this.foreground = foreground;
        repaint();
    }

    @Override
    public int getThumbWidth() {
        return width;
    }

    private void registerMouseEntered() {
        entered = true;
        doAdjust();
    }

    private void registerMouseExited() {
        entered = false;
        doAdjust();
    }

    private void registerMousePressed() {
        pressed = true;
        doAdjust();
    }

    private void registerMouseReleased() {
        pressed = false;
        doAdjust();
    }

    private void doAdjust() {
        //if (entered || pressed) {
        this.width = THUMB_WIDTH_FOCUSED;
        //} else {
        //    this.width = THUMB_WIDTH_UNFOCUSED;
        //}
        setPreferredSize(new Dimension(width, width));
        revalidate();
    }

    @Override
    public Component add(Component comp) {
        if (comp != null) {
            return super.add(comp);
        }
        return null;
    }

}
