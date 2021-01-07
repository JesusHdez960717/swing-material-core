/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.toggle;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultToggleGroup extends ToggleGroup {

    public static ToggleGroup from() {
        return new DefaultToggleGroup();
    }

    private final List<JToggleButton> buttons = new ArrayList<>();

    @Override
    public void add(JToggleButton button) {
        button.addActionListener((ActionEvent e) -> {
            for (JToggleButton b : buttons) {
                b.setSelected(false);
                button.setSelected(true);
            }
        });
        buttons.add(button);
    }

    @Override
    public JToggleButton getSelected() {
        for (JToggleButton b : buttons) {
            if (b.isSelected()) {
                return b;
            }
        }
        return null;
    }
}
