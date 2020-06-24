package com.jhw.swing.material.components.dashboard.elements;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 * Modelo requerido para cada elemento de la pagina principal.<\br>
 * Este contiene el boton, el panel y el nombre del componente para los que lo
 * muestran.<\br>
 * Está pensado para que se agrege el nombre, icono y el panel a agregar, por
 * defecto el color del boton va a ser un brigther al color por defecto del
 * background del panel material, pero se puede personalizar creando uno mismo
 * el botón.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainPageElement {

    private _MaterialButtonMainPage button;
    private Component panel;
    private String name;

    public MainPageElement(String name, ImageIcon icon, Component panel) {
        this.name = name;
        this.panel = panel;

        this.button = new _MaterialButtonMainPage(icon, name);
    }

    public MainPageElement(String name, _MaterialButtonMainPage button, Component panel) {
        this.name = name;
        this.button = button;
        this.panel = panel;
    }

    public _MaterialButtonMainPage getButton() {
        return button;
    }

    public void setButton(_MaterialButtonMainPage button) {
        this.button = button;
    }

    public Component getPanel() {
        return panel;
    }

    public void setPanel(Component panel) {
        this.panel = panel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
