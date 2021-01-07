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
package com.root101.swing.material.components.table.editors_renders.money;

import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.labels.MaterialLabelMoney;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.utils.others.StringFormating;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MoneyTableComponent {

    private final BigDecimal money;
    private final String coin;

    public static MoneyTableComponent from(BigDecimal money, Object coin) {
        return new MoneyTableComponent(money, coin.toString());
    }

    public static MoneyTableComponent from(BigDecimal money) {
        return new MoneyTableComponent(money, "");
    }

    public MoneyTableComponent(BigDecimal money, String coin) {
        this.money = money;
        this.coin = coin;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getCoin() {
        return coin;
    }

    public JPanel getRenderComponent() {
        JPanel panel = MaterialContainersFactory.buildPanelGradient();
        panel.setLayout(new GridLayout(1, 1));

        MaterialLabelMoney label = MaterialLabelsFactory.buildMoney();
        label.setFont(UIManager.getFont("Table.font"));
        label.setForeground(UIManager.getColor("Table.selectionForeground"));
        label.setMoney(money, coin);
        label.setHorizontalAlignment(SwingConstants.TRAILING);

        panel.add(label);
        return panel;
    }

    @Deprecated
    public JTextField getEditorComponent() {
        JTextField textField = new JTextField();
        textField.setFont(UIManager.getFont("Table.font"));
        textField.setForeground(UIManager.getColor("Table.selectionForeground"));
        textField.setText(money + "");
        return textField;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MoneyTableComponent other = (MoneyTableComponent) obj;
        if (this.money.equals(other.money)) {
            return false;
        }
        if (!Objects.equals(this.coin, other.coin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return StringFormating.formatToMoney(money, coin);
    }

}
