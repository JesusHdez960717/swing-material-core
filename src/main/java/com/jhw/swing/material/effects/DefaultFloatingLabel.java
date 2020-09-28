package com.jhw.swing.material.effects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import static com.jhw.swing.material.standards.Utils.*;
import java.io.Serializable;

/**
 * A floating label of a component that complies to the FloatingLabelStandar
 */
public class DefaultFloatingLabel<T extends JComponent & BindableComponent> implements FloatingLabel, Serializable, PropertyChangeListener {

    public static final int DURATION = 200;

    private final T target;
    private Animator animator;

    private final SafePropertySetter.Property<Integer> y;
    private final SafePropertySetter.Property<Float> fontSize;
    private final SafePropertySetter.Property<Color> color;

    private Color accentColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_ACCENT);
    private String label = "label";
    private String hint = "hint";

    public DefaultFloatingLabel(T target) {
        this.target = target;

        y = SafePropertySetter.animatableProperty(target, 0);//target.getSize().height / 2 + target.getFontMetrics(target.getFont()).getAscent() / 2);
        fontSize = SafePropertySetter.animatableProperty(target, target.getFont().getSize2D());
        color = SafePropertySetter.animatableProperty(target, Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));

        target.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                update();
            }
        });
        this.target.addPropertyChangeListener(this);
    }

//-------------------FLOATING_LABEL-------------------------
    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        this.accentColor = accentColor;
        update();
    }

    @Override
    public Color getAccentFloatingLabel() {
        return accentColor;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
        update();
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public void setHint(String hint) {
        this.hint = hint;
        update();
    }

    @Override
    public void paintLabel(Graphics g2) {
        g2.setColor(getColor());
        g2.setFont(getFont());
        if (!getLabel().isEmpty()) {
            g2.drawString(getLabel(), 0, getY());//paint the hint in the same place as the text
        }
    }

    @Override
    public void paintHint(Graphics g2) {
        if (isFloatingAbove()) {
            int yMid = (int) (target.getSize().getHeight() / 2);

            FontMetrics metrics = g2.getFontMetrics(target.getFont());

            g2.setColor(Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));
            g2.setFont(target.getFont());
            g2.drawString(getHint(), 0, metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }
    }
//-------------------FLOATING_LABEL-------------------------

    private void update() {
        if (animator != null) {
            animator.stop();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            setValuesAnimated();
        } else {
            setValuesStatics();
        }
    }

    private Color getColor() {
        return color.getValue();
    }

    private Font getFont() {
        return target.getFont().deriveFont(fontSize.getValue());
    }

    private int getY() {
        return y.getValue();
    }

    private boolean isFloatingAbove() {
        return y.getValue() >= getYPositionUP();
    }

    protected int getYPositionUP() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionUP = yMid - metrics.getAscent() / 2 - 7;//un poquito mas arriba del texto
        return yPositionUP;
    }

    protected int getYPositionDOWN() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionDown = yMid + metrics.getAscent() / 2;//un poquito mas arriba del texto
        return yPositionDown;
    }

    protected float getTargetFontSize() {
        return (target.isFocusOwner() || (target.getObject() != null && !target.getObject().toString().isEmpty())) ? target.getFont().getSize2D() * 0.8f : target.getFont().getSize2D();
    }

    protected int getTargetYPosition() {
        return target.isFocusOwner() || (target.getObject() != null && !target.getObject().toString().isEmpty()) ? getYPositionUP() : getYPositionDOWN();
    }

    private Color getTargetColor() {
        return target.isFocusOwner() ? accentColor : Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK);
    }

    private void setValuesAnimated() {
        Animator.Builder builder = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        //Font size, si no hay letra es tamaño real, si esta arriba es el 80% del tamaño(1 poquito mas chiquito)
        float targetFontSize = getTargetFontSize();
        if (fontSize.getValue() != targetFontSize) {
            builder.addTarget(SafePropertySetter.getTarget(fontSize, fontSize.getValue(), targetFontSize));
        }

        //Y position
        int targetY = getTargetYPosition();
        if (Math.abs(targetY - y.getValue()) > 0.1) {
            builder.addTarget(SafePropertySetter.getTarget(y, y.getValue(), targetY));
        }

        //color, varia entre el color de accent y el de Opacity_Mask
        Color targetColor = getTargetColor();
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));
        }

        animator = builder.build();
        animator.start();
    }

    private void setValuesStatics() {
        //Font size, si no hay letra es tamaño real, si esta arriba es el 80% del tamaño(1 poquito mas chiquito)
        fontSize.setValue(getTargetFontSize());

        //Y position
        y.setValue(getTargetYPosition());

        //color, varia entre el color de accent y el de Opacity_Mask
        color.setValue(getTargetColor());
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
