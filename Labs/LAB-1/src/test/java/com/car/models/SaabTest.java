package com.car.models;

import com.car.models.Car.Dir;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
		assertTrue(speedBefore < mockSaab.getCurrentSpeed());
	}

	@Test
	public void shouldDecreaseSpeed() {
		mockSaab.startEngine();
		double speedBefore = mockSaab.getCurrentSpeed();
		mockSaab.brake(1);
		assertTrue(speedBefore >= mockSaab.getCurrentSpeed());
	}

	@Test
	public void shouldTurnLeft() {
		mockSaab.turnLeft();
		assertSame(Dir.WEST, mockSaab.getDirection());
	}

	@Test
	public void shouldTurnRight() {
		mockSaab.turnRight();
		assertSame(Dir.EAST, mockSaab.getDirection());
	}

}
