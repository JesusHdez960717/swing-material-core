package com.jhw.swing.examples.chart;

import com.jhw.swing.chart._MaterialLineChart;
import com.jhw.swing.examples.material.MATERIAL_COLORS_EXAMPLE;
import java.util.Random;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LINE_EXAMPLE extends _MaterialLineChart {

    public LINE_EXAMPLE() {
        addSerie("Categoria A", MATERIAL_COLORS_EXAMPLE.getRandomColor());
        addSerie("Categoria B", MATERIAL_COLORS_EXAMPLE.getRandomColor());

        int maxBars = 10;
        Random r = new Random();
        for (int i = 0; i < maxBars; i++) {
            addSpot(r.nextInt(2), r.nextInt(100), r.nextInt(1000));
        }
        //--------------------------------------------------------

        this.getChart().setTitle("Nombre del grafico de linea");
    }

}
