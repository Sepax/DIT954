package com.lab2.models;

import java.awt.Color;

/**
 * Scania is a class that represents a Scania truck and extends the Transportable class.
 * The class has the same properties and methods as the Transporter class, with the addition of a flatbed tilt property.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 * 
 * @param flatbedTilt the tilt of the flatbed in degrees
 * @param capacity the capacity value of the Scania truck
 */
public class Scania extends Transportable {
	private double flatbedTilt; 
	private static int capacity = 3;
	
	/**
	 * Constructs a new Scania object.
	 * Sets the flatbed tilt to 0.
	 */
	public Scania() {
        super(2, Color.ORANGE, 500, "Scania", Dir.NORTH, capacity);
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
	 * Sets the tilt of the flatbed in degrees if the angle is between 0 and 70.
	 *
	 * @param tilt the new tilt of the flatbed in degrees
	 */
	public void setFlatbedTilt(double tilt) {
		if (tilt >= 0 && tilt <= 70) {
			flatbedTilt = tilt;
		}
    }

	/**
	 * Raises the flatbed (degrees) if the truck is not moving.
	 * 
	 * @param degrees the degrees to raise the flatbed
	 */
	public void raiseFlatbed(double degrees) {
		if (getCurrentSpeed() == 0) {
			flatbedTilt = Math.min(flatbedTilt + degrees, 70);
		}
	}

	/**
	 * Lowers the flatbed (degrees) if the truck is not moving.
	 * 
	 * @param degrees the degrees to lower the flatbed
	 */
	public void lowerFlatbed(double degrees) {
		if (getCurrentSpeed() == 0) {
			flatbedTilt = Math.max(flatbedTilt - degrees, 0);
		}
	}

	/**
	 * Overrides the move method to fit the properties for the Scania truck.
	 */
	@Override
	public void move() {
		if (flatbedTilt > 0) {
			stopEngine();
			lowerFlatbed(flatbedTilt);
			startEngine();
		}
		super.move();
	}
}


