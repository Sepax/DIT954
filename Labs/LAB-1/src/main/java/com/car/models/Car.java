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

	// TODO setter getter direction
	// TODO setter getter speed
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

	public void startEngine() {
		currentSpeed = 0.1;
	}

	public void stopEngine() {
		currentSpeed = 0;
	}

	// TODO fix this method according to lab pm
	public void gas(double amount) {
		incrementSpeed(amount);
	}

	// TODO fix this method according to lab pm
	public void brake(double amount) {
		decrementSpeed(amount);
	}

	protected abstract void incrementSpeed(double amount);

	protected abstract void decrementSpeed(double amount);

	public void move() {
		switch (this.direction) {
			case NORTH:
				this.y += currentSpeed;
				break;
			case EAST:
				this.x += currentSpeed;
				break;
			case SOUTH:
				this.y -= currentSpeed;
				break;
			case WEST:
				this.x -= currentSpeed;
				break;
		}
	}

	public void turnLeft() {
		switch (this.direction) {
			case NORTH:
				this.direction = Dir.WEST;
				break;
			case EAST:
				this.direction = Dir.NORTH;
				break;
			case SOUTH:
				this.direction = Dir.EAST;
				break;
			case WEST:
				this.direction = Dir.SOUTH;
				break;
		}
	}

	public void turnRight() {
		switch (this.direction) {
			case NORTH:
				this.direction = Dir.EAST;
				break;
			case EAST:
				this.direction = Dir.SOUTH;
				break;				
			case SOUTH:
				this.direction = Dir.WEST;
				break;
			case WEST:
				this.direction = Dir.NORTH;
				break;
		}
	}
}
