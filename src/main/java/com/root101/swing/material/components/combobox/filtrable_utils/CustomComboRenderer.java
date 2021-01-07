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
package com.root101.swing.material.components.combobox.filtrable_utils;

import com.root101.swing.util.HtmlHighlighter;
import javax.swing.*;
import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class CustomComboRenderer<T> extends DefaultListCellRenderer {

    public static final Color background = UIManager.getColor("List.background");
    private static final Color defaultBackground = UIManager.getColor("List.background");
    private static final Color defaultForeground = UIManager.getColor("List.foreground");
    private Supplier<String> highlightTextSupplier;
    private Function<T, String> comboDisplayTextMapper;

    public CustomComboRenderer(Supplier<String> highlightTextSupplier, Function<T, String> comboDisplayTextMapper) {
        this.highlightTextSupplier = highlightTextSupplier;
        this.comboDisplayTextMapper = comboDisplayTextMapper;
    }

    public static <T> CustomComboRenderer build(Supplier<String> highlightTextSupplier, Function<T, String> comboDisplayTextMapper) {
        return new CustomComboRenderer(highlightTextSupplier, comboDisplayTextMapper);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        T obj = (T) value;
        if (obj == null) {
            return this;
        }
        String text = comboDisplayTextMapper.apply(obj);
        text = HtmlHighlighter.highlightText(text, highlightTextSupplier.get());
        this.setText(text);
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        this.setForeground(defaultForeground);
        return this;
    }

}
