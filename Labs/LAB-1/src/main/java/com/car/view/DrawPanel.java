package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.*;

import com.car.models.Vehicle;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 */

public class DrawPanel extends JPanel {

    public List<Vehicle> vehicles;
    private BufferedImage vehicleImage;

    // Initializes the panel and reads the images
    public DrawPanel(List<Vehicle> cars, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.orange);
        this.vehicles = cars;

    }

    private void updateVehicleImage(Vehicle vehicle) {
        vehicleImage = vehicle.getVehicleImage();
    }


    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     * It draws the images of the vehicles
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : vehicles) {
            updateVehicleImage(vehicle);
            g.drawImage(vehicleImage, (int) vehicle.getX(), (int) vehicle.getY(), null);
        }
    }
}
