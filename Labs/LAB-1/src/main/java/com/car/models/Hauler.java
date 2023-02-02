package com.car.models;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Hauler is a class that represents a hauler truck and extends the Car class.
 * The class has the same properties and methods as the Car class, with the addition of a ramp which can transport cars.
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
	enum RampState {
		RAISED, LOWERED
	}

	/**
	 * Constructs a new Hauler object with the specified number of doors, color, engine power, model name, direction and if it's haulable.
	 */
	public Hauler() {
        super(2, Color.ORANGE, 500, "Hauler", Dir.NORTH,  false);
        ramp = RampState.RAISED;
	}

	@Override
	public void gas(double amount) {
		if (amount > 0 && amount <= 1 && ramp == RampState.RAISED) {
			incrementSpeed(amount);
		}
  	}

	@Override
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
	 * Toggles the state of the ramp.
	 */
	public void toggleRamp() {
		if (currentSpeed != 0) {
			return;
		}
		if (ramp == RampState.RAISED) {
			ramp = RampState.LOWERED;
		}
		if (ramp == RampState.LOWERED) {
			ramp = RampState.RAISED;
		}
    }


	/**
	 * Loads a car onto the ramp.
	 * 
	 * @param car the car to be loaded.
	 */
	public void loadCar(Car car) {
		if (ramp == RampState.RAISED || !car.haulable || !insideVicinity(car)) {
			return;
		}
		cars.push(car);
	}


	/**
	 * Unloads a car from the ramp.
	 */
	public void unloadCar() {
		if (ramp == RampState.RAISED || cars.isEmpty()) {
			return;
		}
		cars.peek().setX(getX() + 5);
		cars.peek().setY(getY() + 5);
		cars.pop();
	}

	private boolean insideVicinity(Car car) {
		return car.x >= x - 5 && car.x <= x + 5 && car.y >= y - 5 && car.y <= y + 5;
	}


}


