/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.button;

import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button._MaterialButtonPopup;
import com.jhw.swing.material.components.popup.MaterialPopupFactory;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialIcons;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _buttonReportes extends _MaterialButtonPopup {

    public static MaterialButton from() {
        return MaterialSwingInjector.getImplementation(_buttonReportes.class);
    }

    /**
     * Usar _buttonReportes.from() para proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    public _buttonReportes() {
        this.setText("Reportes");
        this.setIconTextGap(10);
        this.setIcon(MaterialIcons.ASSESSMENT);
        this.setToolTipText("Ver reportes relacionados");
    }

}
