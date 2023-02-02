package com.car.models;

import java.awt.Color;

/**
 * Hauler is a class that represents a hauler truck and extends the Transporter class.
 * It has a ramp which can transport cars.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-02-02
 */
public class Hauler extends Transporter {

  /**
   * Constructs a new Hauler object.
   * 
   * @param ramp the state of the ramp   
   */
  public Hauler() {
    super(2, Color.ORANGE, 500, "Hauler", Dir.NORTH, false);
    this.ramp = RampState.RAISED;
  }

  /**
   * Unloads a car from the ramp.
   */
  public void unloadCar() {
    if (ramp == RampState.RAISED || cars.isEmpty()) {
      return;
    }
    cars.peek().setX(x + 5);
    cars.peek().setY(y + 5);
    cars.pop();
  }
}

