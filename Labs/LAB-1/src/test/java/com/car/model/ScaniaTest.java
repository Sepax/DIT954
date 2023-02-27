package com.car.model;

import org.junit.jupiter.api.*;

import com.car.model.Vehicle.Facing;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania vehicles.
 *
 */

public class ScaniaTest {
    private Scania mockScania;

    @BeforeEach
    void setup() {
        mockScania = new Scania(new Position(0, 0));
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
        Facing expectedFacing = null;
        switch (mockScania.getFacing()) {
            case NORTH:
                expectedFacing = Facing.WEST;
                break;
            case EAST:
                expectedFacing = Facing.NORTH;
                break;
            case SOUTH:
                expectedFacing = Facing.EAST;
                break;
            case WEST:
                expectedFacing = Facing.SOUTH;
                break;
        }

        mockScania.turnLeft();
        assertSame(expectedFacing, mockScania.getFacing());
    }

    @Test
    public void shouldTurnRight() {
        Facing expectedFacing = null;
        switch (mockScania.getFacing()) {
            case NORTH:
                expectedFacing = Facing.EAST;
                break;
            case EAST:
                expectedFacing = Facing.SOUTH;
                break;
            case SOUTH:
                expectedFacing = Facing.WEST;
                break;
            case WEST:
                expectedFacing = Facing.NORTH;
                break;
        }

        mockScania.turnRight();
        assertSame(expectedFacing, mockScania.getFacing());
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
