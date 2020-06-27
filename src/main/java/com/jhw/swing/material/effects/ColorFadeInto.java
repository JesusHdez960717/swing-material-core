package com.jhw.swing.material.effects;

import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;

/**
 * A floating label of a text field.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ColorFadeInto {

    private final _MaterialButton target;
    private Animator animator;
    private final SafePropertySetter.Property<Color> color;
    private Color accentColor;

    public ColorFadeInto(_MaterialButton target, ColorChangeTo to) {
        this.target = target;

        if (to == ColorChangeTo.DARKEN) {
            accentColor = Utils.darken(target.getBackground());
        } else {
            accentColor = Utils.brighten(target.getBackground());
        }

        color = SafePropertySetter.animatableProperty(target, target.getBackground());
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
        if (PersonalizationMaterial.getInstance().isUseAnimations()) {
            setColorAnimated();
        } else {
            color.setValue(getTargetColor());
        }
    }

    private Color getTargetColor() {
        Color targetColor;
        if (target.isFocusOwner() || target.isMouseOver()) {
            targetColor = accentColor;
        } else {
            targetColor = target.getBackground();
        }
        return targetColor;
    }

    public Color getColor() {
        return color.getValue();
    }

    private void setColorAnimated() {
        Animator.Builder builder = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(ElevationEffect.DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        Color targetColor = getTargetColor();
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));
        }
        animator = builder.build();
        animator.start();
    }

    public enum ColorChangeTo {

        DARKEN, BRIGHTEN;
    }
}
