package com.jhw.swing.material.effects;

import static com.jhw.swing.material.effects.DefaultElevationEffect.DURATION;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.util.Utils;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.SafePropertySetter;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;

/**
 * An animated line that appears below a component when it is focused.
 */
public class DefaultLine<T extends JComponent & FloatingLabel> implements Line, PropertyChangeListener {

    private final T target;
    private Animator animator;
    private final SafePropertySetter.Property<Double> width;

    public DefaultLine(T target) {
        this.target = target;
        width = SafePropertySetter.animatableProperty(target, 0d);

        target.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                update();
            }
        });
        target.addPropertyChangeListener(this);
    }

    @Override
    public int getYLine(Graphics g2) {
        int yMid = target.getSize().height / 2;
        FontMetrics metrics = g2.getFontMetrics(target.getFont());
        int yLine = yMid + metrics.getAscent() / 2 + 5;
        return yLine;
    }

    @Override
    public void paintLine(Graphics g2) {
        int yLine = getYLine(g2);

        //paint the under-line 
        g2.setColor(Utils.applyAlphaMask(target.getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, target.getWidth(), 1);

        //paint the real-line, this is the one that change colors and size
        g2.setColor(target.getAccentFloatingLabel());
        g2.fillRect((int) ((target.getWidth() - getWidth()) / 2), yLine, (int) getWidth(), 2);
    }

    private void update() {
        if (animator != null) {
            animator.stop();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            setWidthAnimated();
        } else {
            width.setValue(getTargetWidth());
        }
    }

    private double getWidth() {
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "processFocusEvent":
                update();
                break;
            case "processKeyEvent":
                update();
                break;
            case "text":
                update();
                break;
            case "foreground":
                update();
                break;
        }
    }
}
