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
package com.root101.swing.material.components.progress;

import com.root101.swing.util.SafePropertySetter;
import com.root101.swing.util.SafePropertySetter.Property;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.Interpolator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import com.root101.swing.util.Utils;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.standards.MaterialColors;

/**
 * A Material Design progress spinner. The color can be set using
 * {@link #setForeground(Color)}.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/progress-activity.html">Progress
 * &amp; activity (Google design guidelines)</a>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialProgressSpinner extends MaterialProgressSpinner {

    public static MaterialProgressSpinner from() {
        return new _MaterialProgressSpinner();
    }

    private int thickness = 6;
    private final Property<Integer> startArc = SafePropertySetter.animatableProperty(this, 270);
    private final Property<Integer> arcSize = SafePropertySetter.animatableProperty(this, 0);
    private final Property<Integer> rotation = SafePropertySetter.animatableProperty(this, 0);

    /**
     * Creates a new progress spinner.
     */
    public _MaterialProgressSpinner() {
        //animation contants from https://github.com/PolymerElements/paper-spinner
        setForeground(MaterialColors.BLACK);
        final int ARCSIZE = 270;
        final int ARCTIME = 1333;
        final int ARCSTARTROT = 216;

        Animator animator = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(4 * ARCTIME, TimeUnit.MILLISECONDS)
                .setRepeatCount(Animator.INFINITE)
                .setRepeatBehavior(Animator.RepeatBehavior.LOOP)
                .addTarget(SafePropertySetter.getTarget(startArc, 0, -270, -2 * 270, -3 * 270, -4 * 270))
                .setInterpolator(new Interpolator() {
                    private final Interpolator spline = new SplineInterpolator(0.4, 0, 0.2, 1);

                    @Override
                    public double interpolate(double v) {
                        if (v < 0.125) {
                            return spline.interpolate(v * 8) / 4;
                        } else if (v < 0.25) {
                            return 0.25;
                        } else if (v < 0.375) {
                            return spline.interpolate((v - 0.25) * 8) / 4 + 0.25;
                        } else if (v < 0.5) {
                            return 0.5;
                        } else if (v < 0.625) {
                            return spline.interpolate((v - 0.5) * 8) / 4 + 0.5;
                        } else if (v < 0.75) {
                            return 0.75;
                        } else if (v < 0.875) {
                            return spline.interpolate((v - 0.75) * 8) / 4 + 0.75;
                        } else {
                            return 1;
                        }
                    }
                })
                .build();
        animator.start();
        Animator animator2 = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(ARCTIME, TimeUnit.MILLISECONDS)
                .setRepeatCount(Long.MAX_VALUE)
                .setRepeatBehavior(Animator.RepeatBehavior.LOOP)
                .addTarget(SafePropertySetter.getTarget(arcSize, 0, 270, 0))
                .setInterpolator(new Interpolator() {
                    private final Interpolator spline = new SplineInterpolator(0.4, 0, 0.2, 1);

                    @Override
                    public double interpolate(double v) {
                        if (v < 0.5) {
                            return spline.interpolate(v * 2) / 2;
                        } else {
                            return spline.interpolate((v - 0.5) * 2) / 2 + 0.5;
                        }
                    }
                })
                .build();
        animator2.start();
        Animator animator3 = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(360 * ARCTIME / (ARCSTARTROT + (360 - ARCSIZE)), TimeUnit.MILLISECONDS)
                .setRepeatCount(Long.MAX_VALUE)
                .setRepeatBehavior(Animator.RepeatBehavior.LOOP)
                .addTarget(SafePropertySetter.getTarget(rotation, 360, 0))
                .build();
        animator3.start();

        setPreferredSize(new Dimension(50, 50));
        setLayout(null);
        setBounds(0, 0, getPreferredSize().width, getPreferredSize().height);
        setOpaque(false);
    }

    @Override
    public int getThickness() {
        return thickness;
    }

    @Override
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        g2.setColor(getForeground());
        g2.setStroke(new BasicStroke(getThickness(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        int size = Math.min(getHeight(), getWidth());
        g2.drawArc((getWidth() - size) / 2 + getThickness(), (getHeight() - size) / 2 + getThickness(), size - 2 * getThickness(), size - 2 * getThickness(), startArc.getValue() + rotation.getValue() + 90, Math.max(1, arcSize.getValue()));
    }
}
