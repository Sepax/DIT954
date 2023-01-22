package com.car.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/**
 * Unit tests for Saab cars.
 *
 */

public class SaabTest {
  private Saab95 mockSaab;

  @BeforeEach
  void setup() {
    mockSaab = new Saab95();
  }

  @Test
  public void shouldIncreaseSpeed() {
    mockSaab.startEngine();
    double speedBefore = mockSaab.getCurrentSpeed();
    mockSaab.gas(1);
    assert (mockSaab.getCurrentSpeed() > speedBefore);
  }

  @Test
  public void shouldDecreaseSpeed() {
    mockSaab.startEngine();
    double speedBefore = mockSaab.getCurrentSpeed();
    mockSaab.brake(1);
    assert (mockSaab.getCurrentSpeed() < speedBefore);
  }

}
