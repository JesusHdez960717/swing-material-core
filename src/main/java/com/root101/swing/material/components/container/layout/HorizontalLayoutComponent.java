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
package com.root101.swing.material.components.container.layout;

import com.root101.clean.core.exceptions.ValidationException;
import com.root101.clean.core.utils.validation.Validable;
import com.root101.clean.core.utils.validation.ValidationResult;
import java.awt.Component;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class HorizontalLayoutComponent implements Validable {

    @NotNull
    private Component component;

    @PositiveOrZero
    private int width;

    @PositiveOrZero
    private int gapLeft;

    @PositiveOrZero
    private int gapRight;

    private boolean resize;

    public HorizontalLayoutComponent(Component component, int width, int gapLeft, int gapRight, boolean resize) {
        this.component = component;
        this.width = width;
        this.gapLeft = gapLeft;
        this.gapRight = gapRight;
        this.resize = resize;
        validate();
    }

    public Component getComponent() {
        return component;
    }

    public boolean isResize() {
        return resize;
    }

    public int getWidth() {
        return width;
    }

    public int getGapLeft() {
        return gapLeft;
    }

    public int getGapRight() {
        return gapRight;
    }

    public static builder builder(Component component) {
        return new builder(component);
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public static class builder {

        private final Component component;
        private int width;
        private int gapLeft;
        private int gapRight;
        private boolean resize = true;

        private builder(Component component) {
            this.component = component;
            this.width = (int) this.component.getPreferredSize().getWidth();
        }

        public builder width(int width) {
            this.width = width;
            return this;
        }

        public builder resize(boolean resize) {
            this.resize = resize;
            return this;
        }

        public builder gapLeft(int gapLeft) {
            this.gapLeft = gapLeft;
            return this;
        }

        public builder gapRight(int gapRight) {
            this.gapRight = gapRight;
            return this;
        }

        public HorizontalLayoutComponent build() {
            return new HorizontalLayoutComponent(component, width, gapLeft, gapRight, resize);
        }
    }
}
