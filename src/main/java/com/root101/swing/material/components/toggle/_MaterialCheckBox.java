package com.root101.swing.material.components.toggle;

import com.root101.swing.util.interfaces.MaterialComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialCheckBox extends _MaterialToggleButton implements MaterialComponent {

    public static MaterialToggleButton from() {
        return new _MaterialCheckBox();
    }

    public _MaterialCheckBox() {
        super(_MaterialToggleButton.Type.CHECK_BOX);
        this.setText("Check Box");
    }

}
