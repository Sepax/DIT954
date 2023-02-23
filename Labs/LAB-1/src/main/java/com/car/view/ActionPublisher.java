package com.car.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import com.car.models.Vehicle;
import com.car.models.VehicleService;

public class ActionPublisher implements ActionListener {

    private List<Vehicle> cars;
    private VehicleService vehicleService;
    private VehicleView frame;

    public ActionPublisher(List<Vehicle> cars, VehicleView frame) {
        this.cars = cars;
        vehicleService = new VehicleService(cars);
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : cars) {
            try {
                if (vehicleService.hasBumpedInWall(
                        car.getX(),
                        ImageHandler.getImage(frame.drawPanel.vehicles.get(0)).getWidth(),
                        frame.getWidth())) {
                    vehicleService.reverseDirection(car);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            car.move();

            frame.drawPanel.vehicles.forEach(gameObj -> {
                ImageHandler.getPoint(gameObj);
            });

            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
            frame.drawPanel.revalidate();
        }
    }
}
