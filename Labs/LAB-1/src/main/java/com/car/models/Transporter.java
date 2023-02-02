package com.car.models;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import com.car.interfaces.CarTransporter;

/**
 * The class `Transporter` represents a transporter.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param ramp The ramp state of the transporter.
 * @param cars The cars loaded on the transporter.
 */
abstract public class Transporter extends Car implements CarTransporter {

  protected RampState ramp;
  protected Deque<Car> cars = new ArrayDeque<>();

  /**
   * Constructs a new `Transporter` object.
   * 
   * @param nrDoors The number of doors of the transporter.
   * @param color The color of the transporter.
   * @param enginePower The engine power of the transporter.
   * @param modelName The model name of the transporter.
   * @param direction The direction of the transporter.
   * @param haulable The haulable state of the transporter.
   */
  protected Transporter(int nrDoors, Color color, double enginePower, String modelName, Dir direction,
      boolean haulable) {
    super(
        nrDoors, color, enginePower, modelName, direction, haulable);
  }

  /**
   * Enum representing the state of the ramp. Can be RAISED or LOWERED.
   */
  public enum RampState {
    RAISED, LOWERED
  }

  /**
   * Returns the state of the ramp.
   *
   * @return the state of the ramp.
   */

  public RampState getRampState() {
    return ramp;
  }

  /**
   * Returns the cars loaded on the ramp.
   *
   * @return the cars loaded on the ramp.
   */
  public Deque<Car> getLoadedCars() {
    return cars;
  }

  /**
   * Lowers the ramp
   */
  public void lowerRamp() {
    if (currentSpeed == 0) {
      ramp = RampState.LOWERED;
    }
  }

  /**
   * Raises the ramp
   */
  public void raiseRamp() {
    ramp = RampState.RAISED;
  }

  /**
   * Loads a car onto the ramp.
   * 
   * @param car the car to be loaded.
   */
  public void loadCar(Car car) {
    if (ramp.toString().equals(RampState.RAISED.toString()) || !car.haulable || !insideVicinity(car)) {
      return;
    }
    car.setX(x);
    car.setY(x);
    cars.push(car);
  }

  /**
   * Boolean method to check if the car is inside the vicinity of the transporter.
   */
  private boolean insideVicinity(Car car) {
    return car.x >= x - 5 && car.x <= x + 5 && car.y >= y - 5 && car.y <= y + 5;
  }

  /**
   * Overides move to check if the ramp is lowered and if so, raise it before moving.
   */
  @Override
  public void move() {
    if (ramp.toString().equals(RampState.LOWERED.toString())) {
      raiseRamp();
    }

    switch (this.direction) {
      case NORTH:
        setY(getY() + currentSpeed);
        break;
      case EAST:
        setX(getX() + currentSpeed);
        break;
      case SOUTH:
        setY(getY() - currentSpeed);
        break;
      case WEST:
        setX(getX() - currentSpeed);
        break;
    }

    for (Car car : cars) {
      car.setX(x);
      car.setY(y);
    }
  }
}


