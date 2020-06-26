package com.jhw.swing.examples.chart;

import com.jhw.swing.chart._MaterialLineChart;
import com.jhw.swing.chart._MaterialConvertChar;
import com.jhw.swing.examples.standars.MATERIAL_COLORS_EXAMPLE;
import java.util.Random;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CONVERT_EXAMPLE extends _MaterialConvertChar {

    public CONVERT_EXAMPLE() {
        addSerie("Categoria A", MATERIAL_COLORS_EXAMPLE.getRandomColor());
        addSerie("Categoria B", MATERIAL_COLORS_EXAMPLE.getRandomColor());

        int maxBars = 10;
        Random r = new Random();
        for (int i = 0; i < maxBars; i++) {
            addSpot(r.nextInt(2), r.nextInt(100), r.nextInt(1000));
        }
        //--------------------------------------------------------

        getChart().setChartTitle("Helloo");
        getChart().setXAxisTitle("Las Xs");
        setTitle("Nombre del grafico double");

        //the start position
        this.changeToBars();
    }

}
