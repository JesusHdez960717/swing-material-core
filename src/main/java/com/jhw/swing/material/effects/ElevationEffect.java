/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.effects;

import java.awt.Graphics2D;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface ElevationEffect {

    /**
     * Method to override to change the different elevations
     *
     * @return
     */
    public double getLevel();

    public double getElevation();

    public void paintElevation(Graphics2D g2);
}
