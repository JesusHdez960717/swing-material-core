/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.datepicker;

import com.root101.swing.material.components.textfield.TextMaxLength;
import com.root101.swing.material.effects.FloatingLabel;
import com.root101.swing.material.effects.Line;
import com.root101.swing.material.effects.Wrong;
import com.root101.swing.util.interfaces.BindableComponent;
import com.root101.swing.util.interfaces.DateSelected;
import com.root101.swing.util.interfaces.MaterialComponent;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialDatePickerDefinition extends TextMaxLength, DateSelected, BindableComponent<LocalDate>, FloatingLabel, Line, Wrong, MaterialComponent {
    
    public void setLowerBound(Date lower);

    public void setUpperBound(Date upper);
}
