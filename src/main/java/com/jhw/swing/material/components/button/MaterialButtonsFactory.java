/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.button.prepared.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialButtonsFactory {

    public static JButton buildButton() {
        return _MaterialButton.from();
    }

    public static _MaterialButtonDouble buildDouble() {
        return _MaterialButtonDouble.from();
    }

    public static JButton buildFlat() {
        _MaterialButton btn = _MaterialButton.from();
        btn.setType(_MaterialButton.Type.FLAT);
        btn.setBorderRadius(0);
        return btn;
    }

    //-----------Icon Transparent----------------
    public static JButton buildIconTranspRotate() {
        return _MaterialButtonIconTranspRotate.from();
    }

    //----------------Icon Transparent----------------
    public static JButton buildIconTransparent() {
        return _MaterialButtonIconTransparent.from();
    }

    public static JButton buildIconTransparent(ImageIcon icon) {
        return _MaterialButtonIconTransparent.from(icon);
    }

    //----------------Popup----------------
    public static JButton buildPopup() {
        return _MaterialButtonPopup.from();
    }

    public static JButton buildPopup(JPopupMenu menu) {
        return _MaterialButtonPopup.from(menu);
    }
    //----------------------------------------

    public static JButton buildHyperlink() {
        return _MaterialButtonHiperlink.from();
    }

    public static JButton buildRound() {
        return _MaterialIconButtonRound.from();
    }

    public static JButton buildView() {
        return _buttonView.from();
    }

    public static JButton buildAddEdit() {
        return _buttonAddEdit.from();
    }
}
