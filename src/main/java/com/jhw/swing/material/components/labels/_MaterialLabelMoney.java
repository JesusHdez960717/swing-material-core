package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.root101.utils.others.StringFormating;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialLabelMoney extends MaterialLabelMoney {

    public static MaterialLabelMoney from() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelMoney.class);
    }

    /**
     * Use _MaterialLabel.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialLabelMoney() {
        super();
    }

    @Override
    public void setMoney(BigDecimal value, Object coin) {
        setText("$ " + StringFormating.formatToMoney(value) + " " + coin);
    }

}
