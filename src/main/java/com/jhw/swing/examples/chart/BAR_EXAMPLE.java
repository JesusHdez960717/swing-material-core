package com.jhw.swing.examples.chart;

import com.jhw.swing.chart._MaterialBarChart;
import com.jhw.swing.examples.standars.MATERIAL_COLORS_EXAMPLE;
import java.util.Random;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class BAR_EXAMPLE extends _MaterialBarChart {

    public BAR_EXAMPLE() {
        addCategory("Categoria A", MATERIAL_COLORS_EXAMPLE.getRandomColor());
        addCategory("Categoria B", MATERIAL_COLORS_EXAMPLE.getRandomColor());

        int maxBars = 10;
        Random r = new Random();
        for (int i = 0; i < maxBars; i++) {
            addBar(r.nextInt(100), r.nextInt(2), "name " + r.nextInt(1000));
        }
        //--------------------------------------------------------

        this.getChart().setTitle("Nombre del grafico de barras");
    }

}
