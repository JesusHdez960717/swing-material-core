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
public class VerticalLayoutComponent implements Validable {

    @NotNull
    private Component component;

    @PositiveOrZero
    private int height;

    @PositiveOrZero
    private int gapTop;

    @PositiveOrZero
    private int gapDown;

    private boolean resize;

    public VerticalLayoutComponent(Component component, int height, int gapTop, int gapDown, boolean resize) {
        this.component = component;
        this.height = height;
        this.gapTop = gapTop;
        this.gapDown = gapDown;
        this.resize = resize;
        validate();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = new ValidationResult();
        v.checkFromAnnotations(this);
        return v.throwException();
    }

    public Component getComponent() {
        return component;
    }

    public boolean isResize() {
        return resize;
    }

    public int getHeight() {
        return height;
    }

    public int getGapTop() {
        return gapTop;
    }

    public int getGapDown() {
        return gapDown;
    }

    public static builder builder(Component component) {
        return new builder(component);
    }

    public static class builder {

        private final Component component;
        private int height;
        private int gapTop;
        private int gapDown;
        private boolean resize;

        private builder(Component component) {
            this.component = component;
            this.height = (int) this.component.getPreferredSize().getHeight();
        }

        public builder height(int height) {
            this.height = height;
            return this;
        }

        public builder resize(boolean resize) {
            this.resize = resize;
            return this;
        }

        public builder gapTop(int gapTop) {
            this.gapTop = gapTop;
            return this;
        }

        public builder gapDown(int gapDown) {
            this.gapDown = gapDown;
            return this;
        }

        public VerticalLayoutComponent build() {
            return new VerticalLayoutComponent(component, height, gapTop, gapDown, resize);
        }
    }
}
