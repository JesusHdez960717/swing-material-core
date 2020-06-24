package com.jhw.swing.material.effects;

import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.util.SafePropertySetter;

/**
 * An animated line that appears below a component when it is focused.
 */
public class Line {

    private final JComponent target;
    private Animator animator;
    private final SafePropertySetter.Property<Double> width;

    public Line(JComponent target) {
        this.target = target;
        width = SafePropertySetter.animatableProperty(target, 0d);
    }

    public void update() {
        if (animator != null) {
            animator.stop();
        }
        animator = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(200, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1))
                .addTarget(SafePropertySetter.getTarget(width, width.getValue(), target.isFocusOwner() ? (double) target.getWidth() + 1 : 0d))
                .build();
        animator.start();
    }

    public double getWidth() {
        return width.getValue();
    }
}
