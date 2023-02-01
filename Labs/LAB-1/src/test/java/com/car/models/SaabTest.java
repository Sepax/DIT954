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
	public void shouldTurnLeft() {
		mockSaab.turnLeft();
		assertSame(Dir.WEST, mockSaab.getDirection());
	}

	@Test
	public void shouldTurnRight() {
		mockSaab.turnRight();
		assertSame(Dir.EAST, mockSaab.getDirection());
	}

	@Test
	public void shouldTurnOnTurbo() {
		mockSaab.setTurboOn();
		assertTrue(mockSaab.isTurboOn());
	}

	@Test
	public void shouldTurnOffTurbo() {
		mockSaab.setTurboOff();
		assertFalse(mockSaab.isTurboOn());
	}

	@Test
	public void shouldNotTurnOnTurbo() {
		mockSaab.setTurboOff();
		assertFalse(mockSaab.isTurboOn());
	}

	@Test
	public void shouldNotTurnOffTurbo() {
		mockSaab.setTurboOn();
		assertTrue(mockSaab.isTurboOn());
	}

	@Test
	public void shouldNotMove() {
		double xBefore = mockSaab.getX();
		double yBefore = mockSaab.getY();
		mockSaab.move();
		assertTrue(xBefore == mockSaab.getX() && yBefore == mockSaab.getY());
	}

	@Test
	public void shouldMove() {
		mockSaab.startEngine();
		double xBefore = mockSaab.getX();
		double yBefore = mockSaab.getY();
		mockSaab.move();
		assertTrue(xBefore != mockSaab.getX() || yBefore != mockSaab.getY());
	}

	@Test
	public void shouldStartEngine() {
		mockSaab.startEngine();
		assertTrue(mockSaab.getCurrentSpeed() > 0);
	}

	@Test
	public void shouldStopEngine() {
		mockSaab.startEngine();
		mockSaab.stopEngine();
		assertTrue(mockSaab.getCurrentSpeed() == 0);
	}

	@Test
	public void shouldNotHaveSpeedAboveMaxEnginePower() {
		mockSaab.startEngine();
		for(int i = 0; i < 100; i++) 
		{
			mockSaab.gas(1);
		}
		assertTrue(mockSaab.getCurrentSpeed() <= mockSaab.getEnginePower());
	}

	@Test
	public void shouldNotHaveSpeedBelowZero() {
		mockSaab.startEngine();
		mockSaab.brake(1);
		assertTrue(mockSaab.getCurrentSpeed() >= 0);
	}
	


}
