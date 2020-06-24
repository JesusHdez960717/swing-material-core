package com.jhw.swing.material.components.table.editors_renders.money;

import com.jhw.swing.material.components.container.panels._PanelGradient;
import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.GridLayout;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MoneyTableComponent {

    private final float money;
    private final String coin;

    public MoneyTableComponent(float money, String coin) {
        this.money = money;
        this.coin = coin;
    }

    public float getMoney() {
        return money;
    }

    public String getCoin() {
        return coin;
    }

    public _PanelGradient getRenderComponent() {
        _PanelGradient panel = new _PanelGradient();
        panel.setLayout(new GridLayout(1, 1));

        _MaterialLabel label = new _MaterialLabel();
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
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Float.floatToIntBits(this.money);
        hash = 79 * hash + Objects.hashCode(this.coin);
        return hash;
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
        if (Float.floatToIntBits(this.money) != Float.floatToIntBits(other.money)) {
            return false;
        }
        if (!Objects.equals(this.coin, other.coin)) {
            return false;
        }
        return true;
    }

}
