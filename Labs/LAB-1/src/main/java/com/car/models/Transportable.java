package com.car.models;

import java.awt.Color;

public abstract class Transportable extends Vehicle  {
    protected int size;

    protected Transportable(int nrDoors, Color color, double enginePower, String modelName, Dir direction, int size) {
        super(nrDoors, color, enginePower, modelName, direction);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
