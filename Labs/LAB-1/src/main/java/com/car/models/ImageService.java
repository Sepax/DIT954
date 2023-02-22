package com.car.models;

import javafx.scene.effect.Light.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageService {

    private BufferedImage image;
    private Point point;

    public ImageService(String path, double x, double y) throws IOException {
        setImage(path);
        setPoint(x,y);
    }

    public void setImage(String path) throws IOException {
        image = ImageIO.read(new FileInputStream(path));
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }

    public double getX(){
        return point.getX();
    }

    public double getY(){
        return point.getY();
    }

    public void setPoint(double x, double y){
        point = new Point();
        point.setX(x);
        point.setY(y);
    }

}



