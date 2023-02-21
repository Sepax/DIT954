package com.car.models;

import java.awt.Color;

/**
 * Saab95 is a class that represents a Saab95 car and extends the Vehicle class.
 * It has a turbo feature that can be turned on or off, which affects the speedfactor.
 * 
 * @author Kiril Curlinov, Gabriele Frattini, Sebastian Pålsson
 * @param turbo the turbo feature of the car
 */
public class Saab95 extends Vehicle {
    private Turbo turbo;

    /**
     * Constructs a new Saab95 object with default values.
     * The turbo feature is initially off.
     */
    public Saab95(Position position) {
        super(2, Color.red, 125, "Saab95", Dir.EAST, position, 1);
        turbo = new Turbo();
        setTurboOff();
    }

    /**
     * Turns the turbo feature on.
     */
    public void setTurboOn() {
        turbo.setOn();
    }

    /**
     * Turns the turbo feature off.
     */
    public void setTurboOff() {
        turbo.setOff();
    }

    /**
     * Returns whether the turbo feature is on or off.
     *
     * @return true if the turbo feature is on, false otherwise
     */
    public boolean isTurboOn() {
        return turbo.isOn();
    }

    /**
     * Returns the speed factor of the car.
     *
     * @return the speed factor of the car
     */
    @Override
    public double speedFactor() {
        return turbo.speedFactor(getEnginePower());
    }
}
