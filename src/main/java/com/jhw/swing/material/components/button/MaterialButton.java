/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.button;

import com.jhw.swing.material.effects.ColorFadeInto;
import com.jhw.swing.material.effects.ElevationEffect;
import com.jhw.swing.material.effects.MaterialLineBorder;
import com.jhw.swing.util.MouseAdapterInfo;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialButton extends MaterialButtonIcon implements ColorFadeInto, MouseAdapterInfo, ElevationEffect, MaterialLineBorder {

    public abstract Type getType();

    public abstract void setType(Type type);

    /**
     * Button types.
     */
    public enum Type {

        /**
         * A default button.
         */
        DEFAULT,
        /**
         * A raised button. Raised buttons have a shadow even if they are not
         * focused.
         */
        RAISED,
        /**
         * A flat button. Flat buttons don't have shadows and are typically
         * transparent.
         */
        FLAT
    }
}
