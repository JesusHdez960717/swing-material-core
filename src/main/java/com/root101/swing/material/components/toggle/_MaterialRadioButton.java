package com.root101.swing.material.components.toggle;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialRadioButton extends _MaterialToggleButton {

    public static MaterialToggleButton from() {
        return new _MaterialRadioButton();
    }

    public _MaterialRadioButton() {
        super(_MaterialToggleButton.Type.RADIO_BUTTON);
        this.setText("Radio");
    }

}
