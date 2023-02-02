package com.car.models;

import java.awt.Color;

/**
 * The class `CarFerry` represents a car ferry.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 */
public class CarFerry extends Transporter {
  /**
   * Creates a new `CarFerry` object with default values.
   * 
   * @param ramp The ramp state of the car ferry.
   */
  public CarFerry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, false);
    ramp = RampState.RAISED;
  }
  
  /**
   * Unloads a car from the car ferry.
   */
  public void unloadCar() {
    if (ramp == RampState.RAISED || cars.isEmpty()) {
      return;
    }
    cars.peek().setX(x + 5);
    cars.peek().setY(y + 5);
    cars.removeLast();
  }
}
