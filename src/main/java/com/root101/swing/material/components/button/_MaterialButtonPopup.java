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

import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonPopup extends _MaterialButton {

    public static MaterialButton from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonPopup.class);
    }

    private JPopupMenu popup;

    /**
     * Usar _MaterialButtonPopup.from() para proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialButtonPopup() {
        personalize();
        addListeners();
    }

    private void personalize() {
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
        this.setAccentColorFadeInto(MaterialColors.BLUEGREY_50);
        this.setPaintRipple(false);
        this.setBorderThickness(2);
        this.setBorderColor(MaterialColors.GREY_700);
        this.setIcon(MaterialIcons.FILE_UPLOAD);
        this.setIconTextGap(5);
    }

    private void addListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopup(e);
            }
        });
    }

    @Override
    public JPopupMenu getComponentPopupMenu() {
        return null;
    }

    @Override
    public void setComponentPopupMenu(JPopupMenu popup) {
        this.popup = popup;
    }

    private void showPopup(MouseEvent e) {
        if (popup != null) {
            //middle of component
            int x = (int) ((getSize().getWidth() - popup.getPreferredSize().getWidth()) / 2);

            int y = (int) ((getSize().getHeight() - popup.getPreferredSize().getHeight()) / 2);
            popup.show(this, x, y);
        }
    }
}


/*Otras posiciones donde puede salir el popup
//middle of mouse
Point mousePos = MouseInfo.getPointerInfo().getLocation();

Rectangle screen = Utils.getScreenSize();
int x = (int) (mousePos.getX() - getPreferredSize().getWidth() / 2);
x = Math.max(0, Math.min((int) (screen.getWidth() - getPreferredSize().getWidth()), x));

int y = (int) (mousePos.getY() - getPreferredSize().getWidth() / 2);
y = Math.max(0, Math.min((int) (screen.getHeight() - getPreferredSize().getHeight()), y));
popup.show(this, x, y);
 
//standar
//popup.show(this, e.getX(), e.getY());
 */
