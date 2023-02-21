package com.car.models;

import java.awt.Color;

/**
 * The class `Ferry` represents a ferry that can transport vehicles.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 */
public class Ferry extends Transporter {

    /**
     * Creates a new `Ferry` object with default values.
     * 
     * @param capacity The capacity of the ferry.
     * 
     */
    public Ferry(Position position) {
        super(2, Color.ORANGE, 1300, 30000, "CarFerry", Facing.EAST, position, 3, 2);
    }

    /**
     * Unloads a car.
     */
    public void unloadCar() {
        getLoadable().getLoadedVehicles().removeLast();
    }
}
