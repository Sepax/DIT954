package com.car.view;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import com.car.interfaces.IVehicle;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 */

public class DrawPanel extends JPanel {

    List<IVehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(List<IVehicle> vehicles, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.vehicles = vehicles;

    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     * It draws the images of the vehicles
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IVehicle vehicle : vehicles) {
            try {
                g.drawImage(ImageHandler.getImage(vehicle.getImagePath()), (int) vehicle.getX(), (int) vehicle.getY(),
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
