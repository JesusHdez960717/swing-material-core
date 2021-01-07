/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.textfield;

import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.util.PersonalizationMaterial;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialFormatedTextFieldRuntime<T> extends _MaterialFormatedTextField<T> {

    public static MaterialFormatedTextField from(AbstractFormatter formateer) {
        return new _MaterialFormatedTextFieldRuntime(formateer);
    }

    public static MaterialFormatedTextField from(AbstractFormatter formateer, Class clazz) {
        return new _MaterialFormatedTextFieldRuntime(formateer, clazz);
    }
    
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
            if (PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_FORMAT_TEXT_FIELD_RUNTIME)) {
                if (!scapeCharacters.contains(e.getKeyCode())) {
                    this.commitEdit();
                    this.setValue(this.getValue());
                }
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
