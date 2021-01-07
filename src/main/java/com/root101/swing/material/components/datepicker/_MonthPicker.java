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
package com.root101.swing.material.components.datepicker;

import com.root101.swing.material.injection.MaterialSwingInjector;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Hay que usar _Month xq el java.time.Month tiene los meses como enum en
 * ingles, x lo que hay que usar un wrapper y sobreescribir el toString
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MonthPicker extends MaterialMonthPicker {

    public static _MonthPicker from() {
        return MaterialSwingInjector.getImplementation(_MonthPicker.class);
    }

    public _MonthPicker() {
        setMonths();
        setLabel("Mes");
    }

    private void setMonths() {
        List<_Month> model = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            model.add(_Month.from(i));
        }
        setModel(model);
        this.setSelectedItem(_Month.from(Month.from(YearMonth.now()).getValue()));
    }

}
