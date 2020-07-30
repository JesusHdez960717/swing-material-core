package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.GroupLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class HorizontalLayoutContainer extends _PanelTransparent {

    private HorizontalLayoutContainer(int prefHeight, ArrayList<HorizontalLayoutComponent> components) {
        initComponents(prefHeight, components);
    }

    private void initComponents(int prefHeight, ArrayList<HorizontalLayoutComponent> components) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        GroupLayout.ParallelGroup horizParallelGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup seqGroup = layout.createSequentialGroup();
        for (HorizontalLayoutComponent c : components) {
            seqGroup.addGap(c.getGapLeft())
                    .addComponent(c.getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, c.getWidth(), Short.MAX_VALUE)
                    .addGap(c.getGapRight());
        }

        layout.setHorizontalGroup(
                horizParallelGroup
                        .addGroup(seqGroup)
        );

        GroupLayout.ParallelGroup vertParallelGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        for (HorizontalLayoutComponent c : components) {
            vertParallelGroup
                    .addComponent(c.getComponent(), javax.swing.GroupLayout.DEFAULT_SIZE, prefHeight, Short.MAX_VALUE);
        }
        layout.setVerticalGroup(
                vertParallelGroup
        );
    }

    public static builder builder() {
        return new builder();
    }

    public static builder builder(int prefHeight) {
        return new builder(prefHeight);
    }

    public static class builder {

        private ArrayList<HorizontalLayoutComponent> components = new ArrayList<>();
        private int prefHeight = 65;

        public builder() {
        }

        public builder(int prefHeight) {
            this.prefHeight = prefHeight;
        }

        public builder add(Component comp) {
            components.add(HorizontalLayoutComponent.builder(comp).build());
            return this;
        }

        public builder add(HorizontalLayoutComponent component) {
            components.add(component);
            return this;
        }

        public HorizontalLayoutContainer build() {
            return new HorizontalLayoutContainer(prefHeight, components);
        }
    }

}
