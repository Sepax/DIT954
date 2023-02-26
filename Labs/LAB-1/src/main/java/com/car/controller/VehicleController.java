package com.car.controller;

import javax.swing.*;

import com.car.interfaces.ITurbo;
import com.car.model.Saab95;
import com.car.model.Scania;
import com.car.model.Vehicle;
import com.car.model.VehicleFactory;
import com.car.model.VehicleService;
import com.car.model.Volvo240;
import com.car.model.World;
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
