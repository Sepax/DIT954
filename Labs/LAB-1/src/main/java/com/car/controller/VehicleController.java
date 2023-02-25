package com.car.controller;

import javax.swing.*;

import com.car.interfaces.ITurbo;
import com.car.models.Saab95;
import com.car.models.Scania;
import com.car.models.Vehicle;
import com.car.models.VehicleFactory;
import com.car.models.VehicleService;
import com.car.models.Volvo240;
import com.car.models.World;
import com.car.view.VehicleView;

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
    private Timer timer;
    VehicleView frame;

    public VehicleController(VehicleView frame, World world) {
        this.frame = frame;
        new EventHandler(frame, world);
        this.timer = new Timer(delay, new TimeListener(world, frame));
    }

    public void startController() {
        this.timer.start();
    }

    public VehicleView getVehicleView() {
        return this.frame;
    }

}
