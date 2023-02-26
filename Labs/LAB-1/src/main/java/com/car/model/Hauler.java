package com.car.model;

import java.awt.Color;

import com.car.interfaces.ICargo;
import com.car.interfaces.IRamp;
import com.car.model.Ramp.RampState;

/**
 * Hauler is a class that represents a hauler truck and extends the Transporter
 * class.
 * It has a ramp which can transport cars.
 *
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-02-02
 */
public class Hauler extends Vehicle implements ICargo, IRamp {
	private Cargo<Vehicle> cargo;
	private Ramp ramp;

	/**
	 * Constructs a new Hauler object with the specified number of doors, color,
	 * engine power, model name, direction and if it's haulable.
	 */
	public Hauler(Position position) {
		super(2, Color.ORANGE, 200, 5000, "Hauler", Facing.EAST, position, "");
		this.cargo = new Cargo<>(2000, 6);
		this.ramp = new Ramp();
	}

	public Cargo<Vehicle> getCargo() {
		return cargo;
	}

	public Ramp getRamp() {
		return ramp;
	}

	public void raiseRamp() {
		if (currentSpeed == 0) {
			ramp.raiseRamp();
		}
	}

	public void lowerRamp() {
		if (currentSpeed == 0) {
			ramp.lowerRamp();
		}
	}

	public void loadVehicle(Vehicle vehicle) {
		if (ramp.toString().equals(RampState.RAISED.toString())) {
			return;
		}
		cargo.push(vehicle);
	}

	public void unloadVehicle() {
		if (ramp.toString().equals(RampState.RAISED.toString())) {
			return;
		}
		cargo.pop();
	}

	@Override
	public void move() {
		if (ramp.toString().equals(RampState.LOWERED.toString())) {
			return;
		}
		super.move();

		for (Vehicle vehicle : cargo.getContent()) {
			vehicle.setX(this.getX());
			vehicle.setY(this.getY());
		}
	}
}
