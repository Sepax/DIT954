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
  public Hauler(Position position) {
    super(2, Color.ORANGE, 200, 5000, "Hauler", Facing.EAST, position, 2, 1);
  }

}
