package com.car.models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the Garage class.
 *
 */

public class GarageTest {
  private Garage<Saab95> mockSaabGarage;
  private Garage<Volvo240> mockVolvoGarage;
  private Garage<Vehicle> mockAnyGarage;
  private Saab95 mockSaab;
  private Volvo240 mockVolvo;

  @BeforeEach
  void setup() {
    mockSaabGarage = new Garage<Saab95>(10);
    mockVolvoGarage = new Garage<Volvo240>(10);
    mockAnyGarage = new Garage<Vehicle>(10);
    mockSaab = new Saab95();
    mockVolvo = new Volvo240();
  }

  @Test
  public void shouldSubmitRightCarType() {
    mockSaabGarage.submitCar(mockSaab);
    mockVolvoGarage.submitCar(mockVolvo);

    assertEquals(1, mockSaabGarage.getNumberOfCars());
    assertEquals(1, mockVolvoGarage.getNumberOfCars());
    assertEquals(mockSaab, mockSaabGarage.getBackCar(mockSaab));
    assertEquals(mockVolvo, mockVolvoGarage.getBackCar(mockVolvo));
  }

  @Test
  public void shouldSubmitAnyCarType() {

    mockAnyGarage.submitCar(mockSaab);
    mockAnyGarage.submitCar(mockVolvo);

    assertEquals(2, mockAnyGarage.getNumberOfCars());
    assertEquals(mockSaab, mockAnyGarage.getBackCar(mockSaab));
    assertEquals(mockVolvo, mockAnyGarage.getBackCar(mockVolvo));
  }

  @Test
  public void shouldNotAddCarsWhenGarageIsFull() {

    List<Vehicle> vehicles = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        vehicles.add(mockSaab);
      } else {
        vehicles.add(mockVolvo);
      }
    }
    mockAnyGarage.loadCars(vehicles);
    assertEquals(10, mockAnyGarage.getNumberOfCars());
    mockAnyGarage.loadCars(vehicles);
    assertEquals(10, mockAnyGarage.getNumberOfCars());
  }

  @Test
  public void shouldRemoveCar() {
    mockAnyGarage.submitCar(mockSaab);
    mockAnyGarage.submitCar(mockVolvo);
    assertEquals(2, mockAnyGarage.getNumberOfCars());
    mockAnyGarage.removeCar(mockSaab);
    mockAnyGarage.removeCar(mockVolvo);
    assertEquals(0, mockAnyGarage.getNumberOfCars());
  }

  @Test
  public void shouldGetBackCar() {
    mockAnyGarage.submitCar(mockSaab);
    mockAnyGarage.submitCar(mockVolvo);
    assertEquals(2, mockAnyGarage.getNumberOfCars());
    assertEquals(mockVolvo, mockAnyGarage.getBackCar(mockVolvo));
    assertEquals(mockSaab, mockAnyGarage.getBackCar(mockSaab));
    assertEquals(0, mockAnyGarage.getNumberOfCars());
  }

}
