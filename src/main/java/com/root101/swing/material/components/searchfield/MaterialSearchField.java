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
package com.root101.swing.material.components.searchfield;

import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.container.panel._MaterialPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class MaterialSearchField extends _MaterialPanel {

    public abstract void setHint(String hint);

    public abstract String getHint();

    public abstract void clear(KeyEvent evt);

    public abstract int getMaxLength();

    public abstract void setMaxLength(int maxLength);

    public abstract void setSearchActionListener(ActionListener searchAction);

    public abstract String getText();

    public abstract ActionListener getSearchAction();

    public abstract MaterialButtonIcon getButtonSearch();

    public abstract JTextField getSearchField();

}
