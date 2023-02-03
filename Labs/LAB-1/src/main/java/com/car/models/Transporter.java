package com.car.models;

import java.awt.Color;

public abstract class Transporter extends Vehicle {
  protected RampState ramp;

  private Loadable<Transportable> loadable;

  /**
   * Enum representing the state of the ramp. Can be RAISED or LOWERED.
   */
  public enum RampState {
    RAISED, LOWERED
  }

  protected Transporter(int nrDoors, Color color, double enginePower, String modelName, Dir direction,
      int sizeCapacity) {
    super(nrDoors, color, enginePower, modelName, direction);
    this.ramp = RampState.RAISED;
    this.loadable = new Loadable<Transportable>(sizeCapacity);
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
   * Raises the ramp
   */
  public void lowerRamp() {
    if (currentSpeed == 0) {
      ramp = RampState.LOWERED;
    }
  }

  /**
   * Lowers the ramp
   */
  public void raiseRamp() {
    ramp = RampState.RAISED;
  }

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

    for (Vehicle car : loadable.getLoadedVehicles()) {
      car.setX(x);
      car.setY(y);
    }
  }

  public Loadable<Transportable> getLoadable() {
    return loadable;
  }
}
