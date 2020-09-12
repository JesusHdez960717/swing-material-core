package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.container.layout.VerticalLayoutComponent;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import java.awt.Color;
import java.awt.Font;
import java.util.StringTokenizer;
import javax.swing.SwingConstants;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import java.awt.BorderLayout;

/**
 * Esta clse tiene un prototipo de patron buider en tiempo real
 * <pre>
 * DefaultContentArea c = DefaultContentArea.from().textHorizontalAlignment(SwingConstants.TRAILING);
 *      c.header("header").headerFont(MaterialFontRoboto.THIN_ITALIC);
 *      c.text("123123123123\n12312313\ndfgdfgdfgdg\ndsfgsdfsdf");
 * </pre>
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultContentArea extends ContentArea {

    private Font headerFont = MaterialFontRoboto.BOLD.deriveFont(20);

    private Font textFont = MaterialFontRoboto.REGULAR.deriveFont(16);

    private int textHorizontalAlignment = SwingConstants.LEFT;

    private VerticalLayoutContainer.builder vlcHeader = VerticalLayoutContainer.builder();
    private VerticalLayoutContainer.builder vlcText = VerticalLayoutContainer.builder();

    public static DefaultContentArea from() {
        return new DefaultContentArea();
    }

    protected DefaultContentArea() {
        setLayout(new BorderLayout());
    }

    @Override
    public ContentArea addText(String txt) {
        StringTokenizer stText = new StringTokenizer(txt, "\n");
        while (stText.hasMoreTokens()) {
            String tok = stText.nextToken();
            MaterialLabel label = MaterialLabelsFactory.build();
            label.setHorizontalAlignment(textHorizontalAlignment);
            label.setFont(this.textFont);
            label.setText(tok);
            label.setBackground(getBackground());
            vlcText.add(label, true);
        }
        updatePanel();
        return this;
    }

    private void updatePanel() {
        this.removeAll();
        this.add(vlcHeader.build(), BorderLayout.NORTH);
        this.add(vlcText.build(), BorderLayout.CENTER);
    }

    @Override
    public ContentArea addHeader(String header) {
        StringTokenizer stText = new StringTokenizer(header, "\n");
        while (stText.hasMoreTokens()) {
            String tok = stText.nextToken();
            MaterialLabel label = MaterialLabelsFactory.build();
            label.setHorizontalAlignment(textHorizontalAlignment);
            label.setFont(this.headerFont);
            label.setText(tok);
            label.setBackground(getBackground());
            vlcHeader.add(label, true);
        }
        updatePanel();
        return this;
    }

    @Override
    public ContentArea header(String header) {
        vlcHeader = VerticalLayoutContainer.builder();
        addHeader(header);
        return this;
    }

    @Override
    public ContentArea text(String text) {
        vlcText = VerticalLayoutContainer.builder();
        addText(text);
        return this;
    }

    @Override
    public ContentArea textHorizontalAlignment(int textHorizontalAlignment) {
        this.textHorizontalAlignment = textHorizontalAlignment;
        return this;
    }

    @Override
    public ContentArea headerFont(Font headerFont) {
        this.headerFont = headerFont;
        for (VerticalLayoutComponent component : vlcHeader.components()) {
            component.getComponent().setFont(headerFont);
        }
        return this;
    }

    @Override
    public ContentArea textFont(Font textFont) {
        this.textFont = textFont;
        for (VerticalLayoutComponent component : vlcText.components()) {
            component.getComponent().setFont(textFont);
        }
        return this;
    }

    @Override
    public ContentArea backgroundColor(Color backColor) {
        setBackground(backColor);
        for (VerticalLayoutComponent component : vlcText.components()) {
            component.getComponent().setBackground(backColor);
        }
        for (VerticalLayoutComponent component : vlcHeader.components()) {
            component.getComponent().setBackground(backColor);
        }
        return this;
    }

    public Font getHeaderFont() {
        return headerFont;
    }

    public int getTextHorizontalAlignment() {
        return textHorizontalAlignment;
    }

    public Font getTextFont() {
        return textFont;
    }

}
