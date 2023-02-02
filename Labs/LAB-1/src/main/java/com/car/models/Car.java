package com.car.models;

import java.awt.*;
import com.car.interfaces.*;

/**
 * Car is an abstract class that represents a car object with properties such as
 * number of doors,
 * engine power, current speed, color, model name, direction with X and Y
 * coordinates.
 * The class implements the Moveable interface, which requires the move() method
 * to be implemented.
 * The class also has methods to start and stop the engine, set and get various
 * properties and drive the car forward or backward.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @version 1.0
 * @since 2023-01-25
 */
public abstract class Car implements Moveable {
  protected static int nrDoors; // Number of doors on the car
  protected static double enginePower; // Engine power of the car
  protected double currentSpeed; // The current speed of the car
  protected static Color color; // Color of the car
  protected static String modelName; // The car model name
  protected Dir direction; // Direction of the car
  protected double x;
  protected double y;
  protected double speedFactor;
  protected boolean haulable;

  /**
   * Enum representing the direction of the car. Can be NORTH, EAST, SOUTH, or
   * WEST.
   */
  enum Dir {
    NORTH, EAST, SOUTH, WEST
  }

  /**
   * Constructs a new Car object with the specified number of doors, color, engine
   * power, and model name.
   * The car is initially facing north and has its engine stopped.
   *
   * @param nrDoors     the number of doors on the car
   * @param color       the color of the car
   * @param enginePower the engine power of the car
   * @param modelName   the car model name
   */
  protected Car(int nrDoors, Color color, double enginePower, String modelName, Dir direction, boolean haulable) {
    this.nrDoors = nrDoors;
    this.enginePower = enginePower;
    this.color = color;
    this.modelName = modelName;
    this.direction = direction;
    this.haulable = haulable; 
    stopEngine();
  }

  /**
   * Returns the number of doors on the car.
   *
   * @return the number of doors on the car
   */
  public int getNrDoors() {
    return nrDoors;
  }

  /**
   * Returns the engine power of the car.
   *
   * @return the engine power of the car
   */
  public double getEnginePower() {
    return enginePower;
  }

  /**
   * Returns the current speed of the car.
   *
   * @return the current speed of the car
   */
  public double getCurrentSpeed() {
    return currentSpeed;
  }

  /**
   * Returns the color of the car.
   *
   * @return the color of the car
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets the color of the car.
   *
   * @param clr the new color of the car
   */

  public void setColor(Color clr) {
    color = clr;
  }

  /**
   * Returns the direction of the car.
   *
   * @return the direction of the car
   */

  public Dir getDirection() {
    return direction;
  }

  /**
   * Returns the X coordinate of the car.
   *
   * @return the X coordinate of the car
   */

  public double getX() {
    return x;
  }

  /**
   * Returns the Y coordinate of the car.
   *
   * @return the Y coordinate of the car
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the direction of the car.
   *
   * @param direction the new direction of the car
   */
  public void setDirection(Dir direction) {
    this.direction = direction;
  }

  /**
   * Sets the X coordinate of the car.
   *
   * @param x the new X coordinate of the car
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets the Y coordinate of the car.
   *
   * @param y the new Y coordinate of the car
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Starts the engine of the car, setting the current speed to 0.1.
   */
  public void startEngine() {
    currentSpeed = 0.1;
  }

  /**
   * Stops the engine of the car, setting the current speed to 0.
   */
  public void stopEngine() {
    currentSpeed = 0;
  }

  /**
   * Increases the speed of the car by the specified amount, up to a maximum of 1.
   *
   * @param amount the amount to increase the speed of the car
   */
  public void gas(double amount) {
    if (amount > 0 && amount <= 1) {
      incrementSpeed(amount);
    }
  }


  /**
   * Decreases the speed of the car by the specified amount, down to a minimum of
   * 0.
   *
   * @param amount the amount to decrease the speed of the car
   */
  public void brake(double amount) {
    if (amount > 0 && amount <= 1) {
      decrementSpeed(amount);
    }
  }


public double speedFactor() {
	return 0;
}

/**
 * Increments the current speed of the car by the specified amount, up to the maximum engine power.
 *
 * @param amount the amount to increase the speed of the car
 */
public void incrementSpeed(double amount) {
	double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
}

/**
* Decrements the current speed of the car by the specified amount, down to a minimum of 0.
*
* @param amount the amount to decrease the speed of the car
*/
public void decrementSpeed(double amount) {
	double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
}

  public void setSpeedFactor(double speedFactor) {
    this.speedFactor = speedFactor;
  }

  public double getSpeedFactor() {
    return speedFactor;
  }

}
