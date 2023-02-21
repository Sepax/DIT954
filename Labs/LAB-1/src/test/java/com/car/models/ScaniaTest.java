package com.car.models;


import org.junit.jupiter.api.*;

import com.car.models.Vehicle.Dir;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for Scania vehicles.
 *
 */

public class ScaniaTest {
    private Scania mockScania;

	@BeforeEach
	void setup() {
		mockScania = new Scania(0,0);
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
        Dir expectedDirection = null;
        switch (mockScania.direction) {
            case NORTH:
                expectedDirection = Dir.WEST;
                break;
            case EAST:
                expectedDirection = Dir.NORTH;
                break;
            case SOUTH:
                expectedDirection = Dir.EAST;
                break;
            case WEST:
                expectedDirection = Dir.SOUTH;
                break;
        }

        mockScania.turnLeft();
        assertSame(expectedDirection, mockScania.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        Dir expectedDirection = null;
        switch (mockScania.direction) {
            case NORTH:
                expectedDirection = Dir.EAST;
                break;
            case EAST:
                expectedDirection = Dir.SOUTH;
                break;
            case SOUTH:
                expectedDirection = Dir.WEST;
                break;
            case WEST:
                expectedDirection = Dir.NORTH;
                break;
        }

        mockScania.turnRight();
        assertSame(expectedDirection, mockScania.getDirection());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockScania.getX();
        double yBefore = mockScania.getY();
        mockScania.stopEngine();
        mockScania.move();
        assertTrue(xBefore == mockScania.getX() && yBefore == mockScania.getY());
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


    

