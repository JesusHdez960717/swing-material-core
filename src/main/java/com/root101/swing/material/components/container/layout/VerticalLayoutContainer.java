/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.container.layout;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
