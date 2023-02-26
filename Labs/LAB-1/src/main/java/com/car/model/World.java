package com.car.model;

import java.util.ArrayList;
import java.util.List;

import com.car.interfaces.ITurboVehicle;
import com.car.interfaces.IVehicle;

public class World {

    List<IVehicle> vehicles;
    List<ITurboVehicle> turboVehicles;

    public World() {
        this.vehicles = new ArrayList<>();
        this.turboVehicles = new ArrayList<>();
    }

    public List<IVehicle> getNonTurboVehicles() {
        return vehicles;
    }

    public void setVehicles(List<IVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<ITurboVehicle> getTurboVehicles() {
        return turboVehicles;
    }

    public void setTurboVehicles(List<ITurboVehicle> turboVehicles) {
        this.turboVehicles = turboVehicles;
    }

    public void addVehicle(IVehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addTurboVehicle(ITurboVehicle vehicle) {
        this.turboVehicles.add(vehicle);
    }

    public List<IVehicle> getAllVehicles() {
        List<IVehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(vehicles);
        allVehicles.addAll(turboVehicles);
        return allVehicles;
    }

    public void removeVehicle(IVehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void removeTurboVehicle(ITurboVehicle vehicle) {
        this.turboVehicles.remove(vehicle);
    }

}
