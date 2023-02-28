package com.car.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import com.car.interfaces.IVehicle;
import com.car.interfaces.Observer;

public class World implements ActionListener {

    List<IVehicle> vehicles;
    private final int delay = 50;
    private World world;
    private VehicleService vehicleService;
    private final List<Observer> observers = new ArrayList<>();
    private Timer timer;

    public World() {
        this.setVehicles(new ArrayList<>());
        vehicleService = new VehicleService(this);
    }

    public void actionPerformed(ActionEvent e) {
        for (IVehicle car : this.vehicles) {

            if (vehicleService.hasBumpedInWall(
                    car.getX(), 100, 800)) {
                vehicleService.reverseDirection(car);
            }

            car.move();

            for (Observer observer : observers) {
                observer.notify(this.getVehicles());
            }
        }
    }

    public List<IVehicle> getVehicles() {
        return vehicles;
    }

    public <T> List<T> getVehicles(Class<T> c) throws ClassCastException {
        List<T> list = new ArrayList<>();
        for (IVehicle vehicle : vehicles) {
            if (c.isAssignableFrom(vehicle.getClass())) {
                list.add(c.cast(vehicle));
            }
        }
        return list;
    }

    public void addVehicle(IVehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void setVehicles(List<IVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void removeVehicle(IVehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void start() {
        timer = new Timer(delay, this);
        timer.start();
    }

}
