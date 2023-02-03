package com.car.models;

import java.awt.*;

/**
 * Volvo240 is a concrete implementation of the abstract vehicle class, representing
 * the vehicle model Volvo240.
 * It has a trim factor of 1.25 and implements the speedFactor, incrementSpeed
 * and decrementSpeed methods.
 */
public class Volvo240 extends Transportable {

  /**
   * The trim factor of the car(constant), which is used to calculate the speed
   * factor.
   */
  public static final double TRIM_FACTOR = 1.25;

  /**
   * Constructs a new Volvo240 object with 4 doors, black color, engine power of
   * 100, and model name of "Volvo240".
   */
  public Volvo240() {
    super(4, Color.black, 100, "Volvo240", Dir.NORTH, 2);
  }

  /**
   * Returns the speed factor of the car, which is the engine power multiplied by
   * 0.01 and the trim factor.
   *
   * @return the speed factor of the car
   */
  public double speedFactor() {
    setSpeedFactor(enginePower * 0.01 * TRIM_FACTOR);
    return getSpeedFactor();
  }

}
