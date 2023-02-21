package com.car.models;

public class VehicleFactory {

    public Vehicle createVolvo240() {
        return new Volvo240(null);
    }

    public Vehicle createSaab95() {
        return new Saab95(null);
    }

    public Vehicle createScania() {
        return new Scania(null);
    }
    
}
