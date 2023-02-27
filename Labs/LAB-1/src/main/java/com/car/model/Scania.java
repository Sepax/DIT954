package com.car.model;

import java.awt.Color;

import com.car.interfaces.IFlatBed;

/**
 * Scania is a class that represents a Scania truck and extends the Vehicle
 * class.
 * It has a flatbed and therefore uses the Flatbed class for the implementation
 * of the flatbed.
 * 
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 */
public class Scania extends Vehicle implements IFlatBed {
    private Flatbed flatbed;

    /*
     * Constructor for the Scania class.
     */
    public Scania(Position position) {
        super(2, Color.ORANGE, 200, 4000, "Scania", Facing.EAST, position, "assets/Scania.jpg");
        flatbed = new Flatbed();
    }

    /*
     * Gets the current tilt of the flatbed.
     */
    public double getFlatbedTilt() {
        return flatbed.getTilt();
    }

    /*
     * Sets the tilt of the flatbed.
     */
    public void setFlatbedTilt(double tilt) {
        flatbed.setTilt(tilt);
    }

    /*
     * Raises the flatbed if the speed of the truck is 0.
     */
    @Override
    public void raiseFlatbed(double degrees) {
        if (getCurrentSpeed() == 0) {
            flatbed.raise(degrees);
        } else {
            stopEngine();
            flatbed.raise(degrees);
        }
    }

    /*
     * Lowers the flatbed if the speed of the truck is 0.
     */
    @Override
    public void lowerFlatbed(double degrees) {
        if (getCurrentSpeed() == 0) {
            flatbed.lower(degrees);
        } else {
            stopEngine();
            flatbed.lower(degrees);
        }
    }
}
