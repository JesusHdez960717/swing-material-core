package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonDouble extends _MaterialPanelComponent {

    public static _MaterialButtonDouble from() {
        return new _MaterialButtonDouble();
    }

    private _MaterialButtonDouble() {
        super(0);
        initComponents();
        personalize();
    }

    private void initComponents() {
        buttonLeft = MaterialButtonsFactory.buildButton();
        buttonRight = MaterialButtonsFactory.buildButton();

        this.setBackground(new java.awt.Color(204, 204, 204));
        this.setBorderRadius(2);
        this.setPreferredSize(new java.awt.Dimension(120, 35));

        buttonLeft.setBackground(new java.awt.Color(255, 255, 255));
        ((_MaterialButton) buttonLeft).setBorderRadius(2);

        buttonRight.setBackground(new java.awt.Color(255, 255, 255));
        ((_MaterialButton) buttonRight).setBorderRadius(2);

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder((int) buttonLeft.getPreferredSize().getHeight());
        hlc.add(HorizontalLayoutComponent.builder(buttonLeft).gapRight(1).build());
        hlc.add(HorizontalLayoutComponent.builder(buttonRight).gapLeft(1).build());

        add(hlc.build());
    }

    // Variables declaration - do not modify//:variables
    private JButton buttonLeft;
    private JButton buttonRight;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        ((_MaterialButton) buttonLeft).setType(_MaterialButton.Type.FLAT);
        ((_MaterialButton) buttonLeft).setAccentColorFadeInto(MaterialColors.GREY_200);
        ((_MaterialButton) buttonLeft).setRippleColor(MaterialColors.GREY_300);
        buttonLeft.setText("");
        buttonLeft.setIcon(MaterialIcons.KEYBOARD_ARROW_LEFT);

        ((_MaterialButton) buttonRight).setType(_MaterialButton.Type.FLAT);
        ((_MaterialButton) buttonRight).setAccentColorFadeInto(MaterialColors.GREY_200);
        ((_MaterialButton) buttonRight).setRippleColor(MaterialColors.GREY_300);
        buttonRight.setText("");
        buttonRight.setIcon(MaterialIcons.KEYBOARD_ARROW_RIGHT);
    }

    public JButton getButtonLeft() {
        return buttonLeft;
    }

    public JButton getButtonRight() {
        return buttonRight;
    }

}
