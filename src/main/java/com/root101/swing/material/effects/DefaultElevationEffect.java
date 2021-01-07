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
package com.root101.swing.material.effects;

import com.root101.swing.util.SafePropertySetter;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.root101.swing.util.Utils;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.standards.MaterialShadow;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * An elevation effect.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class DefaultElevationEffect<T extends JComponent & ElevationEffect> implements ElevationEffect, PropertyChangeListener, Serializable {

    public static final long DURATION = 250;

    protected final T target;

    private Animator animator;
    protected final SafePropertySetter.Property<Double> level;

    protected final MaterialShadow shadowFast = new MaterialShadow();
    protected int borderRadius = 2;
    protected float opacity = 1.0f;

    private DefaultElevationEffect(T component, double level) {
        this.target = component;

        this.level = SafePropertySetter.animatableProperty(target, level);

        target.addPropertyChangeListener(this);
    }

    /**
     * Gets the elevation level.
     *
     * @return elevation level [0~5]
     */
    @Override
    public double getLevel() {
        return this.level.getValue();
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
        if (target.isShowing()) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
                setElevationAnimated(level);
            } else {
                this.level.setValue(level);
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
    @Override
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
    @Override
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    @Override
    public double getElevation() {
        return target.getElevation();
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    /**
     * Paints this effect.
     *
     * @param g2 canvas
     */
    @Override
    public void paintElevation(Graphics2D g2) {
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
            //priorizado la velocidad, la calidad no hace diferencia
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

            g2.setBackground(target.getParent().getBackground());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
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
     * @return an {@code DefaultElevationEffect} object providing support for
     * painting ripples
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
     * @return an {@code DefaultElevationEffect} object providing support for
     * painting ripples
     * @see MaterialShadow#OFFSET_TOP
     * @see MaterialShadow#OFFSET_BOTTOM
     * @see MaterialShadow#OFFSET_LEFT
     * @see MaterialShadow#OFFSET_RIGHT
     */
    public static DefaultElevationEffect applyCirularTo(JComponent target, double level) {
        return new DefaultElevationEffect.Circular(target, level);
    }

    public static DefaultElevationEffect applyRoundTo(JComponent target, double level) {
        return new DefaultElevationEffect.Round(target, level);
    }

    private void setElevationAnimated(double level) {
        if (getLevel() != level) {
            if (animator != null) {
                animator.stop();
            }
            animator = new Animator.Builder(Utils.getSwingTimerTimingSource())
                    .setDuration(DURATION, TimeUnit.MILLISECONDS)
                    .setEndBehavior(Animator.EndBehavior.HOLD)
                    .setInterpolator(new SplineInterpolator(0.55, 0, 0.1, 1))
                    .addTarget(SafePropertySetter.getTarget(this.level, getLevel(), (double) level))
                    .build();
            animator.start();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "borderRadius":
                this.setBorderRadius((int) evt.getNewValue());
                break;
            case "enabled":
                setLevel(getElevation());
                break;
            case "processFocusEvent":
                setLevel(getElevation());
                break;
            case "processMouseEvent":
                setLevel(getElevation());
                break;
        }
    }

    /**
     * An elevation effect with a circular shadow.
     */
    public static class Circular extends DefaultElevationEffect {

        private Circular(JComponent component, double level) {
            super(component, level);
        }

        @Override
        public void paintElevation(Graphics2D g2) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
                //priorizado la velocidad, la calidad no hace diferencia
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

                g2.setBackground(target.getParent().getBackground());
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2.drawImage(shadowFast.render(target.getWidth(), target.getHeight(), borderRadius, (double) level.getValue(), MaterialShadow.Type.CIRCULAR), 0, 0, null);

                MaterialDrawingUtils.getAliasedGraphics(g2);
            }
        }
    }

    /**
     * An elevation effect with a round shadow.
     */
    public static class Round extends DefaultElevationEffect {

        private Round(JComponent component, double level) {
            super(component, level);
        }

        @Override
        public void paintElevation(Graphics2D g2) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
                //priorizado la velocidad, la calidad no hace diferencia
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

                g2.setBackground(target.getParent().getBackground());
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2.drawImage(shadowFast.render(target.getWidth(), target.getHeight(), borderRadius, (double) level.getValue(), MaterialShadow.Type.ROUND), 0, 0, null);

                MaterialDrawingUtils.getAliasedGraphics(g2);
            }
        }
    }
}
