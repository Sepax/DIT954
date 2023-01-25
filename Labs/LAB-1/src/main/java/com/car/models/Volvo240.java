package com.car.models;

import java.awt.*;

/**
 * Volvo240 is a concrete implementation of the abstract Car class, representing the car model Volvo240.
 * It has a trim factor of 1.25 and implements the speedFactor, incrementSpeed and decrementSpeed methods.
 */
public class Volvo240 extends Car {

/** 
 *  The trim factor of the car(constant), which is used to calculate the speed factor.
*/
    public static final double TRIM_FACTOR = 1.25;

/**
 * Constructs a new Volvo240 object with 4 doors, black color, engine power of 100, and model name of "Volvo240".
 */
    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

/**
 * Returns the speed factor of the car, which is the engine power multiplied by 0.01 and the trim factor.
 *
 * @return the speed factor of the car
 */
    public double speedFactor() {
        return enginePower * 0.01 * TRIM_FACTOR;
    }

/**
 * Increments the current speed of the car by the specified amount, up to the maximum engine power.
 *
 * @param amount the amount to increase the speed of the car
 */
    public void incrementSpeed(double amount) {
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

/**
 * Decrements the current speed of the car by the specified amount, down to a minimum of 0.
 *
 * @param amount the amount to decrease the speed of the car
 */
    public void decrementSpeed(double amount) {
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

}
