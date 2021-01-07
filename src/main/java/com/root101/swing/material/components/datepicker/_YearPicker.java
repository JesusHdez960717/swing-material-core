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
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _YearPicker extends MaterialYearPicker {

    public static _YearPicker from() {
        return MaterialSwingInjector.getImplementation(_YearPicker.class);
    }

    private Year minYear = Year.now().minusYears(10);
    private Year maxYear = Year.now().plusYears(10);

    public _YearPicker() {
        setYears();
        setLabel("Año");
    }

    private void setYears() {
        List<Year> model = new ArrayList<>();
        for (Year i = minYear; i.isBefore(maxYear); i = i.plusYears(1)) {
            model.add(Year.parse(String.valueOf(i)));
        }
        setModel(model);
        this.setSelectedItem(Year.now());
    }

    @Override
    public Year getMinYear() {
        return minYear;
    }

    @Override
    public void setMinYear(Year minYear) {
        this.minYear = minYear;
        this.setYears();
        this.setSelectedItem(minYear);
    }

    @Override
    public Year getMaxYear() {
        return maxYear;
    }

    @Override
    public void setMaxYear(Year maxYear) {
        this.maxYear = maxYear;
        this.setYears();
    }

}
