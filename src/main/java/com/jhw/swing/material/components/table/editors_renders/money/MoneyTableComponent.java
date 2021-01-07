package com.jhw.swing.material.components.table.editors_renders.money;

import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.labels.MaterialLabelMoney;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
