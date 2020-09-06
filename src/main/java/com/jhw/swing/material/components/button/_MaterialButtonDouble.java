package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel.prepared._MaterialPanelComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonDouble extends _MaterialPanelComponent {

    public _MaterialButtonDouble() {
        super(0);
        initComponents();
        personalize();
    }

    private void initComponents() {
        buttonLeft = new com.jhw.swing.material.components.button._MaterialButton();
        buttonRight = new com.jhw.swing.material.components.button._MaterialButton();

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

        setComponent(hlc.build());
    }

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.button._MaterialButton buttonLeft;
    private com.jhw.swing.material.components.button._MaterialButton buttonRight;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        buttonLeft.setType(_MaterialButton.Type.FLAT);
        buttonLeft.setText("");
        buttonLeft.setIcon(MaterialIcons.KEYBOARD_ARROW_LEFT);
        buttonLeft.setAccentColorFadeInto(MaterialColors.GREY_200);
        buttonLeft.setRippleColor(MaterialColors.GREY_300);

        buttonRight.setType(_MaterialButton.Type.FLAT);
        buttonRight.setText("");
        buttonRight.setIcon(MaterialIcons.KEYBOARD_ARROW_RIGHT);
        buttonRight.setAccentColorFadeInto(MaterialColors.GREY_200);
        buttonRight.setRippleColor(MaterialColors.GREY_300);
    }

    public _MaterialButton getButtonLeft() {
        return buttonLeft;
    }

    public _MaterialButton getButtonRight() {
        return buttonRight;
    }

}
