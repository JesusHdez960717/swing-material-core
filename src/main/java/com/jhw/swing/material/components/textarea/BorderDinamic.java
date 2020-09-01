package com.jhw.swing.material.components.textarea;

import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.Utils;
import javax.swing.border.TitledBorder;

public class BorderDinamic {

    public static final int DURATION = 200;

    private final _MaterialTextArea target;
    private Animator animator;
    private final SafePropertySetter.Property<Float> fontSize;
    private final SafePropertySetter.Property<Color> color;
    private final SafePropertySetter.Property<Float> thickness;

    public BorderDinamic(_MaterialTextArea target) {
        this.target = target;

        fontSize = SafePropertySetter.animatableProperty(target, target.getFont().getSize2D());
        color = SafePropertySetter.animatableProperty(target, Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));
        thickness = SafePropertySetter.animatableProperty(target, 1f);

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

    public Color getColor() {
        return color.getValue();
    }

    public float getThickness() {
        return thickness.getValue();
    }

    public Font getFont() {
        return target.getFont().deriveFont(fontSize.getValue());
    }

    public float getTargetFontSize() {
        return !target.getTextArea().isFocusOwner() ? target.getTextArea().getFont().getSize2D() * 0.8f : target.getTextArea().getFont().getSize2D();
    }

    private Color getTargetColor() {
        return target.getTextArea().isFocusOwner() ? target.getAccentColor() : Utils.applyAlphaMask(target.getTextArea().getForeground(), HINT_OPACITY_MASK);
    }

    public float getTargetThickness() {
        return !target.getTextArea().isFocusOwner() ? 1f : 2f;
    }

    private void setValuesAnimated() {
        Animator.Builder builder = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        //Font size, si no hay letra es tamaño real, si esta arriba es el 80% del tamaño(1 poquito mas chiquito)
        float targetFontSize = getTargetFontSize();
        if (fontSize.getValue() != targetFontSize) {
            builder.addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Float>() {
                @Override
                public void setValue(Float value) {
                    if (value != null) {
                        fontSize.setValue(value);//update the target

                        TitledBorder titled = (TitledBorder) target.getScrollPane().getBorder();
                        titled.setTitleFont(getFont());
                    }
                }
            }, fontSize.getValue(), targetFontSize));
        }

        //color, varia entre el color de accent y el de Opacity_Mask
        Color targetColor = getTargetColor();
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Color>() {
                @Override
                public void setValue(Color value) {
                    if (value != null) {
                        color.setValue(value);//update the target

                        TitledBorder titled = (TitledBorder) target.getScrollPane().getBorder();
                        titled.setTitleColor(value);
                        MaterialLineBorder line = (MaterialLineBorder) titled.getBorder();
                        line.setColor(value);
                    }
                }
            }, color.getValue(), targetColor));

        }

        //color, varia entre el color de accent y el de Opacity_Mask
        float targetTh = getTargetThickness();
        if (targetTh != getThickness()) {
            builder.addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Float>() {
                @Override
                public void setValue(Float value) {
                    if (value != null) {
                        thickness.setValue(value);//update the target

                        TitledBorder titled = (TitledBorder) target.getScrollPane().getBorder();
                        MaterialLineBorder line = (MaterialLineBorder) titled.getBorder();
                        line.setThickkness(value);
                    }
                }
            }, thickness.getValue(), targetTh));
        }

        //este es el que en realidad pinta
        builder.addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Object>() {
            @Override
            public void setValue(Object value) {
                if (value != null) {
                    target.repaint();
                }
            }
        }, 0, 0));
        
        animator = builder.build();
        animator.start();
    }

    private void setValuesStatics() {
        //Font size, si no hay letra es tamaño real, si esta arriba es el 80% del tamaño(1 poquito mas chiquito)
        fontSize.setValue(getTargetFontSize());

        //color, varia entre el color de accent y el de Opacity_Mask
        color.setValue(getTargetColor());

        //color, varia entre el color de accent y el de Opacity_Mask
        thickness.setValue(thickness.getValue());
    }

}
