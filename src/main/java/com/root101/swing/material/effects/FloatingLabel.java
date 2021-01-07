/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface FloatingLabel {

    /**
     * Gets the color the label changes to when this {@code materialTextField}
     * is focused.
     *
     * @return the {@code "Color"} currently in use for accent. The default
     * value is {@link MaterialColor#BLUEA_400}.
     */
    public Color getAccentFloatingLabel();

    /**
     * Sets the color the label changes to when this {@code materialTextField}
     * is focused. The default value is {@link MaterialColor#PINK_500}.
     *
     * @param accentColor the {@code "Color"} that should be used for accent.
     */
    public void setAccentFloatingLabel(Color accentColor);

    /**
     * Gets the label text. The label will float above any contents input into
     * this text field.
     *
     * @return the text being used in the floating label
     */
    public String getLabel();

    /**
     * Sets the label text. The label will float above any contents input into
     * this text field.
     *
     * @param label the text to use in the floating label
     */
    public void setLabel(String label);

    /**
     * Gets the hint text. The hint text is displayed when the list inside this
     * combo box is empty or no element has been selected yet.
     *
     * @return hint text
     */
    public String getHint();

    /**
     * Sets the hint text. The hint text is displayed when the list inside this
     * combo box is empty or no element has been selected yet.
     *
     * @param hint hint text
     */
    public void setHint(String hint);

    public void paintLabel(Graphics g);

    public void paintHint(Graphics g);
}
