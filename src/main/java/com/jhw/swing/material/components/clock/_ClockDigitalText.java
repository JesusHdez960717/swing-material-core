package com.jhw.swing.material.components.clock;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _ClockDigitalText extends JComponent implements MaterialComponent {

    public static int FPS = 60;

    public _ClockDigitalText() {
        this.setPreferredSize(new Dimension(200, 40));
        this.setBackground(MaterialColors.BLACK);
        this.setForeground(MaterialColors.BLACK);
        this.setFont(MaterialFontRoboto.BOLD.deriveFont(30f));

        Timer timer = new Timer(1000 / FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _ClockDigitalText.this.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        String hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) % 12 + "";
        String text = hour.length() == 1 ? "0" + hour : hour;

        int sec = Calendar.getInstance().get(Calendar.SECOND);

        text += ":";

        String minutes = Calendar.getInstance().get(Calendar.MINUTE) + "";
        text += minutes.length() == 1 ? "0" + minutes : minutes;

        text += ":";

        String seconds = sec + "";
        text += seconds.length() == 1 ? "0" + seconds : seconds;

        text += "  ";
        FontMetrics metrics = g2.getFontMetrics(getFont());
        int x = getWidth() / 2 - metrics.stringWidth(text) / 2;
        int y = getHeight() / 2 + metrics.getAscent() / 2;
        g2.drawString(text, x, y);

        Font aux = getFont().deriveFont(getFont().getSize2D() / 2f);
        g2.setFont(aux);

        String text2 = text.substring(0, text.length() - 2);
        FontMetrics fm = g2.getFontMetrics(getFont());

        String AM_PM = Calendar.getInstance().get(Calendar.AM_PM) == 1 ? "PM" : "AM";
        g2.drawString(AM_PM, x + fm.stringWidth(text2), getHeight() / 2 + fm.getAscent() / 2);
    }
}
