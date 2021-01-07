/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
