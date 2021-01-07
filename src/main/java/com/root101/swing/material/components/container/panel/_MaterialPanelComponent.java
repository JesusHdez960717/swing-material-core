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
import com.root101.swing.material.standards.MaterialShadow;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialPanelComponent extends _MaterialPanel {

    public static MaterialPanelBorder from() {
        return MaterialSwingInjector.getImplementation(_MaterialPanelComponent.class);
    }

    private final static int DEFAULT_GAP = 10;

    /**
     * Use _MaterialPanelComponent.from() para proy y AOP
     *
     * @param gap
     * @deprecated
     */
    @Deprecated
    public _MaterialPanelComponent() {
        this(DEFAULT_GAP);
    }

    /**
     * Use _MaterialPanelComponent.from() para proy y AOP
     *
     * @param gap
     * @deprecated
     */
    @Deprecated
    public _MaterialPanelComponent(int gap) {
        this.setLayout(new BorderLayout());
        setGap(gap);
    }

    public void setGap(int gap) {
        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP + gap,
                MaterialShadow.OFFSET_LEFT + gap,
                MaterialShadow.OFFSET_BOTTOM + gap,
                MaterialShadow.OFFSET_RIGHT + gap));
    }

    @Override
    public Component add(Component comp) {
        this.add(comp, BorderLayout.CENTER);
        return comp;
    }

}
