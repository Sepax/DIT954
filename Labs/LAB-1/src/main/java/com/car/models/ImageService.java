package com.car.models;

import javafx.scene.effect.Light.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageService {

    private BufferedImage image;

    public ImageService(String path) throws IOException {
        setImage(path);
    }

    public void setImage(String path) throws IOException {
        image = ImageIO.read(new FileInputStream(path));
    }

    public BufferedImage getImage() {
        return image;
    }

}



