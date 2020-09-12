package com.jhw.swing.material.components.progress;

import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.SafePropertySetter.Property;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.Interpolator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialColors;

/**
 * A Material Design progress spinner. The color can be set using
 * {@link #setForeground(Color)}.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/progress-activity.html">Progress
 * &amp; activity (Google design guidelines)</a>
 */
public class _MaterialProgressSpinner extends JComponent implements MaterialComponent {

    public static _MaterialProgressSpinner from() {
        return new _MaterialProgressSpinner();
    }
    private int thick = 6;
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

    public int getThick() {
        return thick;
    }

    public void setThick(int thick) {
        this.thick = thick;
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
        g2.setStroke(new BasicStroke(getThick(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        int size = Math.min(getHeight(), getWidth());
        g2.drawArc((getWidth() - size) / 2 + getThick(), (getHeight() - size) / 2 + getThick(), size - 2 * getThick(), size - 2 * getThick(), startArc.getValue() + rotation.getValue() + 90, Math.max(1, arcSize.getValue()));
    }
}
