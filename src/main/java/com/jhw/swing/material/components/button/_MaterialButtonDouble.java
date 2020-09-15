package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
