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
public class HorizontalLayoutComponent implements Validable {

    @NotNull
    private Component component;

    @PositiveOrZero
    private int width;

    @PositiveOrZero
    private int gapLeft;

    @PositiveOrZero
    private int gapRight;

    private boolean resize;

    public HorizontalLayoutComponent(Component component, int width, int gapLeft, int gapRight, boolean resize) {
        this.component = component;
        this.width = width;
        this.gapLeft = gapLeft;
        this.gapRight = gapRight;
        this.resize = resize;
        validate();
    }

    public Component getComponent() {
        return component;
    }

    public boolean isResize() {
        return resize;
    }

    public int getWidth() {
        return width;
    }

    public int getGapLeft() {
        return gapLeft;
    }

    public int getGapRight() {
        return gapRight;
    }

    public static builder builder(Component component) {
        return new builder(component);
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public static class builder {

        private final Component component;
        private int width;
        private int gapLeft;
        private int gapRight;
        private boolean resize = true;

        private builder(Component component) {
            this.component = component;
            this.width = (int) this.component.getPreferredSize().getWidth();
        }

        public builder width(int width) {
            this.width = width;
            return this;
        }

        public builder resize(boolean resize) {
            this.resize = resize;
            return this;
        }

        public builder gapLeft(int gapLeft) {
            this.gapLeft = gapLeft;
            return this;
        }

        public builder gapRight(int gapRight) {
            this.gapRight = gapRight;
            return this;
        }

        public HorizontalLayoutComponent build() {
            return new HorizontalLayoutComponent(component, width, gapLeft, gapRight, resize);
        }
    }
}
