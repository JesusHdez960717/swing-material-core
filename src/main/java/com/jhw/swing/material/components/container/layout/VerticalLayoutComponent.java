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
public class VerticalLayoutComponent {

    private Component component;
    private int height;
    private int gapTop;
    private int gapDown;

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
