package com.car.models;

import java.awt.Color;

/**
 * Scania is a class that represents a Scania car and extends the Car class.
 * The class has the same properties and methods as the Car class, with the addition of a flatbed tilt property.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 */
public class Scania extends Car {
	private double flatbedTilt; // The tilt of the flatbed in degrees

	/**
	 * Constructs a new Scania object with the specified number of doors, color, engine power, and model name.
	 * The car is initially facing north and has its engine stopped.
	 *
	 * @param nrDoors the number of doors on the car
	 * @param color the color of the car
	 * @param enginePower the engine power of the car
	 * @param modelName the car model name
	 */

    
	public Scania() {
		super(nrDoors = 2, Color.cyan, enginePower = 200, modelName = "Scania");
		flatbedTilt = 0;
	}
	/**
	 * Returns the tilt of the flatbed in degrees.
	 *
	 * @return the tilt of the flatbed in degrees
	 */
	public double getFlatbedTilt() {
		return flatbedTilt;
	}

	/**
	 * Sets the tilt of the flatbed in degrees.
	 *
	 * @param tilt the new tilt of the flatbed in degrees
	 */
	public void setFlatbedTilt(double tilt) {
		flatbedTilt = tilt;
	}

}
