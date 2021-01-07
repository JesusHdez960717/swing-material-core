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
package com.root101.swing.material.components.textarea;

import com.root101.swing.util.interfaces.BindableComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import com.root101.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.root101.swing.material.components.textfield.CopyPastePopup;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import javax.swing.JComponent;
import javax.swing.JTextArea;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialTextArea extends _MaterialScrollPaneCore implements BindableComponent<String> {

    public static _MaterialTextArea from() {
        return new _MaterialTextArea();
    }

    public _MaterialTextArea() {
        initComponents();
        setBorderTitle("title");
    }

    private void initComponents() {
        materialTextAreaCore = _MaterialTextAreaCore.from();

        materialTextAreaCore.setColumns(1);
        materialTextAreaCore.setRows(1);
        this.setViewportView(materialTextAreaCore);

        this.setPreferredSize(new Dimension(230, 150));
    }

    private _MaterialTextAreaCore materialTextAreaCore;

    @Override
    public JComponent getFocusableComponent() {
        return materialTextAreaCore;
    }

    @Override
    public void setBackground(Color bk) {
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setBackground(bk);
        }
        super.setBackground(bk);
    }

    @Override
    public Color getBackground() {
        if (materialTextAreaCore != null) {
            return materialTextAreaCore.getBackground();
        }
        return super.getBackground();
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setFont(font);
        }
    }

    @Override
    public void setForeground(Color fore) {
        super.setForeground(fore);
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setForeground(fore);
        }
    }

    @Override
    public String getObject() {
        return materialTextAreaCore.getText();
    }

    @Override
    public void setObject(String object) {
        materialTextAreaCore.setText(object);
    }

    @Background_Force_Foreground
    public static class _MaterialTextAreaCore extends JTextArea implements BindableComponent<String> {

        public static _MaterialTextAreaCore from() {
            return MaterialSwingInjector.getImplementation(_MaterialTextAreaCore.class);
        }

        protected _MaterialTextAreaCore() {
            this.setBackground(MaterialColors.WHITE);
            this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
            this.setLineWrap(true);
            this.setComponentPopupMenu(CopyPastePopup.INSTANCE);
            this.setTabSize(2);
        }

        @Override
        public String getObject() {
            return getText();
        }

        @Override
        public void setObject(String object) {
            setText(object);
        }
    }

}
