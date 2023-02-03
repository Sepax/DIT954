package com.car.models;

import java.awt.Color;

/**
 * Hauler is a class that represents a hauler truck and extends the Car class.
 * The class has the same properties and methods as the Car class, with the
 * addition of a ramp which can transport vehicles.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-02-02
 */

public class Hauler extends Transporter {

  /**
   * Constructs a new Hauler object with the specified number of doors, color,
   * engine power, model name, direction and if it's haulable.
   */
  public Hauler() {
    super(2, Color.ORANGE, 500, "Hauler", Dir.NORTH, 2);
    this.ramp = RampState.RAISED;
  }

}
