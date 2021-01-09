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
package com.root101.swing.material.components.button;

import com.root101.swing.material.standards.MaterialColors;
import java.awt.Color;
import javax.swing.JButton;
import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.effects.Iconable;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.util.interfaces.MaterialComponent;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonHiperlink extends JButton implements Iconable, MaterialComponent {

    public static _MaterialButtonHiperlink from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonHiperlink.class);
        //return new _MaterialButtonHiperlink();
    }

    private Color mouseEnteredColor = MaterialColors.BLACK;
    private Color mouseExitedColor = MaterialColors.BLACK;

    /**
     * Usar _MaterialButtonHiperlink.from() para que coja proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialButtonHiperlink() {
        mouseExitedColor = (PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setIcon(MaterialIcons.ADD_CIRCLE_OUTLINE);
        this.setCursor(Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(mouseEnteredColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(mouseExitedColor);
            }
        });
        this.setForeground(mouseExitedColor);
    }

    public Color getMouseEnteredColor() {
        return mouseEnteredColor;
    }

    public void setMouseEnteredColor(Color mouseEnteredColor) {
        this.mouseEnteredColor = mouseEnteredColor;
        this.setForeground(mouseEnteredColor);
    }

    public Color getMouseExitedColor() {
        return mouseExitedColor;
    }

    public void setMouseExitedColor(Color mouseExitedColor) {
        this.mouseExitedColor = mouseExitedColor;
        this.setForeground(mouseExitedColor);
    }

}
