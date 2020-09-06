package com.jhw.swing.material.effects;

import com.jhw.swing.util.SafePropertySetter;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

/**
 * An elevation effect.
 */
public class DefaultElevationEffect {

    public static long DURATION = 250;
    protected final JComponent target;
    private Animator animator;
    protected final SafePropertySetter.Property<Double> level;
    protected double targetLevel = 0;

    protected final MaterialShadow shadowFast = new MaterialShadow();
    protected int borderRadius = 2;

    private DefaultElevationEffect(JComponent component, double level) {
        this.target = component;

        this.targetLevel = level;
        this.level = SafePropertySetter.animatableProperty(target, targetLevel);
    }

    /**
     * Gets the elevation level.
     *
     * @return elevation level [0~5]
     */
    public double getLevel() {
        return targetLevel;
    }

    /**
     * Sets the elevation level.
     *
     * @param level elevation level [0~5]
     */
    public void setLevel(double level) {
        if (animator != null) {
            animator.stop();
        }
        this.targetLevel = level;
        this.level.setValue((double) targetLevel);
        if (target.isShowing()) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS) && level != targetLevel) {
                setElevationAnimated(level);
            }
        }
    }

    /**
     * Gets the current border radius of the component casting a shadow. This
     * should be updated by the target component if such a property exists for
     * it and is modified.
     *
     * @return the current border radius casted on the shadow, in pixels.
     */
    public int getBorderRadius() {
        return borderRadius;
    }

    /**
     * Sets the current border radius of the component casting a shadow. This
     * should be updated by the target component if such a property exists for
     * it and is modified.
     *
     * @param borderRadius the new border radius casted on the shadow, in
     * pixels.
     */
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    /**
     * Paints this effect.
     *
     * @param g2 canvas
     */
    public void paint(Graphics2D g2) {
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
            //priorizado la velocidad, la calidad no hace diferencia
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

            g2.setBackground(target.getParent().getBackground());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            g2.drawImage(shadowFast.render(target.getWidth(), target.getHeight(), borderRadius, level.getValue(), MaterialShadow.Type.SQUARE), 0, 0, null);

            MaterialDrawingUtils.getAliasedGraphics(g2);
        }
    }

    /**
     * Creates an elevation effect for the given component. Each component is
     * responsible of calling {@link #paint(Graphics)} in order to display the
     * effect. For this to work, there should be an offset between the contents
     * of the component and its actual bounds, these values can be found in
     * {@link MaterialShadow}.
     *
     * @param target the target of the resulting {@code DefaultElevationEffect}
     * @param level the initial elevation level [0~5]
     * @return an {@code DefaultElevationEffect} object providing support for painting
     * ripples
     * @see MaterialShadow#OFFSET_TOP
     * @see MaterialShadow#OFFSET_BOTTOM
     * @see MaterialShadow#OFFSET_LEFT
     * @see MaterialShadow#OFFSET_RIGHT
     */
    public static DefaultElevationEffect applyTo(JComponent target, double level) {
        return new DefaultElevationEffect(target, level);
    }

    /**
     * Creates an elevation effect with a circular shadow for the given
     * component. Each component is responsible of calling {@link
     * #paint(Graphics)} in order to display the effect. For this to work, there
     * should be an offset between the contents of the component and its actual
     * bounds, these values can be found in {@link MaterialShadow}.
     *
     * @param target the target of the resulting {@code DefaultElevationEffect}
     * @param level the initial elevation level [0~5]
     * @return an {@code DefaultElevationEffect} object providing support for painting
     * ripples
     * @see MaterialShadow#OFFSET_TOP
     * @see MaterialShadow#OFFSET_BOTTOM
     * @see MaterialShadow#OFFSET_LEFT
     * @see MaterialShadow#OFFSET_RIGHT
     */
    public static DefaultElevationEffect applyCirularTo(JComponent target, double level) {
        return new DefaultElevationEffect.Circular(target, level);
    }

    private void setElevationAnimated(double level) {
        animator = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.55, 0, 0.1, 1))
                .addTarget(SafePropertySetter.getTarget(this.level, this.level.getValue(), (double) level))
                .build();
        animator.start();
    }

    /**
     * An elevation effect with a circular shadow.
     */
    public static class Circular extends DefaultElevationEffect {

        private Circular(JComponent component, double level) {
            super(component, level);
        }

        @Override
        public void paint(Graphics2D g2) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
                //priorizado la velocidad, la calidad no hace diferencia
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

                g2.setBackground(target.getParent().getBackground());
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                g2.drawImage(shadowFast.render(target.getWidth(), target.getHeight(), borderRadius, level.getValue(), MaterialShadow.Type.CIRCULAR), 0, 0, null);

                MaterialDrawingUtils.getAliasedGraphics(g2);
            }
        }
    }
}
