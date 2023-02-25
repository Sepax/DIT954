package com.car.interfaces;

import java.awt.Color;

import com.car.models.Position;
import com.car.models.Vehicle.Facing;

public interface IVehicle {

    public int getNrDoors();

    /**
     * Returns the engine power of the vehicle.
     *
     * @return the engine power of the vehicle
     */
    public double getEnginePower();

    public double getWeight();

    public Position getPosition();

    /**
     * Returns the current speed of the vehicle.
     *
     * @return the current speed of the vehicle
     */
    public double getCurrentSpeed();

    /**
     * Sets the speed factor of the vehicle.
     *
     * @return the speed factor of the vehicle
     */
    public void setCurrentSpeed(double currentSpeed);

    /**
     * Returns the color of the vehicle.
     *
     * @return the color of the vehicle
     */
    public Color getColor();

    /**
     * Sets the color of the vehicle.
     *
     * @param clr the new color of the vehicle
     */

    public void setColor(Color clr);

    /**
     * Returns the facing of the vehicle.
     *
     * @return the facing of the vehicle
     */

    public Facing getFacing();

    /**
     * Returns the X coordinate of the vehicle.
     *
     * @return the X coordinate of the vehicle
     */

    public double getX();

    /**
     * Returns the Y coordinate of the vehicle.
     *
     * @return the Y coordinate of the vehicle
     */
    public double getY();

    /**
     * Sets the facing of the vehicle.
     *
     * @param facing the new facing of the vehicle
     */
    public void setFacing(Facing facing);

    /**
     * Sets the X coordinate of the vehicle.
     *
     * @param x the new X coordinate of the vehicle
     */
    public void setX(double x);

    /**
     * Sets the Y coordinate of the vehicle.
     *
     * @param y the new Y coordinate of the vehicle
     */
    public void setY(double y);

    /**
     * Starts the engine of the vehicle, setting the current speed to 0.1.
     */
    public void startEngine();

    /**
     * Stops the engine of the vehicle, setting the current speed to 0.
     */
    public void stopEngine();

    /**
     * Increases the speed of the vehicle (gas).
     *
     * @param amount the amount to increase the speed of the vehicle
     */
    public void gas(double amount);

    /**
     * Decrements the speed of the vehicle (brakes)
     *
     * @param amount the amoumt of speed to decrement
     */
    public void brake(double amount);

    /**
     * Move the vehicle in the facing it is facing.
     */
    public void move();

    /**
     * Turns the car to the left, cases signify the facing the vehicle is facing.
     */
    public void turnLeft();

    /**
     * Turns the vehicle to the right, cases signify the facing the vehicle is
     * facing.
     */
    public void turnRight();

    /**
     * Increments the current speed of the vehicle by the specified amount
     *
     * @param amount the amount to increase the speed of the car
     */
    public void incrementSpeed(double amount);

    /**
     * Decrements the current speed of the car by the specified amount
     *
     * @param amount the amount to decrease the speed of the car
     */
    public void decrementSpeed(double amount);

    /**
     * Gets the speed factor of the car.
     * 
     * @return the speed factor of the car
     */

    public double getAcceleration();

    public String getModelName();

    public void setModelName(String modelName);

    public String getImagePath();
}
