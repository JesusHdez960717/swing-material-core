package com.jhw.swing.material.effects;

import com.jhw.swing.material.effects.MaterialLineBorder;
import com.jhw.swing.material.effects.DefaultMaterialLineBorder;
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
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;
import javax.swing.JComponent;

public class DefaultBorderDinamic<T extends JComponent & BorderDinamic> implements BorderDinamic {

    public static final int DURATION = 200;

    private Animator animator;
    private final SafePropertySetter.Property<Float> fontSize;
    private final SafePropertySetter.Property<Color> color;
    private final SafePropertySetter.Property<Float> thickness;

    private Color accentColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_ACCENT);

    private String title;

    private final T target;

    public DefaultBorderDinamic(T target) {
        this.target = target;

        fontSize = SafePropertySetter.animatableProperty(this.target, target.getFont().getSize2D());
        color = SafePropertySetter.animatableProperty(this.target, Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));
        thickness = SafePropertySetter.animatableProperty(this.target, 1f);
    }

    @Override
    public JComponent getFocusableComponent() {
        return target.getFocusableComponent();
    }

    @Override
    public JComponent getBordeableComponent() {
        return target.getBordeableComponent();
    }

    @Override
    public String getBorderTitle() {
        return title;
    }

    @Override
    public void setBorderTitle(String title) {
        this.title = title;
        this.setTitledBorder(title);
    }

    @Override
    public Color getBorderAccentColor() {
        return accentColor;
    }

    @Override
    public void setBorderAccentColor(Color accentColor) {
        this.accentColor = accentColor;
        update();
    }

    private void setTitledBorder(String text) {
        getBordeableComponent().setBorder(new TitledBorder(text));
        TitledBorder titled = (TitledBorder) getBordeableComponent().getBorder();
        titled.setTitleColor(Utils.applyAlphaMask(getBordeableComponent().getForeground(), HINT_OPACITY_MASK));
        titled.setBorder(DefaultMaterialLineBorder.builder().build());
        update();
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
        return getBordeableComponent().getFont().deriveFont(fontSize.getValue());
    }

    public float getTargetFontSize() {
        return getFocusableComponent().isFocusOwner() ? getBordeableComponent().getFont().getSize2D() * 1.15f : getBordeableComponent().getFont().getSize2D();
    }

    private Color getTargetColor() {
        return getFocusableComponent().isFocusOwner() ? getBorderAccentColor() : Utils.applyAlphaMask(getBordeableComponent().getForeground(), HINT_OPACITY_MASK);
    }

    public float getTargetThickness() {
        return !getFocusableComponent().isFocusOwner() ? 1f : 2f;
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

        //color, varia entre el color de accent y el de Opacity_Mask
        Color targetColor = getTargetColor();
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));

        }

        //color, varia entre el color de accent y el de Opacity_Mask
        float targetTh = getTargetThickness();
        if (targetTh != getThickness()) {
            builder.addTarget(SafePropertySetter.getTarget(thickness, thickness.getValue(), targetTh));
        }

        //este es el que en realidad pinta
        builder.addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Object>() {
            @Override
            public void setValue(Object value) {
                if (value != null) {
                    repaintComponent();
                }
            }
        }, 0, 0));

        animator = builder.build();
        animator.start();
    }

    private void repaintComponent() {
        TitledBorder titled = (TitledBorder) getBordeableComponent().getBorder();
        MaterialLineBorder line = (DefaultMaterialLineBorder) titled.getBorder();

        line.setBorderThickness(thickness.getValue());

        titled.setTitleColor(color.getValue());
        line.setBorderColor(color.getValue());

        titled.setTitleFont(getFont());
    }

    private void setValuesStatics() {
        //Font size, si no hay letra es tamaño real, si esta arriba es el 80% del tamaño(1 poquito mas chiquito)
        fontSize.setValue(getTargetFontSize());

        //color, varia entre el color de accent y el de Opacity_Mask
        color.setValue(getTargetColor());

        //grosor, varia en dependencia del focus
        thickness.setValue(getTargetThickness());

        repaintComponent();
    }

}
