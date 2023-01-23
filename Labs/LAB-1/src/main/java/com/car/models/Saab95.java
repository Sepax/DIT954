package com.car.models;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        return this.enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;

        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }

    public void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        
        if (newSpeed >= 0 && newSpeed <= enginePower) {
            currentSpeed = newSpeed;
        }
    }
}
