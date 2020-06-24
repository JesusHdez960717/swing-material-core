package com.jhw.swing.material.effects;

import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.util.Utils;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;

/**
 * A floating label of a text field.
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ColorFadeInto {

    private final _MaterialButton target;
    private Animator animator;
    private final SafePropertySetter.Property<Color> color;
    private Color accentColor;
    private final Color back;

    public ColorFadeInto(_MaterialButton target, ColorChangeTo to) {
        this.target = target;

        back = target.getBackground();

        if (to == ColorChangeTo.DARKEN) {
            accentColor = Utils.darken(back);
        } else {
            accentColor = Utils.brighten(back);
        }

        color = SafePropertySetter.animatableProperty(target, target.getBackground());
        color.setValue(back);
        update();
    }

    public Color getAccent() {
        return accentColor;
    }

    public void setAccent(Color accentColor) {
        this.accentColor = accentColor;
    }

    public void update() {
        if (animator != null) {
            animator.stop();
        }
        Animator.Builder builder = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(ElevationEffect.DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        Color targetColor;
        if (target.isFocusOwner() || target.isMouseOver()) {
            targetColor = accentColor;
        } else {
            targetColor = back;
        }
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));
        }
        animator = builder.build();
        animator.start();
    }

    public Color getColor() {
        return color.getValue();
    }

    public enum ColorChangeTo {

        DARKEN, BRIGHTEN;
    }
}
