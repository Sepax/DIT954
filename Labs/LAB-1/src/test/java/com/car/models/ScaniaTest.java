package com.car.models;

import com.car.models.Car.Dir;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for Scania cars.
 *
 */

public class ScaniaTest {
    private Scania mockScania;

	@BeforeEach
	void setup() {
		mockScania = new Scania();
	}

    @Test
    public void shouldIncreaseSpeed() {
        mockScania.startEngine();
        double speedBefore = mockScania.getCurrentSpeed();
        mockScania.gas(1);
        assertTrue(speedBefore <= mockScania.getCurrentSpeed());
    }

    @Test
    public void shouldDecreaseSpeed() {
        mockScania.startEngine();
        double speedBefore = mockScania.getCurrentSpeed();
        mockScania.brake(1);
        assertTrue(speedBefore >= mockScania.getCurrentSpeed());
    }

    @Test
    public void shouldTurnLeft() {
        mockScania.turnLeft();
        assertSame(Dir.WEST, mockScania.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        mockScania.turnRight();
        assertSame(Dir.EAST, mockScania.getDirection());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockScania.getX();
        double yBefore = mockScania.getY();
        mockScania.move();
        assertTrue(xBefore != mockScania.getX() || yBefore != mockScania.getY());
    }

    @Test
    public void shouldMove() {
        mockScania.startEngine();
        double xBefore = mockScania.getX();
        double yBefore = mockScania.getY();
        mockScania.move();
        assertTrue(xBefore != mockScania.getX() || yBefore != mockScania.getY());
    }

    @Test
    public void shouldStartEngine() {
        mockScania.startEngine();
        assertTrue(mockScania.getCurrentSpeed() > 0);
    }

    @Test
    public void shouldStopEngine() {
        mockScania.startEngine();
        mockScania.stopEngine();
        assertTrue(mockScania.getCurrentSpeed() == 0);
    }

    @Test
    public void shouldNotHaveSpeedAboveMaxEnginePower() {
        mockScania.startEngine();
        for (int i = 0; i < 100; i++) {
            mockScania.gas(1);
        }
        assertTrue(mockScania.getCurrentSpeed() <= mockScania.getEnginePower());
    }

    @Test
    public void shouldNotHaveSpeedBelowZero() {
        mockScania.startEngine();
        mockScania.brake(1);
        assertTrue(mockScania.getCurrentSpeed() >= 0);
    }

    @Test
    public void shouldNotHaveTiltedFlatbedIfMoving() {
        mockScania.startEngine();
        mockScania.setFlatbedTilt(70);
        mockScania.move();
        assertEquals(0, mockScania.getFlatbedTilt());
    }

    @Test
    public void sholdNotHaveFlatbedBelowZero() {
        mockScania.setFlatbedTilt(-1);
        assertEquals(0, mockScania.getFlatbedTilt());
    }

    @Test
    public void sholdNotHaveFlatbedAboveMax() {
        mockScania.setFlatbedTilt(71);
        assertEquals(0, mockScania.getFlatbedTilt());
    }

    @Test
    public void shouldLowerFlatbed() {
        mockScania.setFlatbedTilt(0);
        mockScania.lowerFlatbed(0);
        assertEquals(0, mockScania.getFlatbedTilt());
        mockScania.setFlatbedTilt(70);
        mockScania.lowerFlatbed(0);
        assertEquals(70, mockScania.getFlatbedTilt());

    }
    @Test
    public void shouldRaiseFlatbed() {
        mockScania.setFlatbedTilt(0);
        mockScania.raiseFlatbed(0);
        assertEquals(0, mockScania.getFlatbedTilt());
        mockScania.setFlatbedTilt(70);
        mockScania.raiseFlatbed(70);
        assertEquals(70, mockScania.getFlatbedTilt());
    }

}


    

