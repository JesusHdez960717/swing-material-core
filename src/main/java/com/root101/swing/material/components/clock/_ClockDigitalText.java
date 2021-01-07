/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.clock;

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
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.interfaces.MaterialComponent;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _ClockDigitalText extends JComponent implements MaterialComponent {

    public static int FPS = 60;

    public static _ClockDigitalText from() {
        return new _ClockDigitalText();
    }

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
