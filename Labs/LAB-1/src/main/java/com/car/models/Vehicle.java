package com.car.models;

import java.awt.*;
import com.car.interfaces.*;

/**
 * Vehicle is an abstract class that represents a vehicle. It implements the Moveable interface.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-25
 * 
 * @param nrDoors     the number of doors on the vehicle
 * @param enginePower the engine power of the vehicle
 * @param currentSpeed the current speed of the vehicle
 * @param color       the color of the vehicle
 * @param modelName   the model name of the vehicle
 * @param direction   the direction the vehicle is facing
 * @param x           the x coordinate of the vehicle
 * @param y           the y coordinate of the vehicle
 * @param speedFactor the speed factor of the vehicle
 * @param haulable    if the vehicle is haulable
 */
public abstract class Vehicle implements Moveable {
  protected static int nrDoors; 
  protected double enginePower; 
  protected double currentSpeed; 
  protected static Color color; 
  protected static String modelName; 
  protected Dir direction; 
  protected double x;
  protected double y;
  protected double speedFactor;

  /**
   * Enum representing the direction of the vehicle. Can be NORTH, EAST, SOUTH, or
   * WEST.
   */
  public enum Dir {
    NORTH, EAST, SOUTH, WEST
  }

  /**
   * Constructs a new vehicle object with default values.
   */
  protected Vehicle(int nrDoors, Color color, double enginePower, String modelName, Dir direction) {
    this.nrDoors = nrDoors;
    this.enginePower = enginePower;
    this.color = color;
    this.modelName = modelName;
    this.direction = direction;
    stopEngine();
  }

  /**
   * Returns the number of doors on the vehicle.
   *
   * @return the number of doors on the vehicle
   */
  public int getNrDoors() {
    return nrDoors;
  }

  /**
   * Returns the engine power of the vehicle.
   *
   * @return the engine power of the vehicle
   */
  public double getEnginePower() {
    return enginePower;
  }

  /**
   * Returns the current speed of the vehicle.
   *
   * @return the current speed of the vehicle
   */
  public double getCurrentSpeed() {
    return currentSpeed;
  }

  /**
   * Returns the color of the vehicle.
   *
   * @return the color of the vehicle
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets the color of the vehicle.
   *
   * @param clr the new color of the vehicle
   */

  public void setColor(Color clr) {
    color = clr;
  }

  /**
   * Returns the direction of the vehicle.
   *
   * @return the direction of the vehicle
   */

  public Dir getDirection() {
    return direction;
  }

  /**
   * Returns the X coordinate of the vehicle.
   *
   * @return the X coordinate of the vehicle
   */

  public double getX() {
    return x;
  }

  /**
   * Returns the Y coordinate of the vehicle.
   *
   * @return the Y coordinate of the vehicle
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the direction of the vehicle.
   *
   * @param direction the new direction of the vehicle
   */
  public void setDirection(Dir direction) {
    this.direction = direction;
  }

  /**
   * Sets the X coordinate of the vehicle.
   *
   * @param x the new X coordinate of the vehicle
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Sets the Y coordinate of the vehicle.
   *
   * @param y the new Y coordinate of the vehicle
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Starts the engine of the vehicle, setting the current speed to 0.1.
   */
  public void startEngine() {
    currentSpeed = 0.1;
  }

  /**
   * Stops the engine of the vehicle, setting the current speed to 0.
   */
  public void stopEngine() {
    currentSpeed = 0;
  }

  /**
   * Increases the speed of the vehicle (gas).
   *
   * @param amount the amount to increase the speed of the vehicle
   */
  public void gas(double amount) {
    if (amount > 0 && amount <= 1) {
      incrementSpeed(amount);
    }
  }

  /**
   * Decrements the speed of the vehicle (brakes)
   *
   * @param amount the amoumt of speed to decrement
   */
  public void brake(double amount) {
    if (amount > 0 && amount <= 1) {
      decrementSpeed(amount);
    }
  }

  /**
   * Move the vehicle in the direction it is facing.
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
   * Turns the car to the left, cases signify the direction the vehicle is facing.
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
   * Turns the vehicle to the right, cases signify the direction the vehicle is facing.
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
   * Increments the current speed of the vehicle by the specified amount, up to the maximum engine power.
   *
   * @param amount the amount to increase the speed of the car
   */
  public void incrementSpeed(double amount) {
    this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount, enginePower);
  }

  /**
   * Decrements the current speed of the car by the specified amount, down to a minimum of 0.
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
