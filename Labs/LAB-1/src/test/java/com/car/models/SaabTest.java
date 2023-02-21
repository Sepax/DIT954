package com.car.models;

import com.car.models.Vehicle.Facing;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Saab vehicles.
 *
 */

public class SaabTest {
    private Saab95 mockSaab;

    @BeforeEach
    void setup() {
        mockSaab = new Saab95(new Position(0, 0));
    }

    @Test
    public void shouldIncreaseSpeed() {
        mockSaab.startEngine();
        double speedBefore = mockSaab.getCurrentSpeed();
        mockSaab.gas(1);
        assertTrue(speedBefore <= mockSaab.getCurrentSpeed());
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
        Facing expectedFacing = null;
        switch (mockSaab.getFacing()) {
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

        mockSaab.turnLeft();
        assertSame(expectedFacing, mockSaab.getFacing());
    }

    @Test
    public void shouldTurnRight() {
        Facing expectedFacing = null;
        switch (mockSaab.getFacing()) {
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

        mockSaab.turnRight();
        assertSame(expectedFacing, mockSaab.getFacing());
    }

    @Test
    public void shouldTurnOnTurbo() {
        mockSaab.enableTurbo();
        assertTrue(mockSaab.getTurboState());
    }

    @Test
    public void shouldTurnOffTurbo() {
        mockSaab.disableTurbo();
        assertFalse(mockSaab.getTurboState());
    }

    @Test
    public void shouldNotTurnOnTurbo() {
        mockSaab.disableTurbo();
        assertFalse(mockSaab.getTurboState());
    }

    @Test
    public void shouldNotTurnOffTurbo() {
        mockSaab.enableTurbo();
        assertTrue(mockSaab.getTurboState());
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
        for (int i = 0; i < 100; i++) {
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
