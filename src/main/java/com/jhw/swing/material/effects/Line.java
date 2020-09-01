package com.jhw.swing.material.effects;

import static com.jhw.swing.material.effects.ElevationEffect.DURATION;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.util.Utils;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.SafePropertySetter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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

        target.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                update();
            }
        });
    }

    public void update() {
        if (animator != null) {
            animator.stop();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            setWidthAnimated();
        } else {
            width.setValue(getTargetWidth());
        }
    }

    public double getWidth() {
        return width.getValue();
    }

    private void setWidthAnimated() {
        animator = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1))
                .addTarget(SafePropertySetter.getTarget(width, width.getValue(), getTargetWidth()))
                .build();
        animator.start();
    }

    private double getTargetWidth() {
        return target.isFocusOwner() ? (double) target.getWidth() + 1 : 0d;
    }
}
