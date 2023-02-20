package com.car.models;

/**
 * Flatbed is a class that represents the flatbed of a truck.
 * 
 * @author Kiril Curlinov, Gabriele Frattini, Sebastian Pålsson
 * @param tilt the tilt of the flatbed in degrees
 * 
 */
public class Flatbed {
    private double tilt;

    /**
     * Constructor for the Flatbed class.
     */
    public Flatbed() {
        tilt = 0;
    }
    
    /**
     * Gets the tilt of the flatbed.
     * 
     * @return the tilt of the flatbed
     */
    public double getTilt() {
        return tilt;
    }

    /**
     * Sets the tilt of the flatbed.
     * 
     * @param tilt the tilt of the flatbed
     */
    public void setTilt(double tilt) {
        if (tilt >= 0 && tilt <= 70) {
            this.tilt = tilt;
        }
    }

    /**
     * Raises the flatbed.
     * 
     * @param degrees the degrees to raise the flatbed
     */
    public void raise(double degrees) {
        tilt = Math.min(tilt + degrees, 70);
    }

    /**
     * Lowers the flatbed.
     * 
     * @param degrees the degrees to lower the flatbed
     */
    public void lower(double degrees) {
        tilt = Math.max(tilt - degrees, 0);
    }
}

