package com.car.interfaces;

import com.car.model.Cargo;
import com.car.model.Vehicle;

public interface ICargo extends IVehicle {

    public Cargo<Vehicle> getCargo();

    public void loadVehicle(Vehicle vehicle);

    public void unloadVehicle();

}
