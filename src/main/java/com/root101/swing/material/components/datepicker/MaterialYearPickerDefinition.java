/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.datepicker;

import com.root101.swing.material.effects.FloatingLabel;
import com.root101.swing.material.effects.Line;
import com.root101.swing.material.effects.Wrong;
import com.root101.swing.util.interfaces.BindableComponent;
import com.root101.swing.util.interfaces.MaterialComponent;
import java.time.Year;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialYearPickerDefinition extends Line, FloatingLabel, BindableComponent<Year>, Wrong, MaterialComponent {

    public Year getMinYear();

    public void setMinYear(Year minYear);

    public Year getMaxYear();

    public void setMaxYear(Year maxYear);

}
