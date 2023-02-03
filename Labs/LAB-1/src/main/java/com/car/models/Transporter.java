package com.car.models;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * This is a transporter class that extends the vehicle class.
 * It has a ramp that can be lowered and raised.
 * It can load and unload cars.
 * 
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-02
 * 
 * @param vehicles the vehicles loaded on the ramp.
 * @param sizeCapacity the size capacity of the transporter.
 * @param ramp the state of the ramp.
 * 
/*/ 
public abstract class Transporter extends Vehicle {
	protected Deque<Vehicle> vehicles;
	protected int sizeCapacity;
	protected RampState ramp;

	/**
	 * Enum representing the state of the ramp. Can be RAISED or LOWERED.
	 */
	public enum RampState {
		RAISED, LOWERED
	}

	protected Transporter(int nrDoors, Color color, double enginePower, String modelName, Dir direction,
			int sizeCapacity) {
		super(nrDoors, color, enginePower, modelName, direction);
		this.vehicles = new ArrayDeque<>();
		this.sizeCapacity = sizeCapacity;
		this.ramp = RampState.RAISED;
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
	 * Returns the vehicles loaded on the ramp.
	 *
	 * @return the vehicles loaded on the ramp.
	 */
	public Deque<Vehicle> getLoadedVehicles() {
		return vehicles;
	}

	/**
	 * Lowers the ramp
	 */
	public void lowerRamp() {
		if (currentSpeed == 0) {
			ramp = RampState.LOWERED;
		}
	}

	/**
	 * Raises the ramp
	 */
	public void raiseRamp() {
		if (currentSpeed == 0) {
			ramp = RampState.RAISED;
		}
	}

	/**
	 * Loads a vehicle onto the ramp.
	 * 
	 * @param vehicle the vehicle to be loaded.
	 */
	public void loadCar(Transportable vehicle) {
		if (ramp.toString().equals(RampState.RAISED.toString()) || !insideVicinity(vehicle) || vehicle.getSize() > sizeCapacity) {
			return;
		}
		vehicle.setX(x);
		vehicle.setY(x);
		vehicles.push(vehicle);

	}

	/**
	 * Unloads a vehicle from the ramp.
	 */
	public void unloadCar() {
		if (ramp == RampState.RAISED || vehicles.isEmpty()) {
			return;
		}
		vehicles.peek().setX(x + 5);
		vehicles.peek().setY(y + 5);
		vehicles.pop();
	}

	private boolean insideVicinity(Transportable vehicle) {
		return vehicle.getX() >= x - 5 && vehicle.getX() <= x + 5 && vehicle.getY() >= y - 5 && vehicle.getY() <= y + 5;
	}

	@Override
	public void move() {
		if (ramp.toString().equals(RampState.LOWERED.toString())) {
			stopEngine();
			raiseRamp();
			startEngine();
		}

		super.move();

		for (Vehicle vehicle : vehicles) {
			vehicle.setX(x);
			vehicle.setY(y);
		}
	}
}
