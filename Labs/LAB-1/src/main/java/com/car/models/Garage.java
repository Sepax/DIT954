package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Garage class
 */

public class Garage<TCar extends Car> {
  private List<TCar> cars;
  private int capacity;

  public Garage(int capacity) {
    this.capacity = capacity;
    this.cars = new ArrayList<>(capacity);
  }

  public void loadCars(List<TCar> cars) {

    cars.subList(0, capacity - this.cars.size()).forEach(car -> this.cars.add(car));
  }

  public void submitCar(TCar car) throws IllegalArgumentException {

    if (this.cars.size() == capacity) {
      throw new IllegalArgumentException("Garage is full");
    }
    this.cars.add(car);
  }

  public TCar getBackCar(TCar car) {
    this.removeCar(car);
    return car;
  }

  public void removeCar(TCar car) {
    this.cars.remove(car);
  }

  public int getNumberOfCars() {
    return this.cars.size();
  }

}
