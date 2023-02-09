package com.car.models;

import java.awt.Color;

/**
 * The abstract class `Transporter` that extends 'Vehicle' wich represents
 * transporters.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-04
 * 
 * @param size     The size of the vehicle.
 * @param ramp     The state of the ramp.
 * @param loadable If the vehicle is loadable
 * 
 */
public abstract class Transporter extends Vehicle {
    protected RampState ramp;

    private Loadable<Vehicle> loadable;

    /**
     * Enum representing the state of the ramp. Can be RAISED or LOWERED.
     */
    public enum RampState {
        RAISED, LOWERED
    }

    /**
     * Creates a new `Transporter` object with default values.
     */
    protected Transporter(int nrDoors, Color color, double enginePower, String modelName, Dir direction, double x,
            double y, int size, int sizeCapacity) {
        super(nrDoors, color, enginePower, modelName, direction, x, y, size);
        this.ramp = RampState.RAISED;
        this.loadable = new Loadable<>(sizeCapacity);
    }

    /**
     * Returns the state of the ramp.
     *
     * @return the state of the ramp.
     */

    public RampState getRampState() {
        return ramp;
    }

    /**
     * Lowers the ramp
     */
    public void lowerRamp() {
        if (currentSpeed == 0) {
            ramp = RampState.LOWERED;
        }
    }

    /**
     * Raises the ramp
     */
    public void raiseRamp() {
        if (currentSpeed == 0) {
            ramp = RampState.RAISED;
        }
    }

    /**
     * Overrides the move method in Vehicle. To fit the properties of a transporter.
     */
    @Override
    public void move() {
        if (ramp.toString().equals(RampState.LOWERED.toString())) {
            raiseRamp();
        }
        super.move();

        for (Vehicle car : loadable.getLoadedVehicles()) {
            car.setX(x);
            car.setY(y);
        }
    }

    /**
     * Gets the loadable object of the traporter.
     * 
     * @param vehicle  The vehicle to be loaded.
     * @param loadable The loadable object.
     */
    public Loadable<Vehicle> getLoadable() {
        return loadable;
    }
}
