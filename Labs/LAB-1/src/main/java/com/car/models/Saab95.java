package com.car.models;

import java.awt.*;

/**
 * Saab95 is a concrete implementation of the abstract Car class, representing the model Saab95.
 * It has a turbo feature that can be turned on or off, which affects the speed factor.
 * It also implements the speedFactor, incrementSpeed and decrementSpeed methods.
 */
public class Saab95 extends Car {

    private boolean turboOn;

/**
 * Constructs a new Saab95 object with 2 doors, red color, engine power of 125, and model name of "Saab95".
 * The turbo feature is initially off.
 */
    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }
/**
 * Turns the turbo feature on.
 */
    public void setTurboOn() {
        turboOn = true;
    }

/**
 * Turns the turbo feature off.
 */
    public void setTurboOff() {
        turboOn = false;
    }
    /**
     * Returns whether the turbo feature is on or off.
     * @return true if the turbo feature is on, false otherwise
     */
    public boolean isTurboOn() {
        return turboOn;
    }


/**
 * Returns the speed factor of the car, which is the engine power multiplied by 0.01 and the turbo factor.
 * @return the speed factor of the car
 */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        return this.enginePower * 0.01 * turbo;
    }
}
