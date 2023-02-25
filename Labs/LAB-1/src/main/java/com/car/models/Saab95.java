package com.car.models;

import java.awt.Color;

import com.car.interfaces.ITurbo;
import com.car.interfaces.ITurboVehicle;

/**
 * Saab95 is a class that represents a Saab95 car and extends the Vehicle class.
 * It has a turbo feature that can be turned on or off, which affects the
 * speedfactor.
 * 
 * @author Kiril Curlinov, Gabriele Frattini, Sebastian Pålsson
 * @param turbo the turbo feature of the car
 */
public class Saab95 extends Vehicle implements ITurboVehicle {
    private Turbo turbo;

    /**
     * Constructs a new Saab95 object with default values.
     * The turbo feature is initially off.
     */
    public Saab95(Position position) {
        super(2, Color.red, 135, 1600, "Saab95", Facing.EAST, position, "assets/Saab95.jpg");
        turbo = new Turbo();
    }

    public void enableTurbo() {
        turbo.enable();
    }

    public void disableTurbo() {
        turbo.disable();
    }

    public boolean getTurboState() {
        return turbo.getState();
    }

    /**
     * Returns the speed factor of the car.
     *
     * @return the speed factor of the car
     */
    @Override
    public double getAcceleration() {
        return super.getAcceleration() * turbo.getFactor();
    }
}
