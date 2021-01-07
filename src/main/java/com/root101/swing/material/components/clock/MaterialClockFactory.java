/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.clock;

import com.root101.swing.material.injection.MaterialSwingInjector;
import javax.swing.JComponent;

/**
 * Por el momento los relojes no necesitan injection ni proxy, no tiene sentido
 * usarlos y agregarle capas innecesarias a los componentes
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialClockFactory {

    public static JComponent buildDigitalCircle() {
        return _ClockDigitalCircle.from();
    }

    public static JComponent buildDigitalText() {
        return _ClockDigitalText.from();
    }

    public static JComponent buildClasic() {
        return _ClockFace.from();
    }
}
