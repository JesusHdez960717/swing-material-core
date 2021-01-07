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
package com.root101.swing.material.components.button;

import com.root101.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.root101.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.root101.swing.material.components.container.panel._MaterialPanelComponent;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialButtonDouble extends _MaterialPanelComponent {

    public static _MaterialButtonDouble from() {
        return new _MaterialButtonDouble();
    }

    public _MaterialButtonDouble() {
        super(0);
        initComponents();
        personalize();
    }

    private void initComponents() {
        buttonLeft = MaterialButtonsFactory.buildFlat();
        buttonRight = MaterialButtonsFactory.buildFlat();

        this.setBackground(new java.awt.Color(204, 204, 204));
        this.setBorderRadius(2);
        this.setPreferredSize(new java.awt.Dimension(120, 35));

        buttonLeft.setBackground(new java.awt.Color(255, 255, 255));
        buttonLeft.setBorderRadius(2);

        buttonRight.setBackground(new java.awt.Color(255, 255, 255));
        buttonRight.setBorderRadius(2);

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder((int) buttonLeft.getPreferredSize().getHeight());
        hlc.add(HorizontalLayoutComponent.builder(buttonLeft).gapRight(1).build());
        hlc.add(HorizontalLayoutComponent.builder(buttonRight).gapLeft(1).build());

        add(hlc.build());
    }

    // Variables declaration - do not modify//:variables
    private MaterialButton buttonLeft;
    private MaterialButton buttonRight;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        buttonLeft.setAccentColorFadeInto(MaterialColors.GREY_200);
        buttonLeft.setRippleColor(MaterialColors.GREY_300);
        buttonLeft.setText("");
        buttonLeft.setIcon(MaterialIcons.KEYBOARD_ARROW_LEFT);

        buttonRight.setAccentColorFadeInto(MaterialColors.GREY_200);
        buttonRight.setRippleColor(MaterialColors.GREY_300);
        buttonRight.setText("");
        buttonRight.setIcon(MaterialIcons.KEYBOARD_ARROW_RIGHT);
    }

    public MaterialButton getButtonLeft() {
        return buttonLeft;
    }

    public MaterialButton getButtonRight() {
        return buttonRight;
    }

}
