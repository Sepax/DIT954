package com.car.models;

import java.awt.Color;

import com.car.models.Ramp.RampState;

/**
 * The class `Ferry` represents a ferry that can transport vehicles.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 */
public class Ferry extends Vehicle {
    private Cargo<Vehicle> cargo;
    private Ramp ramp;

    /**
     * Creates a new `Ferry` object with default values.
     * 
     * @param capacity The capacity of the ferry.
     * 
     */
    public Ferry(Position position) {
        super(2, Color.ORANGE, 1300, 30000, "CarFerry", Facing.EAST, position);
        this.cargo = new Cargo<>(5000, 30);
        this.ramp = new Ramp();
    }

    public Cargo<Vehicle> getCargo() {
        return cargo;
    }

    public Ramp getRamp() {
        return ramp;
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            ramp.raiseRamp();
        }
    }

    public void lowerRamp() {
        if (currentSpeed == 0) {
            ramp.lowerRamp();
        }
    }

    public void loadVehicle(Vehicle vehicle) {
        if (ramp.toString().equals(RampState.RAISED.toString())) {
            return;
        }
        cargo.push(vehicle);
    }

    public void unloadVehicle() {
        if (ramp.toString().equals(RampState.RAISED.toString())) {
            return;
        }
        cargo.removeLast();
    }

    @Override
    public void move() {
        if (ramp.toString().equals(RampState.LOWERED.toString())) {
            return;
        }
        super.move();

        for (Vehicle vehicle : cargo.getContent()) {
            vehicle.setX(this.getX());
            vehicle.setY(this.getY());
        }
    }
}
