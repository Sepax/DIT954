package com.car.models;

import java.awt.*;
import com.car.interfaces.*;

public abstract class Car implements Moveable {
	protected int nrDoors; // Number of doors on the car
	protected double enginePower; // Engine power of the car
	protected double currentSpeed; // The current speed of the car
	protected Color color; // Color of the car
	protected String modelName; // The car model name
	protected Dir direction; // Direction of the car
	protected double x;
	protected double y;

	enum Dir {
		NORTH, EAST, SOUTH, WEST
	}

	protected Car(int nrDoors, Color color, double enginePower, String modelName) {
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;
		this.direction = Dir.NORTH;
		stopEngine();
	}

	public int getNrDoors() {
		return nrDoors;
	}

	public double getEnginePower() {
		return enginePower;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color clr) {
		color = clr;
	}

	public Dir getDirection() {
		return direction;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setDirection(Dir direction) {
		this.direction = direction;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void startEngine() {
		currentSpeed = 0.1;
	}

	public void stopEngine() {
		currentSpeed = 0;
	}

	public void gas(double amount) {
		if (amount > 0 && amount <= 1) {
			incrementSpeed(amount);
		}
	}

	public void brake(double amount) {
		if (amount > 0 && amount <= 1) {
			decrementSpeed(amount);
		}
	}

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
	}

	public void turnLeft() {
		switch (this.direction) {
			case NORTH:
				setDirection(Dir.WEST);
				break;
			case EAST:
				setDirection(Dir.NORTH);
				break;
			case SOUTH:
				setDirection(Dir.EAST);
				break;
			case WEST:
				setDirection(Dir.SOUTH);
				break;
		}
	}

	public void turnRight() {
		switch (getDirection()) {
			case NORTH:
				setDirection(Dir.EAST);
				break;
			case EAST:
				setDirection(Dir.SOUTH);
				break;
			case SOUTH:
				setDirection(Dir.WEST);
				break;
			case WEST:
				setDirection(Dir.NORTH);
				break;
		}
	}

	protected abstract void incrementSpeed(double amount);

	protected abstract void decrementSpeed(double amount);
}
