package com.car.models;

/**
 * The class `Garage` represents a garage.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param <TT>     The type of the transportables stored in the garage.
 * @param cars     The cars stored in the garage.
 * @param capacity The capacity of the garage.
 */
public class Garage<T extends Vehicle> {
	private Cargo<T> cargo;

	/**
	 * Creates a new `Garage` object with specified capacity.
	 */
	public Garage(int slots) {
		cargo = new Cargo<>(30000, slots);
	}

	public void loadVehicle(T vehicle) {
		cargo.push(vehicle);
	}

	public T unloadVehicle() {
		return cargo.removeLast();
	}

	/**
	 * Gets the list of loadables in the garage.
	 */
	public Cargo<T> getCargo() {
		return cargo;
	}
}
