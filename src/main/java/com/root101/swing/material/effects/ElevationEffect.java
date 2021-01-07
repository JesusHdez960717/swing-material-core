/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Graphics2D;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface ElevationEffect extends BorderRadius {

    /**
     * Get the current elevation (in case of animated it variate)
     *
     * @return
     */
    public double getLevel();

    /**
     * Method to override to change the different elevations
     *
     * @return
     */
    public double getElevation();

    public void paintElevation(Graphics2D g2);
}
