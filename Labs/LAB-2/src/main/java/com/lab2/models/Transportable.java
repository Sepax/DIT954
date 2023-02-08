package com.lab2.models;

import java.awt.Color;

/**
 * The abstract class `Transportable` that extends 'Vehicle' wich represents transportable vehicles.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-04
 * 
 * @param size The size of the vehicle.
 * 
 */
public abstract class Transportable extends Vehicle  {
    protected int size;

    protected Transportable(int nrDoors, Color color, double enginePower, String modelName, Dir direction, int size) {
        super(nrDoors, color, enginePower, modelName, direction);
        this.size = size;
    }

    /**
     * Gets he size of the vehicle.
     * 
     * @return the size of the vehicle.
     */
    public int getSize() {
        return size;
    }
}
