/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.searchfield;

import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.container.panel._MaterialPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialSearchField extends _MaterialPanel {

    public abstract void setHint(String hint);

    public abstract String getHint();

    public abstract void clear(KeyEvent evt);

    public abstract int getMaxLength();

    public abstract void setMaxLength(int maxLength);

    public abstract void setSearchActionListener(ActionListener searchAction);

    public abstract String getText();

    public abstract ActionListener getSearchAction();

    public abstract MaterialButtonIcon getButtonSearch();

    public abstract JTextField getSearchField();

}
