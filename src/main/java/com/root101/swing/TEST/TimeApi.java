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
package com.root101.swing.TEST;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TimeApi {

    public static void main(String args[]) {
        System.out.println("Date");
        Date date = new Date();
        System.out.println(date);
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));

        System.out.println("\nLocal Date");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate));
    }
}
