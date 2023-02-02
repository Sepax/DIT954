package com.car.models;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Hauler is a class that represents a haulertruck and extends the Car class.
 * The class has the same properties and methods as the Car class, with the
 * addition of a ramp which can transport cars.
 *
 * @authors Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-02-02
 */
public class Hauler extends Car {
	private RampState ramp;
	private Deque<Car> cars = new ArrayDeque<>();

	/**
	 * Enum representing the state of the ramp. Can be RAISED or LOWERED.
	 */
	public enum RampState {
		RAISED, LOWERED
	}

	/**
	 * Constructs a new Hauler object with the specified number of doors, color,
	 * engine power, model name, direction and if it's haulable.
	 * 
	 * @param dir    the direction
	 * @param haul   if it's haulable
	 * @param ramp   the state of the ramp
	 * 
	 */
	public Hauler() {
		super(2, Color.ORANGE, 500, "Hauler", Dir.NORTH, false);
		ramp = RampState.RAISED;
	}
	/**
	 * Moves the hauler in the current direction.
	 * 
	 * If the ramp is lowered, it will be raised before moving.
	 */
	@Override
	public void move() {
		if (ramp.toString().equals(RampState.LOWERED.toString())) {
			raiseRamp();
		}
		// switch for different directions
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
		// Updates the position of the cars on the ramp.
		for (Car car : cars) {
			car.setX(x);
			car.setY(y);
		}
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
	 * Returns the cars loaded on the ramp.
	 *
	 * @return the cars loaded on the ramp.
	 */
	public Deque<Car> getLoadedCars() {
		return cars;
	}

	/**
	 * Raises the ramp
	 * 
	 * @param ramp the state of the ramp
	 */
	public void lowerRamp() {
		if (currentSpeed == 0) {
			ramp = RampState.LOWERED;
		}
	}

	/**
	 * Lowers the ramp
	 * 
	 * @param ramp the state of the ramp
	 */
	public void raiseRamp() {
		ramp = RampState.RAISED;
	}

	/**
	 * Loads a car onto the ramp.
	 * 
	 * @param car the car to be loaded.
	 */
	public void loadCar(Car car) {
		if (ramp.toString().equals(RampState.RAISED.toString()) || !car.haulable || !insideVicinity(car)) {
			return;
		}
		car.setX(x);
		car.setY(x);
		cars.push(car);
	}

	/**
	 * Unloads a car from the ramp.
	 * 
	 * @param car the car to be unloaded.
	 */
	public void unloadCar() {
		if (ramp == RampState.RAISED || cars.isEmpty()) {
			return;
		}
		cars.peek().setX(x + 5);
		cars.peek().setY(y + 5);
		cars.pop();
	}
	
	/**
	 * Checks if the car is inside the vicinity of the hauler.
	 * 
	 * @param car the car to be checked.
	 * @return true if the car is inside the vicinity, false otherwise.
	 */
	private boolean insideVicinity(Car car) {
		return car.x >= x - 5 && car.x <= x + 5 && car.y >= y - 5 && car.y <= y + 5;
	}
}
