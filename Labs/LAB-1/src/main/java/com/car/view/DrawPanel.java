package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.ColorModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.car.interfaces.IVehicle;
import com.car.model.Vehicle;
import com.car.model.World;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 */

public class DrawPanel extends JPanel {

    private World world;

    // Initializes the panel and reads the images
    public DrawPanel(World world, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.world = world;

    }

    public World getWorld() {
        return this.world;
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     * It draws the images of the vehicles
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IVehicle vehicle : world.getAllVehicles()) {
            try {
                g.drawImage(ImageHandler.getImage(vehicle.getImagePath()), (int) vehicle.getX(), (int) vehicle.getY(),
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
