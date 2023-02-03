package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The class `Garage` represents a garage.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param <TVehicle> The type of car that can be stored in the garage.
 * @param cars The cars stored in the garage.
 * @param capacity The capacity of the garage.
 */

public class Garage<TVehicle extends Vehicle> {
  private List<TVehicle> vehicles;
  private int capacity;

  /**
   * Creates a new `Garage` object with specified capacity.
   */
  public Garage(int capacity) {
    this.capacity = capacity;
    this.vehicles = new ArrayList<>(capacity);
  }

  public void loadCars(List<TVehicle> vehicles) {

    vehicles.subList(0, capacity - this.vehicles.size()).forEach(car -> this.vehicles.add(car));
  }

  /**
   * Submits a car to the garage.
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
   * Gets the cars stored in the garage.
   * 
   * @return The cars stored in the garage.
   */
  public TVehicle getBackCar(TVehicle car) {
    this.removeCar(car);
    return car;
  }
  /**
   * Removes a car from the garage.
   * 
   * @param car The car to remove from the garage.
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
