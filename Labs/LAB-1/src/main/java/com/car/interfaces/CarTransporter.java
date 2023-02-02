package com.car.interfaces;

import java.util.Deque;

import com.car.models.Car;
import com.car.models.Transporter.RampState;

public interface CarTransporter {

  public RampState getRampState();

  public void loadCar(Car car);

  public void unloadCar();

  public Deque<Car> getLoadedCars();

  public void lowerRamp();

  public void raiseRamp();

}
