package com.jhw.swing.material.standars;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * Coleccion de imagenes utiles para el diseño.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialImages {

    public static final BufferedImage TOGGLE_BUTTON_OFF = loadImg("/imgs/toggle_off.png");
    public static final BufferedImage TOGGLE_BUTTON_ON = loadImg("/imgs/toggle_on.png");
    public static final BufferedImage ERROR = loadImg("/imgs/error.png");
    public static final BufferedImage CREATE = loadImg("/imgs/create.png");
    public static final BufferedImage EDIT = loadImg("/imgs/edit.png");
    public static final BufferedImage WARNING = loadImg("/imgs/warning.png");
    public static final BufferedImage QUESTION = loadImg("/imgs/question.png");
    public static final BufferedImage INFORMATION = loadImg("/imgs/information.png");

    private MaterialImages() {
    }

    public static BufferedImage loadImg(String imgPath) {
        try (InputStream inputStream = MaterialImages.class.getResourceAsStream(imgPath)) {
            return ImageIO.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Image " + imgPath + " wasn't loaded");
        }
    }
}
