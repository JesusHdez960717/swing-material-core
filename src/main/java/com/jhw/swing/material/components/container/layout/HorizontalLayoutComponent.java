package com.jhw.swing.material.components.container.layout;

import java.awt.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Getter
@AllArgsConstructor
public class HorizontalLayoutComponent {

    private Component component;
    private int width;
    private int gapLeft;
    private int gapRight;

    public static builder builder(Component component) {
        return new builder(component);
    }

    public static class builder {

        private final Component component;
        private int width;
        private int gapLeft;
        private int gapRight;

        private builder(Component component) {
            this.component = component;
            this.width = (int) this.component.getPreferredSize().getWidth();
        }

        public builder width(int width) {
            this.width = width;
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
            return new HorizontalLayoutComponent(component, width, gapLeft, gapRight);
        }
    }
}
