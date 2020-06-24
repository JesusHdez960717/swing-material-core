package com.jhw.swing.util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.material.standars.MaterialImages;

/**
 * Clase auxiliar que brinda varios JOptionsPane predefinidos.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class JOP {

    public static final String DELETE = "DELETE";

    public static boolean confirmCancel() {
        return JOptionPane.showConfirmDialog(null, "Seguro desea cancelar?", "Cancel", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE) == 0;
    }

    public static boolean confirmDelete() {
        return confirmDelete("");
    }

    public static boolean confirmDelete(Object obj) {
        String text = "Seguro desea eliminar " + ObjectToString(obj) + " ?";
        if (JOptionPane.showConfirmDialog(null, text, "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, MaterialIcons.DELETE_FOREVER.deriveIcon(36f)) == 0) {
            if (PersonalizationMaterial.getInstance().isDouble_delete_check()) {
                String conf = JOptionPane.showInputDialog(null, "Para confirmar introduzca la palabra: " + DELETE);
                if (conf != null && conf.toUpperCase().matches(DELETE)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean confirmCreate() {
        return confirmCreate("");
    }

    public static boolean confirmCreate(Object obj) {
        return JOptionPane.showConfirmDialog(null, "Seguro desea crear el elemento " + ObjectToString(obj) + " ?", "Crear", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0;
    }

    public static boolean confirmCreate(boolean created) {
        return JOptionPane.showConfirmDialog(null, "Seguro desea " + (created ? "crear" : "editar") + " el elemento ?", "Crear", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0;
    }

    public static void error(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(MaterialImages.ERROR));
    }

    public static boolean confirmEnd() {
        return JOptionPane.showConfirmDialog(null, "Seguro desea terminar?", "Terminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0;
    }

    private static String ObjectToString(Object obj) {
        return obj.toString().trim().isEmpty() ? "" : "\'" + obj.toString().toUpperCase() + "\'";
    }
}
