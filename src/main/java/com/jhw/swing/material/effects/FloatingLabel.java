package com.jhw.swing.material.effects;

import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.concurrent.TimeUnit;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.util.Utils;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.TextTypeEnum;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * A floating label of a component that complies to the FloatingLabelStandar
 */
public class FloatingLabel {

    public static final int DURATION = 200;

    private final FloatingLabelStandar target;
    private Animator animator;
    private final SafePropertySetter.Property<Integer> y;
    private final SafePropertySetter.Property<Integer> x;
    private final SafePropertySetter.Property<Float> fontSize;
    private final SafePropertySetter.Property<Color> color;
    private Color accentColor;

    public FloatingLabel(FloatingLabelStandar target) {
        this.target = target;

        y = SafePropertySetter.animatableProperty(target.getComponent(), 0);//target.getSize().height / 2 + target.getFontMetrics(target.getFont()).getAscent() / 2);
        x = SafePropertySetter.animatableProperty(target.getComponent(), 0);//target.getSize().height / 2 + target.getFontMetrics(target.getFont()).getAscent() / 2);
        fontSize = SafePropertySetter.animatableProperty(target.getComponent(), target.getFont().getSize2D());
        color = SafePropertySetter.animatableProperty(target.getComponent(), Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));

        this.updateForeground();
        
        target.getComponent().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                update();
            }
        });
    }

    public void updateForeground() {
        color.setValue(Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));
    }

    public void update() {
        if (animator != null) {
            animator.stop();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            setValuesAnimated();
        } else {
            setValuesStatics();
        }
    }

    public void setAccentColor(Color accentColor) {
        this.accentColor = accentColor;
        update();
    }

    public Color getColor() {
        return color.getValue();
    }

    public Font getFont() {
        return target.getFont().deriveFont(fontSize.getValue());
    }

    public int getY() {
        return y.getValue();
    }

    public int getX() {
        return x.getValue();
    }

    public boolean isFloatingAbove() {
        return y.getValue() >= getYPositionUP();
    }

    private int getYPositionUP() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionUP = yMid - metrics.getAscent() / 2 - 7;//un poquito mas arriba del texto
        return yPositionUP;
    }

    private int getYPositionDOWN() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionDown = yMid + metrics.getAscent() / 2;//un poquito mas arriba del texto
        return yPositionDown;
    }

    public float getTargetFontSize() {
        return (target.isFocusOwner() || !target.getText().isEmpty()) ? target.getFont().getSize2D() * 0.8f : target.getFont().getSize2D();
    }

    public int getTargetYPosition() {
        return target.isFocusOwner() || !target.getText().isEmpty() ? getYPositionUP() : getYPositionDOWN();
    }

    //Si es un text field de tipo dinero y el floating va para abajo, la x se agranda para no tapar el $, sino va en 0(Estandar)
    public int getTargetXPosition() {
        if (target instanceof _MaterialTextField && ((_MaterialTextField) target).getType() == TextTypeEnum.MONEY && getTargetYPosition() == getYPositionDOWN()) {
            return _MaterialTextField.MONEY_TRASLATION;
        }
        return 0;
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

        //X position
        int targetX = getTargetXPosition();
        if (Math.abs(targetX - x.getValue()) > 0.1) {
            builder.addTarget(SafePropertySetter.getTarget(x, x.getValue(), targetX));
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

        //X position
        x.setValue(getTargetXPosition());

        //color, varia entre el color de accent y el de Opacity_Mask
        color.setValue(getTargetColor());
    }

}
