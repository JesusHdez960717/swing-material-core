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
package com.root101.swing.util;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Avatar usado en el _PanelAvatarChooser.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class AvatarPanelAvatarChooser {

    public static final String PROP_ID = "id";
    public static final String PROP_IMAGE = "Image";
    public static final String PROP_TITULO = "titulo";
    protected String id;
    protected Image image;
    protected String titulo;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public AvatarPanelAvatarChooser(String id) {
        this.id = id;
    }

    public AvatarPanelAvatarChooser(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public AvatarPanelAvatarChooser(String id, String titulo, Image image) {
        this.id = id;
        this.image = image;
        this.titulo = titulo;
    }

    public AvatarPanelAvatarChooser(String id, String titulo, String image) {
        this.id = id;
        this.titulo = titulo;
        this.image = loadImage(image);
    }

    public AvatarPanelAvatarChooser(String titulo, Image image) {
        this.titulo = titulo;
        this.image = image;
    }

    public AvatarPanelAvatarChooser(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        Image oldImage = this.image;
        this.image = image;
        this.propertyChangeSupport.firePropertyChange(PROP_IMAGE, oldImage, image);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        this.propertyChangeSupport.firePropertyChange(PROP_TITULO, oldTitulo, titulo);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        this.propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private Image loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (Exception e) {
            return null;
        }
    }
}
