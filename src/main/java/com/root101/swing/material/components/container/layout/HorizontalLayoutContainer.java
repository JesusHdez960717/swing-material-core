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
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
