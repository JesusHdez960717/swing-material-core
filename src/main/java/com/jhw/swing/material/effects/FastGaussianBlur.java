package com.jhw.swing.material.effects;

import com.twelvemonkeys.image.ConvolveWithEdgeOp;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;

/**
 * Implementarion of a FastGaussinBlur to blur an specific Buffered image. It's
 * used to make shadow for the material-base components.<\br>
 * Use {@link ConvolveWithEdgeOp} to the better performance blur on the edges.
 *
 * @author Book Filthy Rich Clients QA76.73.C153H33 2007 at page. 431
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FastGaussianBlur {

    public static BufferedImage blur(BufferedImage image, double radius) {
        image = getGaussianBlurFilter((float) radius, true)
                .filter(image, null);
        image = getGaussianBlurFilter((float) radius, false)
                .filter(image, null);
        return image;
    }

    public static ConvolveWithEdgeOp getGaussianBlurFilter(float radius,
            boolean horizontal) {
        radius++;
        int radiusInt = (int) Math.ceil(radius);
        int size = radiusInt * 2 + 1;
        float[] data = new float[size];
        float sigma = radius / 3.0f;
        float twoSigmaSquare = 2.0f * sigma * sigma;
        float sigmaRoot = (float) Math.sqrt(twoSigmaSquare * Math.PI);
        float total = 0.0f;
        for (int i = -radiusInt; i <= radiusInt; i++) {
            float distance = i * i;
            int index = i + radiusInt;
            data[index] = (float) Math.exp(-distance / twoSigmaSquare)
                    / sigmaRoot;
            total += data[index];
        }
        for (int i = 0; i < data.length; i++) {
            data[i] /= total;
        }
        Kernel kernel = null;
        if (horizontal) {
            kernel = new Kernel(size, 1, data);
        } else {
            kernel = new Kernel(1, size, data);
        }
        return new ConvolveWithEdgeOp(kernel, ConvolveWithEdgeOp.EDGE_REFLECT, null);
    }

}
