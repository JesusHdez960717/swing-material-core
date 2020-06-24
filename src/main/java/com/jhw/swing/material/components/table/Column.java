package com.jhw.swing.material.components.table;

import lombok.Getter;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class Column {

    @Getter
    private final String columnName;
    @Getter
    private final Class columnsClass;
    @Getter
    private final boolean editable;
    @Getter
    private final int preferedWidth;

    public Column(Class cl, String name, boolean editable, int width) {
        this.columnsClass = cl;
        this.columnName = name;
        this.editable = editable;
        this.preferedWidth = width;
    }

    public static builder builder() {
        return new builder();
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
