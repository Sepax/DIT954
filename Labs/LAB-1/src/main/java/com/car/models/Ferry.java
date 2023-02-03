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
   */

  private static int capacity = 3;

  public Ferry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, capacity);
  }

  /**
   * Unloads a car.
   */
  public void unloadCar() {
    getLoadable().getLoadedVehicles().removeLast();
  }
}
