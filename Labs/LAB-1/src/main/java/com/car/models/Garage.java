package com.car.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Garage class
 */

public class Garage<TCar extends Vehicle> {
  private List<TCar> vehicles;
  private int capacity;

  public Garage(int capacity) {
    this.capacity = capacity;
    this.vehicles = new ArrayList<>(capacity);
  }

  public void loadCars(List<TCar> vehicles) {

    vehicles.subList(0, capacity - this.vehicles.size()).forEach(car -> this.vehicles.add(car));
  }

  public void submitCar(TCar car) throws IllegalArgumentException {

    if (this.vehicles.size() == capacity) {
      throw new IllegalArgumentException("Garage is full");
    }
    this.vehicles.add(car);
  }

  public TCar getBackCar(TCar car) {
    this.removeCar(car);
    return car;
  }

  public void removeCar(TCar car) {
    this.vehicles.remove(car);
  }

  public int getNumberOfCars() {
    return this.vehicles.size();
  }

}
