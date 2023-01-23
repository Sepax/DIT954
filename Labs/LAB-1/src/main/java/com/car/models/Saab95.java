package main.java.com.car.models;

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
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO: gas() och break() bara accepterar värden i intervallet [0,1],
    // Anrop till gas() inte kan resultera i att farten sänks och
    // Anrop till break() inte kan resultera i att farten höjs.
	  public void gas(double amount) {
		  incrementSpeed(amount);
	  }
  
	  public void brake(double amount) {
		  decrementSpeed(amount);
	  }
}
