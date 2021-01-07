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
package com.root101.swing.material.components.textfield;

import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialTextFactory {

    public static MaterialTextField build() {
        return _MaterialTextField.from();
    }

    public static MaterialTextField build(Class clazz) {
        return _MaterialTextField.from(clazz);
    }

    public static MaterialTextFieldIcon buildIcon() {
        return _MaterialTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormated() {
        return _MaterialFormatedTextField.from();
    }

    public static MaterialFormatedTextFieldIcon buildFormatedIcon() {
        return _MaterialFormatedTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntime.from(formateer);
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntime.from(formateer, clazz);
    }

    public static MaterialFormatedTextFieldIcon buildFormatedRuntimeIcon(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntimeIcon.from(formateer);
    }

    public static MaterialFormatedTextFieldIcon buildFormatedRuntimeIcon(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntimeIcon.from(formateer, clazz);
    }
}
