package com.car.models;

import java.awt.*;

/**
 * Volvo240 represents a Volvo240 car and extends the Vehicle class.
 */
public class Volvo240 extends Vehicle {

  /**
   * Constructs a new Volvo240 object with default values.
   */
  public Volvo240(Position position) {
    super(4, Color.black, 100, "Volvo240", Dir.EAST, position, 1);
  }

  /**
   * Returns the speed factor of the car.
   * Uses the Trim class to get the trim factor of the car wich is 1.25.
   *
   * @return the speed factor of the car
   */
  @Override
  public double speedFactor() {
    return enginePower * 0.01 * Trim.trimFactor;
  }
}
