package com.car.models;

import java.awt.Color;
import java.util.Deque;

import com.car.interfaces.CarTransporter;
import com.car.models.Hauler.RampState;

/**
 * Carferry class
 */

/*
 * Separera på Car och Vehicle i olika klasser
 */

public class CarFerry extends Car implements CarTransporter {

  public CarFerry() {
    super(2, Color.ORANGE, 500, "CarFerry", Dir.NORTH, false);
    ramp = RampState.RAISED;
  }

  private RampState ramp;
  Deque<Car> cars;

  public void loadCar(Car car) {
    cars.addLast(car);
  }

  public void unloadCar() {
    cars.removeFirst();
  }

  public Deque<Car> getLoadedCars() {
    return cars;
  }

  public RampState getRampState() {
    return ramp;
  }

  public void lowerRamp() {
    if (currentSpeed == 0) {
      ramp = RampState.LOWERED;
    }
  }

  public void raiseRamp() {
    if (currentSpeed == 0) {
      ramp = RampState.RAISED;
    }
  }

}
