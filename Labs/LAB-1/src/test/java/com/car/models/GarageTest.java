package com.car.models;

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
  private Garage<Vehicle> mockAnyGarage;
  private Saab95 mockSaab;
  private Volvo240 mockVolvo;
  private Deque<Vehicle> vehicles;

  @BeforeEach
  void setup() {
    this.vehicles = new ArrayDeque<>();
    mockSaabGarage = new Garage<Saab95>(10);
    mockVolvoGarage = new Garage<Volvo240>(10);
    mockAnyGarage = new Garage<Vehicle>(10);
    mockSaab = new Saab95(new Position(0, 0));
    mockVolvo = new Volvo240(new Position(0, 0));
  }

  @AfterEach
  void tearDown() {
    vehicles.clear();
  }

  @Test
  public void shouldSubmitRightCarType() {
    mockSaabGarage.loadVehicle(mockSaab);
    mockVolvoGarage.loadVehicle(mockVolvo);
    assertEquals(1, mockSaabGarage.getCargo().getContent().size());
    assertEquals(1, mockVolvoGarage.getCargo().getContent().size());
    mockSaabGarage.unloadVehicle();
    mockVolvoGarage.unloadVehicle();
    assertEquals(0, mockSaabGarage.getCargo().getContent().size());
    assertEquals(0, mockVolvoGarage.getCargo().getContent().size());
  }

  @Test
  public void shouldSubmitAnyCarType() {

    mockAnyGarage.loadVehicle(mockSaab);
    mockAnyGarage.loadVehicle(mockVolvo);

    assertEquals(2, mockAnyGarage.getCargo().getContent().size());
  }

  @Test
  public void shouldUnloadCar() {
    mockAnyGarage.loadVehicle(mockSaab);
    mockAnyGarage.loadVehicle(mockVolvo);
    assertEquals(2, mockAnyGarage.getCargo().getContent().size());
    mockAnyGarage.unloadVehicle();
    mockAnyGarage.unloadVehicle();
    assertEquals(0, mockAnyGarage.getCargo().getContent().size());
  }

}
