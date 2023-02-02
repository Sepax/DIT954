package com.car.models;

import java.awt.Color;

/**
 * Carferry class
 */

/*
 * Separera på Car och Vehicle i olika klasser
 */

public class CarFerry extends Transporter {

  public CarFerry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, false);
    ramp = RampState.RAISED;
  }

  public void unloadCar() {
    if (ramp == RampState.RAISED || cars.isEmpty()) {
      return;
    }
    cars.peek().setX(x + 5);
    cars.peek().setY(y + 5);
    cars.removeLast();
  }

}
