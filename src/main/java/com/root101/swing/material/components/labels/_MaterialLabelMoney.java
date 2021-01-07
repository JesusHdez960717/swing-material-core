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

import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.utils.others.StringFormating;
import java.math.BigDecimal;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
