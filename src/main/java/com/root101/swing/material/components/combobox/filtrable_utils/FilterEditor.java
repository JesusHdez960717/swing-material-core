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

import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.JLabel;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class FilterEditor<T> extends BasicComboBoxEditor {

    private MaterialLabel filterLabel = MaterialLabelsFactory.build();
    private String text = "";
    private boolean editing;
    private Function<T, String> formater;
    private Consumer<Boolean> editingChangeListener;
    private Object selected;

    FilterEditor(Function<T, String> formater,
            Consumer<Boolean> editingChangeListener) {
        this.formater = formater;
        this.editingChangeListener = editingChangeListener;
    }

    public void addChar(char c) {
        text += c;
        if (!editing) {
            enableEditingMode();
        }
    }

    public void removeCharAtEnd() {
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
            if (!editing) {
                enableEditingMode();
            }
        }
    }

    private void enableEditingMode() {
        editing = true;
        //filterLabel.setFont(filterLabel.getFont().deriveFont(Font.PLAIN));
        editingChangeListener.accept(true);
    }

    public void reset() {
        if (editing) {
            //filterLabel.setFont(UIManager.getFont("ComboBox.font"));
            filterLabel.setForeground(UIManager.getColor("Label.foreground"));
            text = "";
            editing = false;
            editingChangeListener.accept(false);
        }
    }

    @Override
    public Component getEditorComponent() {
        return filterLabel;
    }

    public JLabel getFilterLabel() {
        return filterLabel;
    }

    @Override
    public void setItem(Object anObject) {
        if (editing) {
            filterLabel.setText(text);
        } else {
            T t = (T) anObject;
            filterLabel.setText(formater.apply(t));
        }
        this.selected = anObject;
    }

    @Override
    public Object getItem() {
        return selected;
    }

    @Override
    public void selectAll() {
    }

    @Override
    public void addActionListener(ActionListener l) {
    }

    @Override
    public void removeActionListener(ActionListener l) {
    }

    public boolean isEditing() {
        return editing;
    }

    public String getText() {
        return text;
    }
}
