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
package com.root101.swing.material.components.colorchooser;

import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.root101.swing.material.components.container.panel._PanelGradient;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.util.interfaces.BindableComponent;
import com.root101.swing.util.interfaces.MaterialComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialColorChooserCore extends _PanelGradient implements BindableComponent<Color> {

    public static _MaterialColorChooserCore from() {
        return new _MaterialColorChooserCore();
    }

    private static final Dimension DEFAULT_DIM = new Dimension(30, 30);
    private static final String DEFAULT_TEXT = "Ejemplo de texto";
    private static final Icon DEFAULT_ICON = MaterialIcons.PALETTE;
    private static final int DEFAULT_ROW = 14;
    private static final int DEFAULT_COL = 23;

    private Color selectedColor = MaterialColors.BLACK;

    public _MaterialColorChooserCore() {
        initComponents();
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        colors = MaterialContainersFactory.buildPanelTransparent();
        colors.setLayout(new GridLayout(DEFAULT_ROW, DEFAULT_COL, 0, 0));
        createColors();

        buttonTest = MaterialButtonsFactory.buildButton();
        buttonTest.setIcon(DEFAULT_ICON);
        buttonTest.setText(DEFAULT_TEXT);

        labelTest = MaterialLabelsFactory.build();
        labelTest.setHorizontalAlignment(SwingConstants.CENTER);
        labelTest.setIcon(DEFAULT_ICON);
        labelTest.setText(DEFAULT_TEXT);

        HorizontalLayoutContainer.builder hlcTest = HorizontalLayoutContainer.builder();
        hlcTest.add(buttonTest);
        hlcTest.add(labelTest);

        this.add(colors);
        this.add(hlcTest.build(), BorderLayout.SOUTH);
    }

    private class Btn extends JButton implements MaterialComponent {
    }
    private JPanel colors;
    private MaterialButton buttonTest;
    private MaterialLabel labelTest;

    private int addEmpty(int cant, int i2) {
        for (int i = 0; i < cant; i++) {
            i2++;
            JPanel empty = MaterialContainersFactory.buildPanelTransparent();
            empty.setPreferredSize(DEFAULT_DIM);
            int pos = getPos(i2);
            colors.remove(pos);
            colors.add(empty, pos);
        }
        return i2;
    }

    @Override
    public Color getObject() {
        return selectedColor;
    }

    @Override
    public void setObject(Color c) {
        this.selectedColor = c;
        buttonTest.setBackground(c);
        labelTest.setForeground(c);
    }

    private int getPos(int i) {
        int x = i / DEFAULT_ROW;
        int y = i - x * DEFAULT_ROW;
        int pos = DEFAULT_COL * y + x;
        return pos;
    }

    private void createColors() {
        //inicia todos los componentes
        for (int i = 0; i < DEFAULT_ROW; i++) {
            for (int j = 0; j < DEFAULT_COL; j++) {
                colors.add(MaterialContainersFactory.buildPanelTransparent());
            }
        }

        Field[] fields = MaterialColors.class.getDeclaredFields();

        int i = -1;
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && Color.class.isAssignableFrom(field.getType())) {
                try {
                    i++;

                    Color c = (Color) field.get(null);
                    String name = field.getName();

                    String rgba = c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + ", " + c.getAlpha();

                    JButton btn = new Btn();
                    btn.setCursor(Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
                    btn.setBorder(null);
                    btn.setPreferredSize(DEFAULT_DIM);
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setObject(c);
                        }
                    });
                    btn.setBackground(c);
                    btn.setToolTipText(name + " (" + rgba + ")");

                    int pos = getPos(i);
                    colors.remove(pos);
                    colors.add(btn, pos);

                    switch (name) {
                        case "BROWN_900":
                            i = addEmpty(4, i + 1) - 1;
                            break;
                        case "BLUEGREY_900":
                            i = addEmpty(4, i + 1) - 1;
                            break;
                        case "GREY_900":
                            i = addEmpty(3, i + 1) - 1;
                            break;
                        case "LIGHT_WHITE":
                            i = addEmpty(9, i + 1) - 1;
                            break;
                        case "FAINT_BLACK":
                            i = addEmpty(8, i + 1) - 1;
                            break;
                        case "DARKLY_GRAY":
                            i = addEmpty(7, i + 1) - 1;
                            break;
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
