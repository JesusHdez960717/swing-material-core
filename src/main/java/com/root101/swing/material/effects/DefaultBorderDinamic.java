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

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.util.SafePropertySetter;
import com.root101.swing.util.Utils;
import javax.swing.border.TitledBorder;
import static com.root101.swing.material.standards.Utils.HINT_OPACITY_MASK;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class DefaultBorderDinamic<T extends JComponent & BorderDinamic> implements BorderDinamic, PropertyChangeListener {

    private final FocusListener focusListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            update();
        }

        @Override
        public void focusLost(FocusEvent e) {
            update();
        }
    };
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

        this.target.addPropertyChangeListener(this);
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
        this.setTitledBorder();
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

    private void setTitledBorder() {
        if (title.trim().isEmpty()) {
            return;
        }
        getBordeableComponent().setBorder(new TitledBorder(title));
        TitledBorder titled = (TitledBorder) getBordeableComponent().getBorder();
        titled.setBorder(DefaultMaterialLineBorder.builder().build());
        repaintComponent();//este es el que le da la forma con los valores que son

        getFocusableComponent().removeFocusListener(focusListener);
        getFocusableComponent().addFocusListener(focusListener);
    }

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
        if (title.isEmpty()) {
            return;
        }
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "font":
                update();
                break;
            case "foreground":
                update();
                break;
        }
    }

}
