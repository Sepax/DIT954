package com.car.models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.car.interfaces.*;

/**
 * Vehicle is an abstract class that represents a vehicle. It implements the
 * Moveable interface.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-25
 * 
 * @param nrDoors      the number of doors on the vehicle
 * @param size         the size of the vehicle
 * @param enginePower  the engine power of the vehicle
 * @param currentSpeed the current speed of the vehicle
 * @param x            the x coordinate of the vehicle
 * @param y            the y coordinate of the vehicle
 * @param speedFactor  the speed factor of the vehicle
 * @param color        the color of the vehicle
 * @param modelName    the model name of the vehicle
 * @param facing       the facing the vehicle is facing
 */
public abstract class Vehicle implements IVehicle {
    int nrDoors;
    double enginePower;
    double currentSpeed;
    double weight;
    Position position;
    Color color;
    String modelName;
    Facing facing;
    private String imagePath;

    /**
     * Enum representing the facing of the vehicle.
     */
    public enum Facing {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Constructs a new vehicle object with default values.
     */
    protected Vehicle(int nrDoors, Color color, double enginePower, double weight, String modelName, Facing facing,
            Position position, String imagePath) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.weight = weight;
        this.color = color;
        this.modelName = modelName;
        this.facing = facing;
        this.position = position;
        stopEngine();
        this.imagePath = imagePath;
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

    public double getWeight() {
        return weight;
    }

    public Position getPosition() {
        return position;
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
     * Sets the speed factor of the vehicle.
     *
     * @return the speed factor of the vehicle
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
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
     * Returns the facing of the vehicle.
     *
     * @return the facing of the vehicle
     */

    public Facing getFacing() {
        return facing;
    }

    /**
     * Returns the X coordinate of the vehicle.
     *
     * @return the X coordinate of the vehicle
     */

    public double getX() {
        return position.getX();
    }

    /**
     * Returns the Y coordinate of the vehicle.
     *
     * @return the Y coordinate of the vehicle
     */
    public double getY() {
        return position.getY();
    }

    /**
     * Sets the facing of the vehicle.
     *
     * @param facing the new facing of the vehicle
     */
    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    /**
     * Sets the X coordinate of the vehicle.
     *
     * @param x the new X coordinate of the vehicle
     */
    public void setX(double x) {
        position.setX(x);
    }

    /**
     * Sets the Y coordinate of the vehicle.
     *
     * @param y the new Y coordinate of the vehicle
     */
    public void setY(double y) {
        position.setY(y);
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
     * Move the vehicle in the facing it is facing.
     */
    public void move() {
        switch (this.facing) {
            case NORTH:
                setY(getY() - currentSpeed);
                break;
            case EAST:
                setX(getX() + currentSpeed);
                break;
            case SOUTH:
                setY(getY() + currentSpeed);
                break;
            case WEST:
                setX(getX() - currentSpeed);
                break;
        }
    }

    /**
     * Turns the car to the left, cases signify the facing the vehicle is facing.
     */
    public void turnLeft() {
        switch (this.facing) {
            case NORTH:
                setFacing(Facing.WEST);
                break;
            case EAST:
                setFacing(Facing.NORTH);
                break;
            case SOUTH:
                setFacing(Facing.EAST);
                break;
            case WEST:
                setFacing(Facing.SOUTH);
                break;
        }
    }

    /**
     * Turns the vehicle to the right, cases signify the facing the vehicle is
     * facing.
     */
    public void turnRight() {
        switch (getFacing()) {
            case NORTH:
                setFacing(Facing.EAST);
                break;
            case EAST:
                setFacing(Facing.SOUTH);
                break;
            case SOUTH:
                setFacing(Facing.WEST);
                break;
            case WEST:
                setFacing(Facing.NORTH);
                break;
        }
    }

    /**
     * Increments the current speed of the vehicle by the specified amount
     *
     * @param amount the amount to increase the speed of the car
     */
    public void incrementSpeed(double amount) {
        this.currentSpeed = Math.min(getCurrentSpeed() + getAcceleration() * amount, enginePower);
    }

    /**
     * Decrements the current speed of the car by the specified amount
     *
     * @param amount the amount to decrease the speed of the car
     */
    public void decrementSpeed(double amount) {
        this.currentSpeed = Math.max(getCurrentSpeed() - getAcceleration() * amount, 0);
    }

    /**
     * Gets the speed factor of the car.
     * 
     * @return the speed factor of the car
     */
    public double getAcceleration() {
        return enginePower / weight * 50;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getImagePath() {
        return imagePath;
    }
}
