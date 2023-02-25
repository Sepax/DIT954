package com.car.models;

import com.car.interfaces.ITurbo;
import com.car.interfaces.ITurboVehicle;

public class VehicleFactory {

    public static final Vehicle createVolvo240(double x, double y) {
        return new Volvo240(new Position(x, y));
    }

    public static final ITurboVehicle createSaab95(double x, double y) {
        return new Saab95(new Position(x, y));
    }

    public static final Vehicle createScania(double x, double y) {
        return new Scania(new Position(x, y));
    }

}
