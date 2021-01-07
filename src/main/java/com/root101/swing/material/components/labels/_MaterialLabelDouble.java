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
package com.root101.swing.material.components.labels;

import com.root101.utils.interfaces.Update;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialLabelDouble extends MaterialLabelDoble implements Update {

    public static MaterialLabelDoble from() {
        return new _MaterialLabelDouble();
    }

    public _MaterialLabelDouble() {
        initComponents();
    }

    private void initComponents() {
        labelLeft = MaterialLabelsFactory.build();
        labelLeft.setText("Left");
        labelLeft.setFont(labelLeft.getFont().deriveFont(18));

        labelRigth = MaterialLabelsFactory.build();
        labelRigth.setText("Rigth");
        labelRigth.setFont(labelRigth.getFont().deriveFont(20));
        labelRigth.setHorizontalAlignment(SwingConstants.RIGHT);
        update();
    }

    private MaterialLabel labelLeft;
    private MaterialLabel labelRigth;

    @Override
    public void update() {
        this.removeAll();
        this.setLayout(new BorderLayout());

        this.add(labelLeft, BorderLayout.WEST);
        this.add(labelRigth, BorderLayout.CENTER);
    }

    @Override
    public void setLeftText(String text) {
        this.labelLeft.setText(text);
    }

    @Override
    public void setRigthText(String text) {
        this.labelRigth.setText(text);
    }

    @Override
    public String getRigthText() {
        return labelRigth.getObject();
    }

    @Override
    public String getLeftText() {
        return labelLeft.getObject();
    }

    @Override
    public void setLabelRigth(MaterialLabel labelRigth) {
        this.labelRigth = labelRigth;
        this.labelRigth.setHorizontalAlignment(SwingConstants.TRAILING);
        update();
    }

    @Override
    public void setLabelLeft(MaterialLabel labelLeft) {
        this.labelLeft = labelLeft;
        this.labelLeft.setHorizontalAlignment(SwingConstants.LEADING);
        update();
    }

    public MaterialLabel getLabelRigth() {
        return labelRigth;
    }

    public MaterialLabel getLabelLeft() {
        return labelLeft;
    }

}
