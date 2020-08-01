package com.jhw.swing.material.components.container.layout;

import com.clean.core.exceptions.ValidationException;
import com.clean.core.utils.validation.Validable;
import com.clean.core.utils.validation.ValidationResult;
import java.awt.Component;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class VerticalLayoutComponent implements Validable {

    @NotNull
    private Component component;

    @PositiveOrZero
    private int height;

    @PositiveOrZero
    private int gapTop;

    @PositiveOrZero
    private int gapDown;

    private boolean resize;

    public VerticalLayoutComponent(Component component, int height, int gapTop, int gapDown, boolean resize) {
        this.component = component;
        this.height = height;
        this.gapTop = gapTop;
        this.gapDown = gapDown;
        this.resize = resize;
        validate();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public Component getComponent() {
        return component;
    }

    public boolean isResize() {
        return resize;
    }

    public int getHeight() {
        return height;
    }

    public int getGapTop() {
        return gapTop;
    }

    public int getGapDown() {
        return gapDown;
    }

    public static builder builder(Component component) {
        return new builder(component);
    }

    public static class builder {

        private final Component component;
        private int height;
        private int gapTop;
        private int gapDown;
        private boolean resize;

        private builder(Component component) {
            this.component = component;
            this.height = (int) this.component.getPreferredSize().getHeight();
        }

        public builder height(int height) {
            this.height = height;
            return this;
        }

        public builder resize(boolean resize) {
            this.resize = resize;
            return this;
        }

        public builder gapTop(int gapTop) {
            this.gapTop = gapTop;
            return this;
        }

        public builder gapDown(int gapDown) {
            this.gapDown = gapDown;
            return this;
        }

        public VerticalLayoutComponent build() {
            return new VerticalLayoutComponent(component, height, gapTop, gapDown, resize);
        }
    }
}
