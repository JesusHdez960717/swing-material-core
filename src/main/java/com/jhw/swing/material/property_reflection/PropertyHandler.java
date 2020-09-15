/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.property_reflection;

import com.jhw.utils.others.Pair;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PropertyHandler {

    public static void handleProperties(Object obj) {
        try {
            if (!(obj instanceof JComponent)) {
                return;
            }
            JComponent component = (JComponent) obj;
            String fullName = component.getName();
            if (fullName == null || fullName.isEmpty()) {
                return;
            }

            //set the name to the original without properties
            String nameOriginal = MineName.cleanName(fullName);
            if (nameOriginal != null && !nameOriginal.equals(component.getName())) {
                component.setName(nameOriginal);
            }
            for (String propertyAll : MineName.propertysFromName(fullName)) {
                try {
                    setUpProperty(component, propertyAll);
                } catch (Exception e) {
                    System.out.println("Error poniendo la propiedad: " + propertyAll + ". Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setUpProperty(JComponent component, String propertyAll) throws Exception {
        Pair<String> propSplit = MineName.property_value(propertyAll);
        Method method = PropertyMethod.MAP().get(propSplit.getA());
        method.invoke(component, MineName.mineValues(propSplit.getB()));
    }
}
