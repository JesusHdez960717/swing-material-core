/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.bundles.dnd;

import java.awt.datatransfer.DataFlavor;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PanelDataFlavor extends DataFlavor {

    // This saves me having to make lots of copies of the same thing
    public static final PanelDataFlavor SHARED_INSTANCE = new PanelDataFlavor();

    public PanelDataFlavor() {
        super(JPanel.class, null);
    }

}
