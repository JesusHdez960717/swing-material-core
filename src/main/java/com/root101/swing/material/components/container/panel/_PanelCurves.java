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
package com.root101.swing.material.components.container.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su logica de edisoncorSX.
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _PanelCurves extends JPanel implements MaterialComponent {

    public static _PanelCurves from() {
        return new _PanelCurves();
    }

    protected int counter;
    protected Color end;
    protected RenderingHints hints;
    protected Color start;

    public _PanelCurves() {
        this(new BorderLayout());
        this.hints = createRenderingHints();
        startAnimation();
    }

    public _PanelCurves(LayoutManager manager) {
        super(manager);
        this.counter = 0;
        this.start = new Color(255, 255, 255, 200);
        this.end = new Color(255, 255, 255, 0);
        this.hints = createRenderingHints();
    }

    private void startAnimation() {
        new Timer(50, (ActionEvent e) -> {
            _PanelCurves.this.animate();
            _PanelCurves.this.repaint();
        }).start();
    }

    protected RenderingHints createRenderingHints() {
        RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return renderHints;
    }

    public void animate() {
        this.counter++;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        RenderingHints oldHints = g2.getRenderingHints();
        g2.setRenderingHints(this.hints);
        float width = (float) getWidth();
        float height = (float) getHeight();
        g2.translate(0, -30);
        drawCurve(g2, 20.0f, -10.0f, 20.0f, -10.0f, (width / 2.0f) - 40.0f, 10.0f, 0.0f, -5.0f, 40.0f + (width / 2.0f), 1.0f, 0.0f, 5.0f, 50.0f, 5.0f, false);
        g2.translate(0, 30);
        g2.translate(0.0d, (double) (height - 60.0f));
        drawCurve(g2, 30.0f, -15.0f, 50.0f, 15.0f, (width / 2.0f) - 40.0f, 1.0f, 15.0f, -25.0f, width / 2.0f, 0.5f, 0.0f, 25.0f, 15.0f, 9.0f, false);
        g2.translate(0.0d, (double) ((-height) + 60.0f));
        drawCurve(g2, height - 35.0f, -5.0f, height - 50.0f, 10.0f, (width / 2.0f) - 40.0f, 1.0f, height - 35.0f, -25.0f, width / 2.0f, 0.5f, height - 20.0f, 25.0f, 25.0f, 7.0f, true);
        g2.setRenderingHints(oldHints);
    }

    protected void drawCurve(Graphics2D g2, float y1, float y1_offset, float y2, float y2_offset, float cx1, float cx1_offset, float cy1, float cy1_offset, float cx2, float cx2_offset, float cy2, float cy2_offset, float thickness, float speed, boolean invert) {
        float offset = (float) Math.sin(((double) this.counter) / (((double) speed) * 3.141592653589793d));
        float start_y = (offset * y1_offset) + y1;
        float end_x = (float) getWidth();
        float end_y = (offset * y2_offset) + y2;
        float ctrl1_x = (offset * cx1_offset) + cx1;
        float ctrl1_y = (offset * cy1_offset) + cy1;
        float ctrl2_x = (offset * cx2_offset) + cx2;
        float ctrl2_y = (offset * cy2_offset) + cy2;
        GeneralPath thickCurve = new GeneralPath();
        thickCurve.moveTo(0.0f, start_y);
        thickCurve.curveTo(ctrl1_x, ctrl1_y, ctrl2_x, ctrl2_y, end_x, end_y);
        thickCurve.lineTo(end_x, end_y + thickness);
        thickCurve.curveTo(ctrl2_x, ctrl2_y + thickness, ctrl1_x, ctrl1_y + thickness, 0.0f, start_y + thickness);
        thickCurve.lineTo(0.0f, start_y);
        Rectangle bounds = thickCurve.getBounds();
        if (bounds.intersects(g2.getClipBounds())) {
            GradientPaint painter = new GradientPaint(0.0f, (float) bounds.y, invert ? this.end : this.start, 0.0f, (float) (bounds.y + bounds.height), invert ? this.start : this.end);
            Paint oldPainter = g2.getPaint();
            g2.setPaint(painter);
            g2.fill(thickCurve);
            g2.setPaint(oldPainter);
        }
    }
}
