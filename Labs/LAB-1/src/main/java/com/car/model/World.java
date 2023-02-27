package com.car.model;

import java.util.ArrayList;
import java.util.List;

import com.car.interfaces.IVehicle;

public class World {

    List<IVehicle> vehicles;

    public World(List<IVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public World() {
        this(new ArrayList<>());
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

}
