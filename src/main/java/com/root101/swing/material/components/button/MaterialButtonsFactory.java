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

import com.root101.swing.material.components.popup.MaterialPopupFactory;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialButtonsFactory {

    public static MaterialButton buildButton() {
        return _MaterialButton.from();
    }

    public static _MaterialButtonDouble buildDouble() {
        return _MaterialButtonDouble.from();
    }

    public static MaterialButton buildFlat() {
        MaterialButton btn = buildButton();
        btn.setType(_MaterialButton.Type.FLAT);
        btn.setBorderRadius(0);
        return btn;
    }

    //-----------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTranspRotate() {
        return _MaterialButtonIconTranspRotate.from();
    }

    //----------------Icon Transparent----------------
    public static MaterialButtonIcon buildIconTransparent() {
        return _MaterialButtonIconTransparent.from();
    }

    public static MaterialButtonIcon buildIconTransparent(ImageIcon icon) {
        MaterialButtonIcon btn = MaterialSwingInjector.getImplementation(_MaterialButtonIconTransparent.class);
        int w = (int) (1.5f * icon.getIconWidth());
        btn.setMaximumSize(new Dimension(w, w));
        btn.setIcon(icon);
        return btn;
    }

    //----------------PopupCircular----------------
    /**
     * Preferiblemente usar directo con la lista de acciones que crea popup
     * redondo chulo.
     *
     * @return
     * @deprecated
     */
    @Deprecated
    public static MaterialButton buildPopup() {
        return _MaterialButtonPopup.from();
    }

    public static MaterialButton buildPopup(List<Action> actions) {
        MaterialButton btn = buildPopup();
        btn.setComponentPopupMenu(MaterialPopupFactory.buildCircular(actions));
        return btn;
    }
    //----------------------------------------

    public static JButton buildHyperlink() {
        return _MaterialButtonHiperlink.from();
    }

    public static MaterialButton buildRound() {
        return _MaterialIconButtonRound.from();
    }

}
