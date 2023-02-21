package com.car.models;

/**
 * Turbo is a class that represents a turbo feature, which can be turned on or
 * off.
 * 
 * @author Kiril Curlinov, Gabriele Frattini, Sebastian Pålsson
 */
public class Turbo {
    private boolean state;
    private double factor = 1.3;

    /**
     * Constructs a new Turbo object with the turbo feature initially off.
     */
    public Turbo() {
        this.state = false;
    }

    /**
     * Turns the turbo feature on.
     */
    public void enable() {
        state = true;
    }

    /**
     * Turns the turbo feature off.
     */
    public void disable() {
        state = false;
    }

    /**
     * Returns whether the turbo feature is on or off.
     *
     * @return true if the turbo feature is on, false otherwise
     */
    public boolean getState() {
        return state;
    }

    public double getFactor() {
        return state ? factor : 1;
    }
}
