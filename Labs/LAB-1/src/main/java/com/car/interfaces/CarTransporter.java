package com.car.interfaces;

import java.util.Deque;

import com.car.models.Car;
import com.car.models.Transporter.RampState;

/**
 * The interface CarTransporter defines a set of methods for managing a transporter.
 * 
 * @author Sebastian Pålsson, Gabriele Frattini, Kiril Curlinov
 * @since 2023-01-31
 */
public interface CarTransporter {

  /**
   * Gets the state of the ramp.
   * 
   * @return the current state of the ramp.
   */
  public RampState getRampState();

  /**
   * Loads a car on the transporter.
   * 
   * @param car the car to be loaded.
   */
  public void loadCar(Car car);

  /**
   * Unloads the car from the transporter.
   */
  public void unloadCar();

  /**
   * Gets the cars loaded on the transporter.
   * 
   * @return the cars loaded on the deque of the transporter.
   */
  public Deque<Car> getLoadedCars();

  /**
   * Lowers the ramp.
   */
  public void lowerRamp();

  /**
   * Raises the ramp.
   */
  public void raiseRamp();

}