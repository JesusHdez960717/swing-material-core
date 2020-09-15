/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.property_reflection;

import com.jhw.utils.others.Pair;
import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MineName {

    public static final String START = "{";
    public static final String END = "}";
    public static final String SEPARATOR_PROPERTIES = ";";
    public static final String SEPARATOR_PROPERTY_VALUE = ":";
    public static final String SEPARATOR_PROPERTY_VALUE_ARRAY = ",";
    public static final String VALUE_START = "(";
    public static final String VALUE_END = ")";
    public static final String VALUE_SEPARATON = "-";

    public static String cleanName(String fullName) {
        if (fullName == null) {
            return "";
        }
        fullName = fullName.trim();
        int index = fullName.indexOf(START);
        if (index < 0) {
            return fullName;
        }
        return fullName.substring(0, fullName.indexOf(START));
    }

    public static String[] propertysFromName(String fullName) {
        if (fullName == null) {
            return new String[]{};
        }
        fullName = fullName.trim();

        int indexStart = fullName.indexOf(START);
        int indexEnd = fullName.indexOf(END);
        if (indexStart < 0 || indexEnd < 0) {
            return new String[]{};
        }
        return fullName.substring(indexStart + 1, indexEnd).trim().split(SEPARATOR_PROPERTIES);
    }

    public static Pair<String> property_value(String propertyAll) {
        propertyAll = propertyAll.trim();
        String spl[] = propertyAll.split(SEPARATOR_PROPERTY_VALUE);
        return new Pair<>(spl[0].trim(), spl[1].trim());
    }

    public static Object[] mineValues(String valuesAll) throws Exception {
        valuesAll = valuesAll.trim();
        String[] spl = valuesAll.split(SEPARATOR_PROPERTY_VALUE_ARRAY);
        Object[] obj = new Object[]{spl.length};
        for (int i = 0; i < spl.length; i++) {
            obj[i] = parse(spl[i]);
        }
        return obj;
    }

    private static Object parse(String value) throws Exception {
        value = value.trim();
        int indexInicio = value.indexOf(VALUE_START);
        String valueRaw = value.substring(indexInicio + 1, value.lastIndexOf(VALUE_END));
        String type = value.substring(0, indexInicio);
        return parseFinal(type, valueRaw);
    }

    private static Object parseFinal(String type, String value) throws Exception {
        switch (type) {
            case STRING:
                return value;
            case BOOLEAN:
                return (boolean) Boolean.valueOf(value);
            case INT:
                return (int) Integer.valueOf(value);
            case LONG:
                return (long) Long.valueOf(value);
            case FLOAT:
                return (float) Float.valueOf(value);
            case DOUBLE:
                return (double) Double.valueOf(value);
            case COLOR:
                return ColorParser.valueOf(value);
            case COLOR_STATIC:
                return ColorStaticParser.valueOf(value);
            case ICON_STATIC:
                return IconStaticParser.valueOf(value);
            default:
                return null;
        }
    }

    public static final String BOOLEAN = "b";
    public static final String INT = "i";
    public static final String LONG = "l";
    public static final String FLOAT = "f";
    public static final String DOUBLE = "d";
    public static final String STRING = "s";
    public static final String COLOR = "color";
    public static final String COLOR_STATIC = "color-static";
    public static final String ICON_STATIC = "icon-static";

    private static class ColorParser {

        public static Color valueOf(String value) throws Exception {
            String spl[] = value.trim().split(VALUE_SEPARATON);
            if (spl.length == 1) {//un solo valor
                Object rgb = MineName.parse(spl[0]);
                if (rgb instanceof String) {// si es String: decode
                    return Color.decode((String) rgb);
                } else {//sino new Color()
                    return new Color((int) rgb);//Color.class.getConstructor(int.class).newInstance(rgb);
                }
            } else if (spl.length == 3) {//rgb
                Object r = MineName.parse(spl[0]);
                Object g = MineName.parse(spl[1]);
                Object b = MineName.parse(spl[2]);
                if (r instanceof Integer) {
                    return new Color((int) r, (int) g, (int) b);//Color.class.getConstructor(int.class, int.class, int.class).newInstance(r, g, b);
                } else if (r instanceof Float) {
                    return new Color((float) r, (float) g, (float) b);//Color.class.getConstructor(float.class, float.class, float.class).newInstance(r, g, b);
                } else {
                    return null;
                }
            } else {//rgba    
                Object r = MineName.parse(spl[0]);
                Object g = MineName.parse(spl[1]);
                Object b = MineName.parse(spl[2]);
                Object a = MineName.parse(spl[3]);
                if (r instanceof Integer) {
                    return new Color((int) r, (int) g, (int) b, (int) a);//Color.class.getConstructor(int.class, int.class, int.class, int.class).newInstance(r, g, b, a);
                } else if (r instanceof Float) {
                    return new Color((float) r, (float) g, (float) b, (float) a);//Color.class.getConstructor(float.class, float.class, float.class, float.class).newInstance(r, g, b, a);
                } else {
                    return null;
                }
            }
        }//public static Color valueOf(String value)
    }//ColorParser

    private static class ColorStaticParser {

        public static Color valueOf(String value) throws Exception {
            int lastIndex = value.lastIndexOf(".");
            String clazz = value.substring(0, lastIndex);
            String field = value.substring(lastIndex + 1, value.length());
            return (Color) Class.forName(clazz).getField(field).get(null);
        }//public static Color valueOf(String value)
    }//ColorStaticParser

    private static class IconStaticParser {

        public static Icon valueOf(String value) throws Exception {
            int lastIndex = value.lastIndexOf(".");
            String clazz = value.substring(0, lastIndex);
            String field = value.substring(lastIndex + 1, value.length());
            return (Icon) Class.forName(clazz).getField(field).get(null);
        }//public static Color valueOf(String value)
    }//ColorStaticParser
}
