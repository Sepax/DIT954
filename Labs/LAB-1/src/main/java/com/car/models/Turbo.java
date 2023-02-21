package com.car.models;

/**
 * Turbo is a class that represents a turbo feature, which can be turned on or off.
 * 
 * @author Kiril Curlinov, Gabriele Frattini, Sebastian Pålsson
 */
public class Turbo {
    private boolean on;

    /**
     * Constructs a new Turbo object with the turbo feature initially off.
     */
    public Turbo() {
        on = false;
    }

    /**
     * Turns the turbo feature on.
     */
    public void setOn() {
        on = true;
    }

    /**
     * Turns the turbo feature off.
     */
    public void setOff() {
        on = false;
    }

    /**
     * Returns whether the turbo feature is on or off.
     *
     * @return true if the turbo feature is on, false otherwise
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Returns the speed factor with the turbo feature applied.
     *
     * @param enginePower the engine power of the vehicle
     * @return the speed factor with the turbo feature applied
     */
    public double speedFactor(double enginePower) {
        double turbo = 1;
        if (on) {
            turbo = 1.3;
        }
        return enginePower * 0.01 * turbo;
    }
}

