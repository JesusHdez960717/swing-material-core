/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.colorchooser;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.interfaces.BindableComponent;
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialColorChooserCore extends _PanelGradient implements BindableComponent<Color> {

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
        colors.setLayout(new GridLayout(DEFAULT_ROW, DEFAULT_COL));
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

                    JButton btn = new JButton();
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
