package com.lab2.models;

import com.lab2.models.Vehicle.Dir;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Volvo vehicles.
 *
 */

public class VolvoTest {
  private Volvo240 mockVolvo;

  @BeforeEach
  void setup() {
    mockVolvo = new Volvo240();
  }

  @Test
  public void shouldIncreaseSpeed() {
    mockVolvo.startEngine();
    double speedBefore = mockVolvo.getCurrentSpeed();
    mockVolvo.gas(1);
    assertTrue(speedBefore <= mockVolvo.getCurrentSpeed());
  }

  @Test
  public void shouldDecreaseSpeed() {
    mockVolvo.startEngine();
    double speedBefore = mockVolvo.getCurrentSpeed();
    mockVolvo.brake(1);
    assertTrue(speedBefore >= mockVolvo.getCurrentSpeed());
  }

  @Test
  public void shouldTurnLeft() {
    mockVolvo.turnLeft();
    assertSame(Dir.WEST, mockVolvo.getDirection());
  }

  @Test
  public void shouldTurnRight() {
    mockVolvo.turnRight();
    assertSame(Dir.EAST, mockVolvo.getDirection());
  }

  @Test
  public void shouldNotMove() {
    double xBefore = mockVolvo.getX();
    double yBefore = mockVolvo.getY();
    mockVolvo.move();
    assertTrue(xBefore == mockVolvo.getX() && yBefore == mockVolvo.getY());
  }

  @Test
  public void shouldMove() {
    mockVolvo.startEngine();
    double xBefore = mockVolvo.getX();
    double yBefore = mockVolvo.getY();
    mockVolvo.gas(1);
    mockVolvo.move();
    assertTrue(xBefore != mockVolvo.getX() || yBefore != mockVolvo.getY());

  }

  @Test
  public void shouldStartEngine() {
    mockVolvo.startEngine();
    assertTrue(mockVolvo.getCurrentSpeed() > 0);
  }

  @Test
  public void shouldStopEngine() {
    mockVolvo.startEngine();
    mockVolvo.stopEngine();
    assertTrue(mockVolvo.getCurrentSpeed() == 0);
  }

  @Test
  public void shouldNotHaveSpeedAboveMaxEnginePower() {
    mockVolvo.startEngine();

    for (int i = 0; i < 100; i++) {
      mockVolvo.gas(1);
    }
    assertTrue(mockVolvo.getCurrentSpeed() <= mockVolvo.getEnginePower());
  }

  @Test
  public void shouldNotHaveSpeedBelowZero() {
    mockVolvo.startEngine();
    mockVolvo.brake(1);
    assertTrue(mockVolvo.getCurrentSpeed() >= 0);
  }

}
