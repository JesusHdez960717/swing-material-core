package com.jhw.swing.examples.chart;

import com.jhw.swing.chart._MaterialPieChart;
import com.jhw.swing.examples.material.MATERIAL_COLORS_EXAMPLE;
import java.util.Random;
import com.jhw.swing.util.enums.PieChartEnum;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class PIE_NORMAL_EXAMPLE extends _MaterialPieChart {

    public PIE_NORMAL_EXAMPLE() {
        super(PieChartEnum.NORMAL);
        int maxBars = 10;
        Random r = new Random();
        for (int i = 0; i < maxBars; i++) {
            addPiece("name " + r.nextInt(1000), r.nextInt(100), MATERIAL_COLORS_EXAMPLE.getRandomColor());
        }
        //--------------------------------------------------------

        this.getChart().setTitle("Nombre del grafico de pie");
    }

}
