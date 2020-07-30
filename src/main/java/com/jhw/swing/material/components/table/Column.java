package com.jhw.swing.material.components.table;

import com.clean.core.exceptions.ValidationException;
import com.clean.core.utils.validation.Validable;
import com.clean.core.utils.validation.ValidationResult;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
