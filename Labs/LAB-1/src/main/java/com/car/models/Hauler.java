package com.car.models;

import java.awt.Color;

/**
 * Hauler is a class that represents a hauler truck and extends the Transporter
 * class.
 * It has a ramp which can transport cars.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-02-02
 */

public class Hauler extends Transporter {

  /**
   * Constructs a new Hauler object with the specified number of doors, color,
   * engine power, model name, direction and if it's haulable.
   */

  private static int capacity = 3;

  public Hauler() {
    super(2, Color.ORANGE, 500, "Hauler", Dir.NORTH, capacity);
  }

}
