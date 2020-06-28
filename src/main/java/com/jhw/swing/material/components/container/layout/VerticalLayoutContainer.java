package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.GroupLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class VerticalLayoutContainer extends _PanelTransparent {

    private VerticalLayoutContainer(int prefWidth, ArrayList<VerticalLayoutComponent> components) {
        initComponents(prefWidth, components);
    }

    private void initComponents(int prefWidth, ArrayList<VerticalLayoutComponent> components) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        GroupLayout.ParallelGroup horizParallelGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        for (VerticalLayoutComponent c : components) {
            horizParallelGroup.addComponent(c.getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, prefWidth, Short.MAX_VALUE);
        }
        layout.setHorizontalGroup(horizParallelGroup);

        GroupLayout.ParallelGroup vertParallelGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup seqGroup = layout.createSequentialGroup();
        for (VerticalLayoutComponent c : components) {
            seqGroup.addGap(c.getGapTop())
                    .addComponent(c.getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, c.getHeight(), Short.MAX_VALUE)
                    .addGap(c.getGapDown());
        }
        layout.setVerticalGroup(
                vertParallelGroup
                        .addGroup(seqGroup)
        );
    }

    public static builder builder() {
        return new builder();
    }

    public static builder builder(int prefWidth) {
        return new builder(prefWidth);
    }

    public static class builder {

        private ArrayList<VerticalLayoutComponent> components = new ArrayList<>();
        private int prefWidth = 350;

        public builder() {
        }

        public builder(int prefWidth) {
            this.prefWidth = prefWidth;
        }

        public builder add(Component comp) {
            components.add(VerticalLayoutComponent.builder(comp).build());
            return this;
        }

        public builder add(VerticalLayoutComponent comp) {
            components.add(comp);
            return this;
        }

        public VerticalLayoutContainer build() {
            return new VerticalLayoutContainer(prefWidth, components);
        }
    }

}
