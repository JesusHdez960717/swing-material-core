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
package com.root101.swing.material.components.combobox;

/**
 * Por el momento los combo boxes no necesitan injection ni proxy, no tiene
 * sentido usarlos y agregarle capas innecesarias a los componentes
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialComboBoxFactory {

    public static MaterialComboBox build() {
        return _MaterialComboBox.from();
    }

    public static MaterialComboBox buildFiltrable() {
        return _MaterialComboBoxFiltrable.from();
    }

    public static MaterialComboBoxIcon buildIcon() {
        return _MaterialComboBoxIcon.from();
    }

    public static MaterialComboBoxIcon buildFiltrableIcon() {
        return _MaterialComboBoxIcon.from(buildFiltrable());
    }
}
