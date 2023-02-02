package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The class `Garage` represents a garage.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param <TCar> The type of car that can be stored in the garage.
 * @param cars The cars stored in the garage.
 * @param capacity The capacity of the garage.
 */
public class Garage<TCar extends Car> {
  private List<TCar> cars;
  private int capacity;

  /**
   * Creates a new `Garage` object with specified capacity.
   */
  public Garage(int capacity) {
    this.capacity = capacity;
    this.cars = new ArrayList<>(capacity);
  }
  /**
   * Loads cars into the garage.
   * 
   * @param cars The cars to load into the garage.
   */
  public void loadCars(List<TCar> cars) {

    cars.subList(0, capacity - this.cars.size()).forEach(car -> this.cars.add(car));
  }

  /**
   * Submits a car to the garage.
   * 
   * @param cars The cars to submit from the garage.
   * @return The cars that were submitted from the garage.
   * @throws IllegalArgumentException If the garage is full.
   */

  public void submitCar(TCar car) throws IllegalArgumentException {

    if (this.cars.size() == capacity) {
      throw new IllegalArgumentException("Garage is full");
    }
    this.cars.add(car);
  }
  /**
   * Gets the cars stored in the garage.
   * 
   * @return The cars stored in the garage.
   */
  public TCar getBackCar(TCar car) {
    this.removeCar(car);
    return car;
  }
  /**
   * Removes a car from the garage.
   * 
   * @param car The car to remove from the garage.
   */
  public void removeCar(TCar car) {
    this.cars.remove(car);
  }
  /**
   * Gets the number cars stored in the garage.
   * 
   * @return The number cars stored in the garage.
   */
  public int getNumberOfCars() {
    return this.cars.size();
  }

}