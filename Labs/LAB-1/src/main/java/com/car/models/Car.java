package com.car.models;

import java.awt.*;
import com.car.interfaces.*;

/**
 * Car is an abstract class that represents a car. It implements the Moveable interface.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @version 1.0
 * @since 2023-01-25
 * 
 * @param nrDoors     the number of doors on the car
 * @param enginePower the engine power of the car
 * @param currentSpeed the current speed of the car
 * @param color       the color of the car
 * @param modelName   the model name of the car
 * @param direction   the direction the car is facing
 * @param x           the x coordinate of the car
 * @param y           the y coordinate of the car
 * @param speedFactor the speed factor of the car
 * @param haulable    if the car is haulable
 */
public abstract class Car implements Moveable {
  protected static int nrDoors; 
  protected static double enginePower; 
  protected double currentSpeed; 
  protected static Color color; 
  protected static String modelName; 
  protected Dir direction; 
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
   * Constructs a new Car object with specified number of doors, color, engine power, model name, direction, and if it's haulable.
   * starts with engine off.
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
   * @param color the new color of the car
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
   * Decreases the speed of the car by the specified amount, down to a minimum of 0.
   *
   * @param amount the amount to decrease the speed of the car
   */
  public void brake(double amount) {
    if (amount > 0 && amount <= 1) {
      decrementSpeed(amount);
    }
  }

  /**
   * Move the car in the direction it is facing.
   */
  public void move() {
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
  }

  /**
   * Turns the car to the left, cases signify the direction the car is facing.
   */
  public void turnLeft() {
    switch (this.direction) {
      case NORTH:
        setDirection(Dir.WEST);
        break;
      case EAST:
        setDirection(Dir.NORTH);
        break;
      case SOUTH:
        setDirection(Dir.EAST);
        break;
      case WEST:
        setDirection(Dir.SOUTH);
        break;
    }
  }

  /**
   * Turns the car to the right, cases signify the direction the car is facing.
   */
  public void turnRight() {
    switch (getDirection()) {
      case NORTH:
        setDirection(Dir.EAST);
        break;
      case EAST:
        setDirection(Dir.SOUTH);
        break;
      case SOUTH:
        setDirection(Dir.WEST);
        break;
      case WEST:
        setDirection(Dir.NORTH);
        break;
    }
  }

  /**
   * Increments the current speed of the car by the specified amount, up to the
   * maximum engine power.
   *
   * @param amount the amount to increase the speed of the car
   */
  public void incrementSpeed(double amount) {
    this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount, enginePower);
  }

  /**
   * Decrements the current speed of the car by the specified amount, down to a
   * minimum of 0.
   *
   * @param amount the amount to decrease the speed of the car
   */
  public void decrementSpeed(double amount) {
    this.currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount, 0);
  }

  /**
   * Sets the speed factor of the car.
   * 
   * @param speedFactor
   */
  public void setSpeedFactor(double speedFactor) {
    this.speedFactor = speedFactor;
  }
  /**
   * Gets the speed factor of the car.
   * 
   * @return the speed factor of the car
   */
  public double getSpeedFactor() {
    return speedFactor;
  }
}