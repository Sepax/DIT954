package com.car.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class Loadable<TT extends Transportable> {

  Deque<TT> vehicles;

  int capacity;

  public Loadable(int capacity) {
    this.capacity = capacity;
    this.vehicles = new ArrayDeque<TT>();
  }

  /**
   * Returns the vehicles loaded on the ramp.
   *
   * @return the vehicles loaded on the ramp.
   */
  public Deque<TT> getLoadedVehicles() {
    return vehicles;
  }

  /**
   * Loads a car onto the ramp.
   * 
   * @param car the car to be loaded.
   */
  public void loadCar(TT vehicle) {
    vehicles.push(vehicle);
  }

  public void loadCars(Deque<TT> vehicles) {
    while (!vehicles.isEmpty() && this.vehicles.size() < capacity) {
      loadCar(vehicles.pop());
    }
  }

  /**
   * Unloads a car.
   */
  public void unloadCar() {
    vehicles.pop();
  }

  /**
   * Gets the number cars stored.
   * 
   * @return The number cars stored in the garage.
   */
  public int getNumberOfCars() {
    return this.vehicles.size();
  }

}
