package com.car.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit tests for Volvo cars.
 *
 */

public class CarTest {
  private Volvo240 mockVolvo;

  @BeforeEach
  void setup() {
    mockVolvo = new Volvo240();
  }

  @Test
  public void shouldIncreaseSpeed() {
    double speedBefore = mockVolvo.getCurrentSpeed();
    mockVolvo.gas(1);
    assert (mockVolvo.getCurrentSpeed() > speedBefore);
  }

  @Test
  public void shouldDecreaseSpeed() {
    double speedBefore = mockVolvo.getCurrentSpeed();
    mockVolvo.brake(1);
    assert (mockVolvo.getCurrentSpeed() < speedBefore);
  }

}
