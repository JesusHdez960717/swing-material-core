package com.jhw.swing.util.icons.icon_svg;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import lombok.Getter;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.TranscodingHints;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.util.SVGConstants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import com.jhw.swing.util.icons.DerivableIcon;
import org.apache.batik.anim.dom.SVGDOMImplementation;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class IconSVG extends DerivableIcon {

    public static final byte[] BROKEN_IMAGE_DATA = new byte[]{60, 115, 118, 103, 32, 120, 109, 108, 110, 115, 61, 34, 104, 116, 116, 112, 58, 47, 47, 119, 119, 119, 46, 119, 51, 46, 111, 114, 103, 47, 50, 48, 48, 48, 47, 115, 118, 103, 34, 32, 119, 105, 100, 116, 104, 61, 34, 50, 52, 34, 32, 104, 101, 105, 103, 104, 116, 61, 34, 50, 52, 34, 32, 118, 105, 101, 119, 66, 111, 120, 61, 34, 48, 32, 48, 32, 50, 52, 32, 50, 52, 34, 62, 10, 32, 32, 32, 32, 60, 112, 97, 116, 104, 32, 102, 105, 108, 108, 61, 34, 110, 111, 110, 101, 34, 32, 100, 61, 34, 77, 48, 32, 48, 104, 50, 52, 118, 50, 52, 72, 48, 122, 109, 48, 32, 48, 104, 50, 52, 118, 50, 52, 72, 48, 122, 109, 50, 49, 32, 49, 57, 99, 48, 32, 49, 46, 49, 45, 46, 57, 32, 50, 45, 50, 32, 50, 72, 53, 99, 45, 49, 46, 49, 32, 48, 45, 50, 45, 46, 57, 45, 50, 45, 50, 86, 53, 99, 48, 45, 49, 46, 49, 46, 57, 45, 50, 32, 50, 45, 50, 104, 49, 52, 99, 49, 46, 49, 32, 48, 32, 50, 32, 46, 57, 32, 50, 32, 50, 34, 47, 62, 10, 32, 32, 32, 32, 60, 112, 97, 116, 104, 32, 102, 105, 108, 108, 61, 34, 110, 111, 110, 101, 34, 32, 100, 61, 34, 77, 48, 32, 48, 104, 50, 52, 118, 50, 52, 72, 48, 122, 34, 47, 62, 10, 32, 32, 32, 32, 60, 112, 97, 116, 104, 32, 100, 61, 34, 77, 50, 49, 32, 53, 118, 54, 46, 53, 57, 108, 45, 51, 45, 51, 46, 48, 49, 45, 52, 32, 52, 46, 48, 49, 45, 52, 45, 52, 45, 52, 32, 52, 45, 51, 45, 51, 46, 48, 49, 86, 53, 99, 48, 45, 49, 46, 49, 46, 57, 45, 50, 32, 50, 45, 50, 104, 49, 52, 99, 49, 46, 49, 32, 48, 32, 50, 32, 46, 57, 32, 50, 32, 50, 122, 109, 45, 51, 32, 54, 46, 52, 50, 108, 51, 32, 51, 46, 48, 49, 86, 49, 57, 99, 48, 32, 49, 46, 49, 45, 46, 57, 32, 50, 45, 50, 32, 50, 72, 53, 99, 45, 49, 46, 49, 32, 48, 45, 50, 45, 46, 57, 45, 50, 45, 50, 118, 45, 54, 46, 53, 56, 108, 51, 32, 50, 46, 57, 57, 32, 52, 45, 52, 32, 52, 32, 52, 32, 52, 45, 51, 46, 57, 57, 122, 34, 47, 62, 10, 60, 47, 115, 118, 103, 62, 10};

    /**
     * Se tiene que usar un arreglo de byte generico porque el input stream no
     * se deja leer varias veces, y crear un IS nuevo de un FIle o un String se
     * dificulta a la hora de diferenciar entre un resource interno y un fichero
     * externo.
     */
    private byte[] data;

    @Getter
    private Color color = null;

    @Getter
    private float w = 24f;

    @Getter
    private float h = 24f;

    public IconSVG(ImageIcon icon) {
        super(icon.getImage());
    }

    public IconSVG(Image icon) {
        super(icon);
    }

    public IconSVG(BufferedImage icon) {
        super(icon);
    }

    private IconSVG(ImageIcon icon, byte[] data, Color color, float w, float h) {
        super(icon.getImage());
        this.data = data;
        this.color = color;
        this.w = w;
        this.h = h;
    }

    public IconSVG(byte[] data) {
        this.data = data;
        loadInitialImage();
    }

    public IconSVG(InputStream is) {
        copyIS(is);
        loadInitialImage();
    }

    public IconSVG(File file) {
        try {
            copyIS(new FileInputStream(file));
        } catch (Exception e) {
            copyIS(null);
        }
        loadInitialImage();
    }

    public IconSVG(String file) {
        try {
            copyIS(new FileInputStream(new File(file)));
        } catch (Exception e) {
            copyIS(null);
        }
        loadInitialImage();
    }

    private void loadInitialImage() {
        ImageIcon rasterizedIcon = new ImageIcon();
        try {
            rasterizedIcon = rasterizeIcon(data, w, h, color);
        } catch (Exception e) {
            try {
                rasterizedIcon = rasterizeIcon(BROKEN_IMAGE_DATA, w, h, color);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        super.setImage(rasterizedIcon.getImage());
    }

    @Override
    public IconSVG deriveIcon(Color color) {
        return buildIcon(data, color, w, h);
    }

    @Override
    public IconSVG deriveIcon(float size) {
        return buildIcon(data, color, size, size);
    }

    public IconSVG deriveIcon(float w, float h) {
        return buildIcon(data, color, w, h);
    }

    private IconSVG buildIcon(byte[] data, Color color, float w, float h) {
        ImageIcon rasterizedIcon = new ImageIcon();
        try {
            rasterizedIcon = rasterizeIcon(data, w, h, color);
        } catch (Exception e) {
            try {
                rasterizedIcon = rasterizeIcon(BROKEN_IMAGE_DATA, w, h, color);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new IconSVG(rasterizedIcon, data, color, w, h);
    }

    public static ImageIcon rasterizeIcon(byte[] data, float w, float h, Color c) throws Exception {
        final BufferedImage[] imagePointer = new BufferedImage[1];

        TranscodingHints transcoderHints = new TranscodingHints();

        transcoderHints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, Boolean.FALSE);
        transcoderHints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION,
                SVGDOMImplementation.getDOMImplementation());
        transcoderHints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI,
                SVGConstants.SVG_NAMESPACE_URI);
        transcoderHints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG);
        transcoderHints.put(ImageTranscoder.KEY_WIDTH, w);
        transcoderHints.put(ImageTranscoder.KEY_HEIGHT, h);

        //por defecto no deriva a un color
        if (c != null) {
            // Todas las propiedades desiponibles en: SVGConstants
            String css = "svg {"
                    + "shape-rendering: geometricPrecision;"
                    + "text-rendering:  geometricPrecision;"
                    + "color-rendering: optimizeQuality;"
                    + "image-rendering: optimizeQuality;"
                    + "fill: " + String.format("#%02x%02x%02x;", c.getRed(), c.getGreen(), c.getBlue())
                    + "fill-opacity: " + (c.getAlpha() / 255f) + ";"
                    + "}";
            File cssFile = new File("css_batick_default_override.css");
            cssFile.createNewFile();
            FileUtils.writeStringToFile(cssFile, css);
            transcoderHints.put(ImageTranscoder.KEY_USER_STYLESHEET_URI, cssFile.toURI().toString());
        }

        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(data));

        ImageTranscoder t = new ImageTranscoder() {

            @Override
            public BufferedImage createImage(int w, int h) {
                return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            }

            @Override
            public void writeImage(BufferedImage image, TranscoderOutput out)
                    throws TranscoderException {
                imagePointer[0] = image;
            }
        };
        t.setTranscodingHints(transcoderHints);
        t.transcode(input, null);

        return new ImageIcon(imagePointer[0]);
    }

    /**
     * Duplicate the IS data to avoid close exception when reeding twice
     *
     * @param is The InputStream to copy to the data byte array.
     */
    private void copyIS(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            IOUtils.copy(is, baos);
            this.data = baos.toByteArray();
        } catch (Exception ex) {
            this.data = new byte[BROKEN_IMAGE_DATA.length];
            System.arraycopy(BROKEN_IMAGE_DATA, 0, data, 0, BROKEN_IMAGE_DATA.length);
        }
    }
}
