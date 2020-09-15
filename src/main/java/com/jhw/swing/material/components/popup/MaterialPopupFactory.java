/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import java.util.List;
import javax.swing.Action;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialPopupFactory {

    public static JPopupMenu buildCircular(List<Action> actions) {
        return PopupCircular.from(actions);
    }

}
