package com.car.models;

import java.awt.Color;

/**
 * The class `Ferry` represents a ferry that can transport vehicles.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 */

public class Ferry extends Transporter {
  /**
   * Creates a new `Ferry` object with default values.
   * 
   * @param ramp The ramp state of the car ferry.
   */
  public Ferry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, 3);
    ramp = RampState.RAISED;
  }

  /**
   * Unloads a car from the car ferry.
   */
  public void unloadCar() {
    if (ramp == RampState.RAISED || vehicles.isEmpty()) {
      return;
    }
    vehicles.peek().setX(x + 5);
    vehicles.peek().setY(y + 5);
    vehicles.removeLast();
  }

}
