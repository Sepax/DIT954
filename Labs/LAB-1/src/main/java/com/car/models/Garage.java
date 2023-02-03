package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The class `Garage` represents a garage.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param <TVehicle> The type of vehicle that can be stored in the garage.
 * @param cars The cars stored in the garage.
 * @param capacity The capacity of the garage.
 */

public class Garage<TT extends Transportable> {
  private int capacity;
  private Loadable<TT> loadable;

  /**
   * Creates a new `Garage` object with specified capacity.
   */
  public Garage(int capacity) {
    this.capacity = capacity;
    loadable = new Loadable<TT>(capacity);
  }

  public Loadable<TT> getLoadable() {
    return loadable;
  }

  /**
   * Submits a vehicle to the garage.
   * 
   * @param cars The cars to submit from the garage.
   * @return The cars that were submitted from the garage.
   * @throws IllegalArgumentException If the garage is full.
   */

  public void submitCar(TVehicle car) throws IllegalArgumentException {

    if (this.vehicles.size() == capacity) {
      throw new IllegalArgumentException("Garage is full");
    }
    this.vehicles.add(car);
  }
  /**
   * Gets the vehicle stored in the garage.
   * 
   * @return The vehicle stored in the garage.
   */
  public TVehicle getBackCar(TVehicle car) {
    this.removeCar(car);
    return car;
  }
  /**
   * Removes a vehicle from the garage.
   * 
   * @param vehicle The vehicle to remove from the garage.
   */
  public void removeCar(TVehicle car) {
    this.vehicles.remove(car);
  }
  /**
   * Gets the number cars stored in the garage.
   * 
   * @return The number cars stored in the garage.
   */
  public int getNumberOfCars() {
    return this.vehicles.size();
  }

}
