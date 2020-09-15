package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class VerticalLayoutContainer extends _PanelTransparent {

    private final MigLayout layout = new MigLayout(
            new LC().align("center", "center").insetsAll("0").gridGap("0", "0"),
            new AC().fill().grow(),
            new AC()
    );

    private VerticalLayoutContainer(int prefWidth, ArrayList<VerticalLayoutComponent> components) {
        initComponents(prefWidth, components);
        this.setPreferredSize(layout.preferredLayoutSize(this));
        this.setSize(layout.preferredLayoutSize(this));
    }

    private void initComponents(int prefWidth, ArrayList<VerticalLayoutComponent> components) {
        this.setLayout(layout);
        for (VerticalLayoutComponent component : components) {
            String constr = getConst(component, prefWidth);
            this.add(component.getComponent(), constr);
        }
    }

    private String getConst(VerticalLayoutComponent component, int w) {
        String constr = "newline";
        constr += " ,gap 0 0 " + component.getGapTop() + " " + component.getGapDown();
        constr += " ,h " + component.getHeight() + ", w " + w;
        if (component.isResize()) {
            constr += " , pushy, grow";
        }
        return constr;
    }

    public static builder builder() {
        return new builder();
    }

    public static builder builder(int prefWidth) {
        return new builder(prefWidth);
    }

    public static class builder {

        private final ArrayList<VerticalLayoutComponent> components = new ArrayList<>();
        private int prefWidth = 400;

        public builder() {
        }

        public builder(int prefWidth) {
            this.prefWidth = prefWidth;
        }

        public builder add(Component comp) {
            return add(comp, false);
        }

        public builder add(Component comp, boolean resize) {
            components.add(VerticalLayoutComponent.builder(comp).resize(resize).build());
            return this;
        }

        public builder add(VerticalLayoutComponent comp) {
            components.add(comp);
            return this;
        }

        public List<VerticalLayoutComponent> components() {
            return components;
        }

        public VerticalLayoutContainer build() {
            return new VerticalLayoutContainer(prefWidth, components);
        }
    }

}
