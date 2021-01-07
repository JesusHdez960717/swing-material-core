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
package com.root101.swing.material.components.container.panel;

import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su logica de edisoncorSX.
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _PanelGradientTranslucid extends _PanelGradient implements MaterialComponent {

    public static _PanelGradientTranslucid from() {
        return MaterialSwingInjector.getImplementation(_PanelGradientTranslucid.class);
    }

    protected float tran = 0.5f;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setComposite(AlphaComposite.getInstance(3, this.tran));
        super.paintComponent(g2);
    }

    public float getTran() {
        return this.tran;
    }

    public void setTran(float tran) {
        int i;
        int i2 = 1;
        if (tran >= 0.0f) {
            i = 1;
        } else {
            i = 0;
        }
        if (tran > 1.0f) {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            this.tran = tran;
            repaint();
        }
    }

}
