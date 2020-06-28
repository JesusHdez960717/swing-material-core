package com.jhw.swing.material.components.container.layout;

import com.clean.core.exceptions.ValidationException;
import com.clean.core.utils.validation.Validable;
import com.clean.core.utils.validation.ValidationResult;
import java.awt.Component;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Getter
public class VerticalLayoutComponent implements Validable {

    @NotNull
    private Component component;

    @PositiveOrZero
    private int height;

    @PositiveOrZero
    private int gapTop;

    @PositiveOrZero
    private int gapDown;

    public VerticalLayoutComponent(Component component, int height, int gapTop, int gapDown) {
        this.component = component;
        this.height = height;
        this.gapTop = gapTop;
        this.gapDown = gapDown;
        validate();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public static builder builder(Component component) {
        return new builder(component);
    }

    public static class builder {

        private final Component component;
        private int height;
        private int gapTop;
        private int gapDown;

        private builder(Component component) {
            this.component = component;
            this.height = (int) this.component.getPreferredSize().getHeight();
        }

        public builder height(int height) {
            this.height = height;
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
            return new VerticalLayoutComponent(component, height, gapTop, gapDown);
        }
    }
}
