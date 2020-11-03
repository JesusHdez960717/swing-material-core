/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Wrapper para el java.time.Month para poder mostrar el toString personalizado
 * y no en inglés como el Enum.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _Month implements Comparable<_Month> {

    public static _Month from(int id) {
        return new _Month(id);
    }

    public final Month month;

    public _Month(int id) {
        this.month = Month.of(id);
    }

    @Override
    public String toString() {
        String name = month.getDisplayName(TextStyle.FULL, Locale.getDefault());//cojo el nombre

        //el formato del nombre
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length());//primera letra mayuscula
        //name = name.toUpperCase();//all mayuscula
        //name = name.toLowerCase();//all minuscula, no hace falta, por defecto all in minusculas

        //el numero del mes
        //name = month.getValue() + " - " + name;// 1 - Enero
        name += " (" + month.getValue() + ")";
        return name;
    }

    @Override
    public int compareTo(_Month o) {
        return month.compareTo(o.month);
    }

    @Override
    public int hashCode() {
        return month.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Month) {
            return month.equals((Month) obj);
        }
        if (!(obj instanceof _Month)) {
            return false;
        }
        return this.compareTo((_Month) obj) == 0;
    }

}
