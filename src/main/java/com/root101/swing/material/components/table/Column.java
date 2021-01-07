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
package com.root101.swing.material.components.table;

import com.root101.clean.core.exceptions.ValidationException;
import com.root101.clean.core.utils.validation.Validable;
import com.root101.clean.core.utils.validation.ValidationResult;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class Column implements Validable {

    @NotEmpty
    private final String columnName;

    @NotNull
    private final Class columnsClass;

    private final boolean editable;

    @PositiveOrZero
    private final int preferedWidth;

    public Column(Class cl, String name, boolean editable, int width) {
        this.columnsClass = cl;
        this.columnName = name;
        this.editable = editable;
        this.preferedWidth = width;
        validate();
    }

    public String getColumnName() {
        return columnName;
    }

    public Class getColumnsClass() {
        return columnsClass;
    }

    public boolean isEditable() {
        return editable;
    }

    public int getPreferedWidth() {
        return preferedWidth;
    }

    public static builder builder() {
        return new builder();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public static class builder {

        private String columnName;
        private Class columnsClass = Object.class;
        private boolean editable = false;
        private int preferedWidth = 75;

        public builder name(String name) {
            this.columnName = name;
            return this;
        }

        public builder classType(Class type) {
            this.columnsClass = type;
            return this;
        }

        public builder editable(boolean editable) {
            this.editable = editable;
            return this;
        }

        public builder width(int preferedWidth) {
            this.preferedWidth = preferedWidth;
            return this;
        }

        public Column build() {
            return new Column(columnsClass, columnName, editable, preferedWidth);
        }
    }
}
