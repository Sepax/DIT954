package com.car.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import com.car.interfaces.IVehicle;
import com.car.models.Vehicle;
import com.car.models.VehicleService;
import com.car.models.World;
import com.car.view.ImageHandler;
import com.car.view.VehicleView;

public class TimeListener implements ActionListener {

    private World world;
    private VehicleService vehicleService;
    private VehicleView frame;

    public TimeListener(World world, VehicleView frame) {
        this.world = world;
        vehicleService = new VehicleService(world);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        for (IVehicle car : world.getAllVehicles()) {
            try {
                if (vehicleService.hasBumpedInWall(
                        car.getX(),
                        ImageHandler.getImage(frame.getDrawPanel().getWorld().getAllVehicles().get(0).getImagePath())
                                .getWidth(),
                        frame.getWidth())) {
                    vehicleService.reverseDirection(car);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            car.move();

            frame.getDrawPanel().getWorld().getAllVehicles().forEach(gameObj -> {
                ImageHandler.getPoint(gameObj);
            });

            // repaint() calls the paintComponent method of the panel
            frame.getDrawPanel().repaint();
            frame.getDrawPanel().revalidate();
        }
    }
}
