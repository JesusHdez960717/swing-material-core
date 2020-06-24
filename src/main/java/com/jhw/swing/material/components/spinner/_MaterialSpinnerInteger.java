package com.jhw.swing.material.components.spinner;

import javax.swing.JSpinner;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialSpinnerInteger extends JSpinner {

    public _MaterialSpinnerInteger() {
        super(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
    }

}