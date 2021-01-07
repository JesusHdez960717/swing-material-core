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

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.effects.ColorFadeInto;
import com.root101.swing.material.effects.ElevationEffect;
import com.root101.swing.material.effects.Iconable;
import com.root101.swing.material.effects.MaterialLineBorder;
import com.root101.swing.material.effects.RippleEffect;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class MaterialInputPopupIcon extends _PanelTransparent implements Iconable, RippleEffect, ColorFadeInto, ElevationEffect, MaterialLineBorder {

    public void setText(String text) {
        getButton().setText(text);
    }

    public abstract void setActions(List<Action> action);

    public abstract MaterialButton getButton();
}
