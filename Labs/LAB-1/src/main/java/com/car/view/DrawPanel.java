package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.car.models.ImageService;
import com.car.models.Vehicle;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 */

public class DrawPanel extends JPanel {

    ArrayList<ImageService> imageServices;

    public void updateImagePositions(ArrayList<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            imageServices.get(i).setPoint(vehicles.get(i).getX(), vehicles.get(i).getY());
        }
    }


    // Initializes the panel and reads the images
    public DrawPanel(ArrayList<Vehicle> vehicles, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.orange);
        // Print an error message in case file is not found with a try/catch block
        try {
            String assetsFacing = System.getProperty("user.dir") + "/assets/";
            imageServices = new ArrayList<>();

            for (Vehicle vehicle : vehicles) {
                imageServices.add(new ImageService(assetsFacing + vehicle.getImage(), vehicle.getX(), vehicle.getY()));
            }

        } catch (IOException ex) {
            System.err.println("Image not found");
        }
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     * It draws the images of the vehicles
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ImageService image : imageServices) {
            int roundedX = (int) Math.round(image.getX());
            int roundedY = (int) Math.round(image.getY());
            g.drawImage(image.getImage(), roundedX, roundedY, null);
        }
    }
}
