package com.car.models;

public class VehicleFactory {

    public static Vehicle createVolvo240(double x, double y) {
        return new Volvo240(new Position(x, y));
    }

    public static Vehicle createSaab95(double x, double y) {
        return new Saab95(new Position(x, y));
    }

    public static Vehicle createScania(double x, double y) {
        return new Scania(new Position(x, y));
    }

}
