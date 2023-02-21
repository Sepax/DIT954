package com.car.models;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The class `Loadable` represents a ramp.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-04
 * 
 * @param <T>      The type of the transportables stored in the ramp.
 * @param vehicles The vehicles stored in the ramp.
 * @param capacity The capacity of the ramp.
 */
public class Cargo<T extends Vehicle> {
	Deque<T> vehicles;
	double weightCap;
	int slots;

	public Cargo(double weightCap, int slots) {
		this.weightCap = weightCap;
		this.slots = slots;
		this.vehicles = new ArrayDeque<>();
	}

	public T peek() {
		return vehicles.peek();
	}

	public void push(T vehicle) {
		if (vehicle.getWeight() > weightCap || vehicles.size() + 1 > slots) {
			return;
		}
		vehicles.push(vehicle);
	}

	public T pop() {
		return vehicles.pop();
	}

	public T removeLast() {
		return vehicles.removeLast();
	}

	/**
	 * Returns the vehicles loaded on the ramp.
	 *
	 * @return the vehicles loaded on the ramp.
	 */
	public Deque<T> getContent() {
		return vehicles;
	}
}
