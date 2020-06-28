package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.layout.*;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.utils.others.Pair;
import java.awt.Component;
import java.awt.Dimension;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PairLayoutContainer extends _PanelTransparent {

    private PairLayoutContainer(int prefHeight, Pair<HorizontalLayoutComponent> pair) {
        initComponents(prefHeight, pair);
    }

    private void initComponents(int prefHeight, Pair<HorizontalLayoutComponent> pair) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pair.getA().getComponent(), pair.getA().getWidth(), pair.getA().getWidth(), pair.getA().getWidth())
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pair.getB().getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, pair.getB().getWidth(), Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pair.getA().getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, prefHeight, Short.MAX_VALUE)
                        .addComponent(pair.getB().getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, prefHeight, Short.MAX_VALUE)
        );
    }

    public static builder builder() {
        return new builder();
    }

    public static builder builder(int prefHeight) {
        return new builder(prefHeight);
    }

    public static class builder {

        private Pair<HorizontalLayoutComponent> components = new Pair<>();
        private int prefHeight = 65;

        public builder() {
        }

        public builder(int prefHeight) {
            this.prefHeight = prefHeight;
        }

        public builder setA(Component comp) {
            components.setA(HorizontalLayoutComponent.builder(comp).build());
            return this;
        }

        public builder setA(HorizontalLayoutComponent component) {
            components.setA(component);
            return this;
        }

        public builder setB(Component comp) {
            components.setB(HorizontalLayoutComponent.builder(comp).build());
            return this;
        }

        public builder setB(HorizontalLayoutComponent component) {
            components.setB(component);
            return this;
        }

        public PairLayoutContainer build() {
            return new PairLayoutContainer(prefHeight, components);
        }
    }

}
