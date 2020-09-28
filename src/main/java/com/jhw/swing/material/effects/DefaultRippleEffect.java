package com.jhw.swing.material.effects;

import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.SafePropertySetter.Property;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingTargetAdapter;
import org.jdesktop.core.animation.timing.interpolators.AccelerationInterpolator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.jhw.swing.util.Utils;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * A {@code DefaultRippleEffect} is applied into certain components, like
 * buttons and certain list elements. Basically, is that wave of color that
 * appears when you click stuff.
 */
public class DefaultRippleEffect implements RippleEffect, PropertyChangeListener, Serializable {

    public static final int DURATION = 750;

    private final List<RippleAnimation> ripples = new ArrayList<>();
    private final JComponent target;

    private Color rippleColor = Color.WHITE;

    private boolean paintRipple = true;

    private DefaultRippleEffect(final JComponent component) {
        this.target = component;
        target.addPropertyChangeListener(this);
    }

    /**
     * Gets the ripple color.
     *
     * @return the ripple color
     */
    @Override
    public Color getRippleColor() {
        return rippleColor;
    }

    /**
     * Sets the ripple color. You should only do this for flat buttons.
     *
     * @param rippleColor the ripple color
     */
    @Override
    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    @Override
    public boolean getPaintRipple() {
        return paintRipple;
    }

    @Override
    public void setPaintRipple(boolean paintRipple) {
        this.paintRipple = paintRipple;
    }

    /**
     * Paints this effect. Each component is responsible of calling {@link
     * #paint(Graphics)} in order to display the effect. Here's an example of
     * how the ripple effect can be used:
     * <p/>
     * <code>
     * protected void paintComponent(Graphics g) {<br/>
     * super.paintComponent(g);<br/>
     * if (isEnabled()) {<br/>
     * g.setClip(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));<br/>
     * g.setColor(myRippleColor);<br/>
     * ripple.paint(g);<br/>
     * }<br/>
     * }
     * </code>
     *
     * @param g2 canvas
     */
    @Override
    public void paintRipple(Graphics2D g2) {
        //si no es transparente
        if (g2.getColor() != null && g2.getColor().getAlpha() != 0 && paintRipple) {//si hay las pinto, el if esta en el add
            for (RippleAnimation rippleAnimation : ripples) {
                float rippleOpacity = rippleAnimation.rippleOpacity.getValue().floatValue();
                Point rippleCenter = rippleAnimation.rippleCenter;
                int rippleRadius = rippleAnimation.rippleRadius.getValue();

                g2.setColor(new Color(rippleColor.getRed() / 255f, rippleColor.getGreen() / 255f, rippleColor.getBlue() / 255f, rippleOpacity));

                //funciona bien, pero el clip no es smooth
                Shape shape = new java.awt.geom.Ellipse2D.Float(rippleCenter.x - rippleRadius, rippleCenter.y - rippleRadius, 2 * rippleRadius, 2 * rippleRadius);
                g2.fill(shape);

                /*
                //clip smooth pero el radius no
                Shape clip = g2.getClip();
                Shape shape = new java.awt.geom.Ellipse2D.Float(rippleCenter.x - rippleRadius, rippleCenter.y - rippleRadius, 2 * rippleRadius, 2 * rippleRadius);

                Area area = new Area(clip);
                area.intersect(new Area(shape));
                
                g2.setClip(shape);
                g2.fill(area);
                g2.setClip(clip);
                 */
            }
        }
    }

    /**
     * Adds a ripple at the given point.
     *
     * @param point point to add the ripple at
     * @param maxRadius the maximum radius of the ripple
     */
    private void addRipple(Point point, int maxRadius) {
        //si no hay animaciones no agrego el ripple
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            final RippleAnimation ripple = new RippleAnimation(point, maxRadius);
            ripples.add(ripple);
            ripple.start();
        }
    }

    /**
     * Creates a ripple effect for the given component. Each component is
     * responsible of calling {@link #paint(Graphics)} in order to display the
     * effect. Here's an example of how the ripple effect can be used:
     * <p/>
     * <code>
     * protected void paintComponent(Graphics g) {<br/>
     * super.paintComponent(g);<br/>
     * if (isEnabled()) {<br/>
     * g.setClip(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));<br/>
     * g.setColor(myRippleColor);<br/>
     * ripple.paint(g);<br/>
     * }<br/>
     * }
     * </code>
     *
     * @param target target component
     * @return ripple effect for that component
     * @see MaterialButton for an example of how the ripple effect is used
     */
    public static DefaultRippleEffect applyTo(final JComponent target) {
        final DefaultRippleEffect rippleEffect = new DefaultRippleEffect(target);
        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                rippleEffect.addRipple(e.getPoint(), target.getWidth());
            }
        });
        return rippleEffect;
    }

    /**
     * Creates a ripple effect for the given component that is limited to the
     * component's size and will always start in the center. Each component is
     * responsible of calling {@link #paint(Graphics)} in order to display the
     * effect. Here's an example of how the ripple effect can be used:
     * <p/>
     * <code>
     * protected void paintComponent(Graphics g) {<br/>
     * super.paintComponent(g);<br/>
     * if (isEnabled()) {<br/>
     * g.setClip(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));<br/>
     * g.setColor(myRippleColor);<br/>
     * ripple.paint(g);<br/>
     * }<br/>
     * }
     * </code>
     *
     * @param target target component
     * @return ripple effect for that component
     * @see MaterialButton for an example of how the ripple effect is used
     */
    public static DefaultRippleEffect applyFixedTo(final JComponent target) {
        final DefaultRippleEffect rippleEffect = new DefaultRippleEffect(target);
        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int min = Math.min(target.getWidth(), target.getHeight());
                rippleEffect.addRipple(new Point(target.getWidth() / 2, target.getHeight() / 2), min / 2);
            }
        });
        return rippleEffect;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "background":
                setRippleColor(Utils.getForegroundAccording((Color) evt.getNewValue()));
                break;
        }
    }

    /**
     * A ripple animation (one ripple circle after one click).
     */
    public class RippleAnimation {

        private final Point rippleCenter;
        private final int maxRadius;
        private final Property<Integer> rippleRadius = SafePropertySetter.animatableProperty(target, 25);
        private final Property<Double> rippleOpacity = SafePropertySetter.animatableProperty(target, 0.0);

        private RippleAnimation(Point rippleCenter, int maxRadius) {
            this.rippleCenter = rippleCenter;
            this.maxRadius = maxRadius;
        }

        private void start() {
            //rippleCenter.setLocation(rippleCenter);
            Animator rippleAnimator = new Animator.Builder(Utils.getSwingTimerTimingSource())
                    .setDuration(DURATION, TimeUnit.MILLISECONDS)
                    .setEndBehavior(Animator.EndBehavior.HOLD)
                    .setInterpolator(new AccelerationInterpolator(0.2, 0.19))
                    .addTarget(SafePropertySetter.getTarget(rippleRadius, 0, maxRadius / 2, maxRadius, maxRadius))
                    .addTarget(SafePropertySetter.getTarget(rippleOpacity, 0.0, 0.4, 0.3, 0.0))
                    .addTarget(new TimingTargetAdapter() {
                        @Override
                        public void end(Animator source) {
                            ripples.remove(RippleAnimation.this);
                        }
                    })
                    .build();
            rippleAnimator.start();
        }
    }
}
