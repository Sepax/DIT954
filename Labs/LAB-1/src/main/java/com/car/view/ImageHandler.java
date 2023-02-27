package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.ColorModel;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.car.interfaces.IVehicle;

public interface ImageHandler {

    public static Point getPoint(IVehicle vehicle) {
        Point point = new Point();
        point.x = (int) Math.round(vehicle.getX());
        point.x = (int) Math.round(vehicle.getY());
        return point;
    }

    public static BufferedImage getImage(String path) throws IOException {
        String assetsFacing = System.getProperty("user.dir");
        BufferedImage vehicleImage = ImageIO.read(new FileInputStream(assetsFacing + "/" + path));
        ColorModel cm = vehicleImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = vehicleImage.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
