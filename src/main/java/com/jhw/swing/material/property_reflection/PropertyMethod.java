/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.property_reflection;

import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.effects.RippleEffect;
import java.awt.Color;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PropertyMethod {

    private static final Map<String, Method> MAP = new HashMap<>();

    public static Map<String, Method> MAP() {//devuelve una copia, nunca el original
        return new HashMap<>(MAP);
    }

    public static String PAINT_RIPPLE_KEY;
    public static Method PAINT_RIPPLE_METHOD;
    public static String RIPPLE_COLOR_KEY;
    public static Method RIPPLE_COLOR_METHOD;
    
    public static String ICON_KEY;
    public static Method ICON_METHOD;

    static {
        try {
            PAINT_RIPPLE_KEY = "paint-ripple";
            PAINT_RIPPLE_METHOD = RippleEffect.class.getMethod("setPaintRipple", boolean.class);

            RIPPLE_COLOR_KEY = "ripple-color";
            RIPPLE_COLOR_METHOD = RippleEffect.class.getMethod("setRippleColor", Color.class);
            
            ICON_KEY = "icon";
            ICON_METHOD = Iconable.class.getMethod("setIcon", Icon.class);
        } catch (Exception e) {
            System.out.println("Error inicializando metodos");
        }
        MAP.put(PAINT_RIPPLE_KEY, PAINT_RIPPLE_METHOD);
        MAP.put(RIPPLE_COLOR_KEY, RIPPLE_COLOR_METHOD);
        MAP.put(ICON_KEY, ICON_METHOD);
    }

}
