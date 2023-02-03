package com.car.models.Transporters;

import java.awt.Color;

import com.car.models.Transporter;

/**
 * Carferry class
 */

/*
 * Separera på Car och Vehicle i olika klasser
 */

public class Ferry extends Transporter {

  public Ferry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, 3);
    ramp = RampState.RAISED;
  }

  public void unloadCar() {
    if (ramp == RampState.RAISED || vehicles.isEmpty()) {
      return;
    }
    vehicles.peek().setX(x + 5);
    vehicles.peek().setY(y + 5);
    vehicles.removeLast();
  }

}
