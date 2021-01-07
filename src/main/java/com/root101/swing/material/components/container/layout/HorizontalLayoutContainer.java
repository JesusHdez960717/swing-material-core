package com.root101.swing.material.components.container.layout;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.util.ArrayList;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class HorizontalLayoutContainer extends _PanelTransparent {

    private final MigLayout layout = new MigLayout(
            new LC().align("center", "center").insetsAll("0").gridGap("0", "0"),
            new AC(),
            new AC().fill().grow()
    );

    private HorizontalLayoutContainer(int prefHeight, ArrayList<HorizontalLayoutComponent> components) {
        initComponents(prefHeight, components);
        this.setPreferredSize(layout.preferredLayoutSize(this));
        this.setSize(layout.preferredLayoutSize(this));
    }

    private void initComponents(int prefHeight, ArrayList<HorizontalLayoutComponent> components) {
        this.setLayout(layout);
        for (HorizontalLayoutComponent component : components) {
            String constr = getConst(component, prefHeight);
            this.add(component.getComponent(), constr);
        }
    }

    private String getConst(HorizontalLayoutComponent component, int h) {
        String constr = "";
        constr += " ,gap " + component.getGapLeft() + " " + component.getGapRight() + " 0 0";
        constr += " ,w " + component.getWidth() + ", h " + h;
        if (component.isResize()) {
            constr += " , pushx, grow";
        }
        return constr;
    }

    public static builder builder() {
        return new builder();
    }

    public static builder builder(int prefHeight) {
        return new builder(prefHeight);
    }

    public static class builder {

        private final ArrayList<HorizontalLayoutComponent> components = new ArrayList<>();
        private int prefHeight = 65;

        public builder() {
        }

        public builder(int prefHeight) {
            this.prefHeight = prefHeight;
        }

        public builder add(Component comp) {
            return add(comp, true);
        }

        public builder add(Component comp, boolean resize) {
            components.add(HorizontalLayoutComponent.builder(comp).resize(resize).build());
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
