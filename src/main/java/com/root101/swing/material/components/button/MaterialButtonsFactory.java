/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.button;

import com.root101.swing.material.components.popup.MaterialPopupFactory;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialButtonsFactory {

    public static MaterialButton buildButton() {
        return _MaterialButton.from();
    }

    public static _MaterialButtonDouble buildDouble() {
        return _MaterialButtonDouble.from();
    }

    public static MaterialButton buildFlat() {
        MaterialButton btn = buildButton();
        btn.setType(_MaterialButton.Type.FLAT);
        btn.setBorderRadius(0);
        return btn;
    }

    //-----------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTranspRotate() {
        return _MaterialButtonIconTranspRotate.from();
    }

    //----------------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTransparent() {
        return _MaterialButtonIconTransparent.from();
    }

    public static MaterialButtonIcon buildIconTransparent(ImageIcon icon) {
        MaterialButtonIcon btn = MaterialSwingInjector.getImplementation(_MaterialButtonIconTransparent.class);
        int w = (int) (1.5f * icon.getIconWidth());
        btn.setMaximumSize(new Dimension(w, w));
        btn.setIcon(icon);
        return btn;
    }

    //----------------PopupCircular----------------
    /**
     * Preferiblemente usar directo con la lista de acciones que crea popup
     * redondo chulo.
     *
     * @return
     * @deprecated
     */
    @Deprecated
    public static MaterialButton buildPopup() {
        return _MaterialButtonPopup.from();
    }

    public static MaterialButton buildPopup(List<Action> actions) {
        MaterialButton btn = buildPopup();
        btn.setComponentPopupMenu(MaterialPopupFactory.buildCircular(actions));
        return btn;
    }
    //----------------------------------------

    public static JButton buildHyperlink() {
        return _MaterialButtonHiperlink.from();
    }

    public static MaterialButton buildRound() {
        return _MaterialIconButtonRound.from();
    }

}
