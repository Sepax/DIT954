package com.car.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import com.car.interfaces.IVehicle;
import com.car.interfaces.Observer;
import com.car.model.VehicleService;
import com.car.model.World;

public class TimeListener implements ActionListener {

    private final int delay = 50;
    private World world;
    private VehicleService vehicleService;
    private final List<Observer> observers = new ArrayList<>();
    private Timer timer;

    public TimeListener(World world) {
        this.world = world;
        vehicleService = new VehicleService(world);
        timer = new Timer(delay, this);
    }

    public void actionPerformed(ActionEvent e) {
        for (IVehicle car : world.getVehicles()) {

            if (vehicleService.hasBumpedInWall(
                    car.getX(), 100, 800)) {
                vehicleService.reverseDirection(car);
            }

            car.move();

            for (Observer observer : observers) {
                observer.notify(world.getVehicles());
            }
        }
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void start() {
        timer.start();
    }
}
