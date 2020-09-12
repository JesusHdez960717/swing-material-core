/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class ContentArea extends _PanelTransparent {

    public abstract ContentArea addText(String txt);

    public abstract ContentArea addHeader(String header);

    public abstract ContentArea header(String header);

    public abstract ContentArea text(String text);

    public abstract ContentArea textHorizontalAlignment(int textHorizontalAlignment);

    public abstract ContentArea headerFont(Font headerFont);

    public abstract ContentArea textFont(Font textFont);

    public abstract ContentArea backgroundColor(Color backColor);

}
