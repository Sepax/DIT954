package com.car.view;

import javax.swing.*;

import com.car.models.Saab95;
import com.car.models.Scania;
import com.car.models.Vehicle;
import com.car.models.VehicleService;
import com.car.models.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Controller part in the MVC pattern.
 * It contains a Timer that updates the car's position.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 * @param frame The frame that represents this instance View of the MVC pattern
 * @param cars  A list of cars
 * @param delay The delay (ms) corresponds to 20 updates a sec (hz)
 * @param timer The timer is started with an listener that executes the
 *              statements
 * @param cc    A object of the CarController class
 * 
 */

public class VehicleController {

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    VehicleView frame;
    List<Vehicle> cars = new ArrayList<>();
    private EventHandler eventHandler;
    private VehicleService vehicleService;

    public VehicleController(VehicleView frame, List<Vehicle> cars) {
        this.cars = cars;
        this.frame = frame;
        EventHandler eventHandler = new EventHandler(frame, cars);
        this.vehicleService = new VehicleService(cars);
    }

    public void startController() {
        this.timer.start();
    }

    private class TimerListener implements ActionListener {
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

}
