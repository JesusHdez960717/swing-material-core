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
package com.root101.swing.material.components.container;

import com.root101.swing.material.components.container.frame.MaterialWindow;
import com.root101.swing.material.components.container.panel.MaterialPanelBorder;
import com.root101.swing.material.components.container.panel._MaterialPanel;
import com.root101.swing.material.components.container.panel._MaterialPanelComponent;
import com.root101.swing.material.components.container.panel._PanelAvatarChooser;
import com.root101.swing.material.components.container.panel._PanelComponent;
import com.root101.swing.material.components.container.panel._PanelCurves;
import com.root101.swing.material.components.container.panel._PanelGradient;
import com.root101.swing.material.components.container.panel._PanelGradientTranslucid;
import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.components.container.tabbed._TabbedPaneClose;
import com.root101.swing.material.components.container.tabbed._TabbedPaneHeader;
import com.root101.swing.material.components.container.tabbed._TabbedPaneSelector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialContainersFactory {

    public static JFrame buildFrame() {
        return MaterialWindow.from();
    }

    public static MaterialPanelBorder buildPanel() {
        return _MaterialPanel.from();
    }

    public static MaterialPanelBorder buildPanelComponent() {
        return _MaterialPanelComponent.from();
    }

    public static JPanel buildPanelComponentTransparent() {
        return _PanelComponent.from();
    }

    public static _PanelAvatarChooser buildPanelAvatar() {
        return _PanelAvatarChooser.from();
    }

    public static JPanel buildPanelCurves() {
        return _PanelCurves.from();
    }

    public static MaterialPanelBorder buildPanelGradient() {
        return _PanelGradient.from();
    }

    public static MaterialPanelBorder buildPanelGradientTranslucid() {
        return _PanelGradientTranslucid.from();
    }

    public static JPanel buildPanelTransparent() {
        return _PanelTransparent.from();
    }

    public static JTabbedPane buildTabbedClose() {
        return _TabbedPaneClose.from();
    }

    public static JTabbedPane buildTabbedHeader() {
        return _TabbedPaneHeader.from();
    }

    public static JTabbedPane buildTabbedSelector() {
        return _TabbedPaneSelector.from();
    }
}
