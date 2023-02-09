package com.car.models;

import java.awt.*;

/**
 * Volvo240 is a concrete implementation of the abstract vehicle class, representing the vehicle model Volvo240.
 * It has a trim factor of 1.25 and implements the speedFactor, incrementSpeed and decrementSpeed methods.
 */
public class Volvo240 extends Vehicle {

  /**
   * The trim factor of the car(constant), which is used to calculate the speed factor.
   */
  public static final double TRIM_FACTOR = 1.25;

  /**
   * Constructs a new Volvo240 object with default values.
   */
  public Volvo240(double x, double y) {
    super(4, Color.black, 100, "Volvo240", Dir.EAST, x, y, 1);
  }

  /**
   * Returns the speed factor of the car.
   *
   * @return the speed factor of the car
   */
  @Override
  public double speedFactor() {
    return enginePower * 0.01 * TRIM_FACTOR;
  }
}
