package com.lab2.models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Unit tests for the Garage class.
 *
 */

public class GarageTest {
  private Garage<Saab95> mockSaabGarage;
  private Garage<Volvo240> mockVolvoGarage;
  private Garage<Transportable> mockAnyGarage;
  private Saab95 mockSaab;
  private Volvo240 mockVolvo;
  private Deque<Transportable> vehicles;

  @BeforeEach
  void setup() {
    this.vehicles = new ArrayDeque<>();
    mockSaabGarage = new Garage<Saab95>(10);
    mockVolvoGarage = new Garage<Volvo240>(10);
    mockAnyGarage = new Garage<Transportable>(10);
    mockSaab = new Saab95();
    mockVolvo = new Volvo240();
  }

  @AfterEach
  void tearDown() {
    vehicles.clear();
  }

  @Test
  public void shouldSubmitRightCarType() {
    mockSaabGarage.getLoadable().loadCar(mockSaab);
    mockVolvoGarage.getLoadable().loadCar(mockVolvo);
    assertEquals(1, mockSaabGarage.getLoadable().getNumberOfCars());
    assertEquals(1, mockVolvoGarage.getLoadable().getNumberOfCars());
    mockSaabGarage.getLoadable().unloadCar();
    mockVolvoGarage.getLoadable().unloadCar();
    assertEquals(0, mockSaabGarage.getLoadable().getNumberOfCars());
    assertEquals(0, mockVolvoGarage.getLoadable().getNumberOfCars());
  }

  @Test
  public void shouldSubmitAnyCarType() {

    mockAnyGarage.getLoadable().loadCar(mockSaab);
    mockAnyGarage.getLoadable().loadCar(mockVolvo);

    assertEquals(2, mockAnyGarage.getLoadable().getNumberOfCars());
  }

  @Test
  public void shouldNotAddCarsWhenGarageIsFull() {

    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        vehicles.push(mockSaab);
      } else {
        vehicles.push(mockVolvo);
      }
    }
    mockAnyGarage.getLoadable().loadCars(vehicles);
    assertEquals(10, mockAnyGarage.getLoadable().getNumberOfCars());
    mockAnyGarage.getLoadable().loadCars(vehicles);
    assertEquals(10, mockAnyGarage.getLoadable().getNumberOfCars());
  }

  @Test
  public void shouldUnloadCar() {
    mockAnyGarage.getLoadable().loadCar(mockSaab);
    mockAnyGarage.getLoadable().loadCar(mockVolvo);
    assertEquals(2, mockAnyGarage.getLoadable().getNumberOfCars());
    mockAnyGarage.getLoadable().unloadCar();
    mockAnyGarage.getLoadable().unloadCar();
    assertEquals(0, mockAnyGarage.getLoadable().getNumberOfCars());
  }

}
