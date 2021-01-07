/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.button;

import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.effects.ColorFadeInto;
import com.root101.swing.material.effects.ElevationEffect;
import com.root101.swing.material.effects.Iconable;
import com.root101.swing.material.effects.MaterialLineBorder;
import com.root101.swing.material.effects.RippleEffect;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialInputPopupIcon extends _PanelTransparent implements Iconable, RippleEffect, ColorFadeInto, ElevationEffect, MaterialLineBorder {

    public void setText(String text) {
        getButton().setText(text);
    }

    public abstract void setActions(List<Action> action);

    public abstract MaterialButton getButton();
}
