package com.car.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/**
 * Unit tests for Volvo cars.
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
    assert (mockVolvo.getCurrentSpeed() > speedBefore);
  }

  @Test
  public void shouldDecreaseSpeed() {
    mockVolvo.startEngine();
    double speedBefore = mockVolvo.getCurrentSpeed();
    mockVolvo.brake(1);
    assert (mockVolvo.getCurrentSpeed() < speedBefore);
  }

}
