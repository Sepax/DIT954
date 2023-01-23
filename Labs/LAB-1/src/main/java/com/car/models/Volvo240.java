package main.java.com.car.models;

import java.awt.*;

public class Volvo240 extends Car {

    public static final double TRIM_FACTOR = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }

    public double speedFactor() {
        return enginePower * 0.01 * TRIM_FACTOR;
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

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
