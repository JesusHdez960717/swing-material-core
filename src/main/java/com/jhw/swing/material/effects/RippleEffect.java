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

/**
 * A {@code RippleEffect} is applied into certain components, like buttons and
 * certain list elements. Basically, is that wave of color that appears when you
 * click stuff.
 */
public class RippleEffect {

    public static final int DURATION = 750;
    
    private final List<RippleAnimation> ripples = new ArrayList<>();
    private final JComponent target;

    private RippleEffect(final JComponent component) {
        this.target = component;
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
    public void paint(Graphics2D g2) {
        //si no es transparente
        if (g2.getColor() != null && g2.getColor().getAlpha() != 0) {//si hay las pinto, el if esta en el add
            for (RippleAnimation rippleAnimation : ripples) {
                float rippleOpacity = rippleAnimation.rippleOpacity.getValue().floatValue();
                Point rippleCenter = rippleAnimation.rippleCenter;
                int rippleRadius = rippleAnimation.rippleRadius.getValue();

                Color fg = g2.getColor();
                g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, rippleOpacity));
                g2.fillOval(rippleCenter.x - rippleRadius, rippleCenter.y - rippleRadius, 2 * rippleRadius, 2 * rippleRadius);
            }
        }

    }

    /**
     * Adds a ripple at the given point.
     *
     * @param point point to add the ripple at
     * @param maxRadius the maximum radius of the ripple
     */
    public void addRipple(Point point, int maxRadius) {
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
    public static RippleEffect applyTo(final JComponent target) {
        final RippleEffect rippleEffect = new RippleEffect(target);
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
    public static RippleEffect applyFixedTo(final JComponent target) {
        final RippleEffect rippleEffect = new RippleEffect(target);
        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int min = Math.min(target.getWidth(), target.getHeight());
                rippleEffect.addRipple(new Point(target.getWidth() / 2, target.getHeight() / 2), min / 2);
            }
        });
        return rippleEffect;
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

        void start() {
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
