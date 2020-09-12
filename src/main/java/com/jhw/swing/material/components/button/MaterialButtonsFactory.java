/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.button.prepared.*;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialButtonsFactory {

    public static MaterialButton buildButton() {
        return MaterialSwingInjector.getImplementation(_MaterialButton.class);
    }

    public static _MaterialButtonDouble buildDouble() {
        return _MaterialButtonDouble.from();
    }

    public static MaterialButton buildFlat() {
        MaterialButton btn = MaterialSwingInjector.getImplementation(_MaterialButton.class);
        btn.setType(_MaterialButton.Type.FLAT);
        btn.setBorderRadius(0);
        return btn;
    }

    //-----------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTranspRotate() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonIconTranspRotate.class);
    }

    //----------------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTransparent() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonIconTransparent.class);
    }

    public static MaterialButtonIcon buildIconTransparent(ImageIcon icon) {
        MaterialButtonIcon btn = MaterialSwingInjector.getImplementation(_MaterialButtonIconTransparent.class);
        btn.setIcon(icon);
        return btn;
    }

    //----------------Popup----------------
    public static MaterialButton buildPopup() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonPopup.class);
    }

    public static MaterialButton buildPopup(JPopupMenu menu) {
        MaterialButton btn = MaterialSwingInjector.getImplementation(_MaterialButtonPopup.class);
        btn.setComponentPopupMenu(menu);
        return btn;
    }
    //----------------------------------------

    public static JButton buildHyperlink() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonHiperlink.class);
    }

    public static MaterialButton buildRound() {
        return MaterialSwingInjector.getImplementation(_MaterialIconButtonRound.class);
    }

    public static MaterialButton buildView() {
        return MaterialSwingInjector.getImplementation(_buttonView.class);
    }

    public static MaterialButton buildAddEdit() {
        return MaterialSwingInjector.getImplementation(_buttonAddEdit.class);
    }
}
