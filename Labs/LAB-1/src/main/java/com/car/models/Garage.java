package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Garage is a class that represents a garage that can hold cars.
 * 
 * @author Sebastian Pålsson, Kiril Curlinov, Gabriele Frattini
 * @since 2021-01-31
 * @param <TCar> the type of car that the garage can hold
 */

public class Garage<TCar extends Car> {
  private List<TCar> cars;
  private int capacity;

/**
 * Constructs a new Garage object with the specified capacity.
 * 
 * @param capacity the capacity of the garage
 * @cars the cars in the garage
 */
  public Garage(int capacity) {
    this.capacity = capacity;
    this.cars = new ArrayList<>(capacity);
  }

  /**
   * Loads the cars in the garage.
   * 
   * @param cars the cars to load in the garage
   */
  public void loadCars(List<TCar> cars) {

    cars.subList(0, capacity - this.cars.size()).forEach(car -> this.cars.add(car));
  }

  /**
   * Submits a car to the garage.
   * 
   * @param car the car to submit to the garage
   * @throws IllegalArgumentException if the garage is full
   */
  public void submitCar(TCar car) throws IllegalArgumentException {

    if (this.cars.size() == capacity) {
      throw new IllegalArgumentException("Garage is full");
    }
    this.cars.add(car);
  }
  /**
   * Gets the car from the garage.
   *
   * @param car the car to get from the garage
   * @return the car from the garage
   */
  public TCar getBackCar(TCar car) {
    this.removeCar(car);
    return car;
  }

  /**
   * Removes the car from the garage.
   *
   * @param car the car to remove from the garage
   */
  public void removeCar(TCar car) {
    this.cars.remove(car);
  }

  /**
   * Gets the number of cars in the garage.
   *
   * @return the number of cars in the garage
   */
  public int getNumberOfCars() {
    return this.cars.size();
  }
}
