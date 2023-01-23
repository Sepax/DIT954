package com.car.models;

import java.awt.*;

public class Volvo240 extends Car {

    public static final double TRIM_FACTOR = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

    public double speedFactor() {
        return enginePower * 0.01 * TRIM_FACTOR;
    }

    public void incrementSpeed(double amount) {
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

    public void decrementSpeed(double amount) {
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

}
