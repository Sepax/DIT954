package com.car.models;

import java.awt.Color;

/**
 * Scania is a class that represents a Scania truck and extends the Vehicle class.
 * The class has the same properties and methods as the Transporter class, with the addition of a flatbed tilt property.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 * 
 * @param flatbedTilt the tilt of the flatbed in degrees
 */
public class Scania extends Vehicle {
	private double flatbedTilt; 
	
	/**
	 * Constructs a new Scania object.
	 * Sets the flatbed tilt to 0.
	 */
	public Scania(double x, double y) {
        super(2, Color.ORANGE, 100, "Scania", Dir.EAST, x, y, 2);
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
		if (tilt >= 0 && tilt <= 70 && getCurrentSpeed() == 0) {
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
		else {
			stopEngine();
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
		else {
			stopEngine();
			flatbedTilt = Math.max(flatbedTilt - degrees, 0);			
			}
		}
	}




