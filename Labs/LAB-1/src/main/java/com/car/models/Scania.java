package com.car.models;

import java.awt.Color;

/**
 * Scania is a class that represents a Scania truck and extends the Car class.
 * The class has the same properties and methods as the Car class, with the addition of a flatbed tilt property.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 */
public class Scania extends Car {
	private double flatbedTilt; // The tilt of the flatbed in degrees
	
	/**
	 * Constructs a new Scania object with the specified number of doors, color, engine power, and model name.
	 */
	public Scania() {
        super(2, Color.ORANGE, 500, "Scania", Dir.NORTH,  false);
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
	 * If the flatbed is raised, stop the engine, lower the flatbed and start the engine again to move the truck.
	 */
	@Override
	public void move() {
		if (flatbedTilt > 0) {
			super.stopEngine();
			lowerFlatbed(flatbedTilt);
		}
		super.startEngine(); 
		super.move();
	}

}


