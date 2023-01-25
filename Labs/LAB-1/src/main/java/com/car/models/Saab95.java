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

/**
 * Increments the current speed of the car by the specified amount, up to the maximum engine power.
 * @param amount the amount to increase the speed of the car
 */
    public void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

/**
 * Decrements the current speed of the car by the specified amount, down to a minimum of 0.
 * @param amount the amount to decrease the speed of the car
 */
    public void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        
        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }
}
