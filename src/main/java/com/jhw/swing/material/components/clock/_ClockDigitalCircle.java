package com.jhw.swing.material.components.clock;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.Timer;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _ClockDigitalCircle extends JComponent implements MaterialComponent {

    public static int FPS = 60;

    private Font f = MaterialFontRoboto.BOLD.deriveFont(30f);

    public _ClockDigitalCircle() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(MaterialColors.BLACK);
        this.setForeground(MaterialColors.BLACK);
        this.setFont(f);

        Timer timer = new Timer(1000 / FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _ClockDigitalCircle.this.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void setFont(Font font) {
        this.f = font;
        super.setFont(f);
    }

    @Override
    public Font getFont() {
        return f;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        //hours
        g2.setColor(getBackground());
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        pair pairH = getHourAngle();
        g2.drawArc(5, 5, getWidth() - 10, getWidth() - 10, pairH.start, pairH.arc);

        //minutes
        int diam = (getWidth() - 24);
        int arcX = getWidth() / 2 - diam / 2;
        g2.setColor(getBackground());
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        pair pairM = getMinAngle();
        g2.drawArc(arcX, arcX, diam, diam, pairM.start, pairM.arc);

        //letras
        g2.setColor(getForeground());

        //medio
        Font aux = getFont().deriveFont(getFont().getSize2D() / 3f);
        g2.setFont(aux);
        FontMetrics metricsAux = g.getFontMetrics(aux);
        String AM_PM = Calendar.getInstance().get(Calendar.AM_PM) == 1 ? "PM" : "AM";

        int sec = Calendar.getInstance().get(Calendar.SECOND);
        String text = "- " + AM_PM + " -";
        if (sec % 2 != 0) {
            text = "      ";
        }

        int x = getWidth() / 2 - metricsAux.stringWidth(text) / 2;
        int y = getHeight() / 2 + 3;
        g2.drawString(text, x, y);

        g2.setFont(getFont());
        FontMetrics metrics = g.getFontMetrics(getFont());

        //horas
        String hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) % 12 + "";
        text = hour.length() == 1 ? "0" + hour : hour;
        x = getWidth() / 2 - metrics.stringWidth(text) / 2;
        y = getHeight() / 2 - metricsAux.getAscent() + 3;
        g2.drawString(text, x, y);

        //g2.drawLine(x + 3, getHeight() / 2, x + metrics.stringWidth(text) - 3, getHeight() / 2);
        //minutos
        g2.setFont(getFont());
        String minutes = Calendar.getInstance().get(Calendar.MINUTE) + "";
        text = minutes.length() == 1 ? "0" + minutes : minutes;
        x = getWidth() / 2 - metrics.stringWidth(text) / 2;
        y = getHeight() / 2 + metrics.getAscent() / 2 + metricsAux.getAscent() + 3;
        g2.drawString(text, x, y);
    }

    private pair getHourAngle() {
        int propHour = 360 / 12;
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) % 12;
        int angle = propHour * h;
        if (angle == 0) {
            angle = 1;
        }
        int start;
        if (h >= 0 && h <= 3) {//1er cuadrante
            start = 90 - (propHour * h);
        } else {//resto de los cuadrantes
            start = 360 - ((h - 3) * propHour);
        }
        return new pair(start, angle);
    }

    private pair getMinAngle() {
        int propMin = 360 / 60;
        int m = Calendar.getInstance().get(Calendar.MINUTE) % 60;
        int angle = propMin * m;
        if (angle == 0) {
            angle = 1;
        }
        int start;
        if (m >= 0 && m <= 15) {//1er cuadrante
            start = 90 - (propMin * m);
        } else {//resto de los cuadrantes
            start = 360 - ((m - 15) * propMin);
        }
        return new pair(start, angle);
    }

    private class pair {

        int start, arc;

        public pair(int start, int arc) {
            this.start = start;
            this.arc = arc;
        }
    }
}
