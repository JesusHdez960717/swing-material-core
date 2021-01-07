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
package com.root101.swing.material.components.table.editors_renders.header;

import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.components.labels._MaterialLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import com.root101.swing.material.standards.MaterialIcons;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class HeaderCellRender extends DefaultTableCellRenderer {

    private final MaterialLabel label;

    /**
     * Default crea un label con los 3puntitos del more
     */
    public HeaderCellRender() {
        label = MaterialLabelsFactory.build();
        label.setIcon(MaterialIcons.MORE_HORIZ);
        label.setText("");
        estandarizarLabel();
    }

    public HeaderCellRender(_MaterialLabel label) {
        this.label = label;
        estandarizarLabel();
    }

    public HeaderCellRender(ImageIcon icon, String text) {
        MaterialLabel labelAct = MaterialLabelsFactory.build();
        labelAct.setIcon(icon);
        labelAct.setText(text);
        labelAct.setHorizontalAlignment(SwingConstants.CENTER);
        this.label = labelAct;
        estandarizarLabel();
    }

    private void estandarizarLabel() {
        label.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        label.setFont(UIManager.getFont("TableHeader.font"));
        label.setBackground(UIManager.getColor("TableHeader.background"));

        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return label;// como es uno fijo siempre mantiene el mismo
    }

}
