/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFormatedTextFieldRuntime<T> extends _MaterialFormatedTextField<T> {

    private final List<Integer> scapeCharacters = new ArrayList<>();

    public _MaterialFormatedTextFieldRuntime(AbstractFormatter formateer) {
        this(formateer, String.class);
    }

    public _MaterialFormatedTextFieldRuntime(AbstractFormatter formateer, Class clazz) {
        super(clazz);
        this.setFormatterFactory(new DefaultFormatterFactory(formateer));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                keyPressedAction(e);
            }
        });

        installDefaultScapeCharacters();
    }

    private void keyPressedAction(KeyEvent e) {
        try {
            if (!scapeCharacters.contains(e.getKeyCode())) {
                this.commitEdit();
                this.setValue(this.getValue());
            }
        } catch (Exception ex) {
            System.out.println("Error formateando " + ex.getMessage());
        }
    }

    public void addScapeCharacter(Integer c) {
        this.scapeCharacters.add(c);
    }

    public List<Integer> getScapeCharacters() {
        return scapeCharacters;
    }

    private void installDefaultScapeCharacters() {
        addScapeCharacter(KeyEvent.VK_RIGHT);
        addScapeCharacter(KeyEvent.VK_LEFT);
    }
}
