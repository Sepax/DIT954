package com.car.model;

import com.car.model.Ramp.RampState;
import com.car.model.Vehicle.Facing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania vehicles.
 */

public class FerryTest {
    private Ferry mockFerry;

    @BeforeEach
    void setup() {
        mockFerry = new Ferry(new Position(0, 0));
    }

    @Test
    public void shouldIncreaseSpeed() {
        mockFerry.startEngine();
        double speedBefore = mockFerry.getCurrentSpeed();
        mockFerry.gas(1);
        assertTrue(speedBefore <= mockFerry.getCurrentSpeed());
    }

    @Test
    public void shouldDecreaseSpeed() {
        mockFerry.startEngine();
        double speedBefore = mockFerry.getCurrentSpeed();
        mockFerry.brake(1);
        assertTrue(speedBefore >= mockFerry.getCurrentSpeed());
    }

    @Test
    public void shouldTurnLeft() {
        Facing expectedFacing = null;
        switch (mockFerry.getFacing()) {
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

        mockFerry.turnLeft();
        assertSame(expectedFacing, mockFerry.getFacing());
    }

    @Test
    public void shouldTurnRight() {
        Facing expectedFacing = null;
        switch (mockFerry.getFacing()) {
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

        mockFerry.turnRight();
        assertSame(expectedFacing, mockFerry.getFacing());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockFerry.getX();
        double yBefore = mockFerry.getY();
        mockFerry.stopEngine();
        mockFerry.move();
        assertTrue(xBefore == mockFerry.getX() && yBefore == mockFerry.getY());
    }

    @Test
    public void shouldMove() {
        mockFerry.startEngine();
        double xBefore = mockFerry.getX();
        double yBefore = mockFerry.getY();
        mockFerry.move();
        assertTrue(xBefore != mockFerry.getX() || yBefore != mockFerry.getY());
    }

    @Test
    public void shouldStartEngine() {
        mockFerry.startEngine();
        assertTrue(mockFerry.getCurrentSpeed() > 0);
    }

    @Test
    public void shouldStopEngine() {
        mockFerry.startEngine();
        mockFerry.stopEngine();
        assertTrue(mockFerry.getCurrentSpeed() == 0);
    }

    @Test
    public void shouldNotHaveSpeedAboveMaxEnginePower() {
        mockFerry.startEngine();
        for (int i = 0; i < 100; i++) {
            mockFerry.gas(1);
        }
        assertTrue(mockFerry.getCurrentSpeed() <= mockFerry.getEnginePower());
    }

    @Test
    public void shouldNotHaveSpeedBelowZero() {
        mockFerry.startEngine();
        mockFerry.brake(1);
        assertTrue(mockFerry.getCurrentSpeed() >= 0);
    }

    @Test
    public void shouldToggleRampIfStopped() {
        RampState stateBefore = mockFerry.getRamp().getState();
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        assertNotSame(stateBefore, mockFerry.getRamp().getState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockFerry.getRamp().getState();
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.lowerRamp();
        assertEquals(stateBefore, mockFerry.getRamp().getState());
    }

    @Test
    public void shouldNotRaiseRampIfMoving() {
        mockFerry.lowerRamp();
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.move();
        assertEquals(RampState.LOWERED.toString(), mockFerry.getRamp().getState().toString());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockFerry.loadVehicle(new Volvo240(new Position(0, 0)));
        mockFerry.loadVehicle(new Saab95(new Position(0, 0)));
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.move();
        for (Vehicle car : mockFerry.getCargo().getContent()) {
            assertEquals(mockFerry.getX(), car.getX());
            assertEquals(mockFerry.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.loadVehicle(new Volvo240(new Position(0, 0)));
        assertEquals(0, mockFerry.getCurrentSpeed());
        assertEquals(1, mockFerry.getCargo().getContent().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.loadVehicle(new Volvo240(new Position(0, 0)));
        mockFerry.unloadVehicle();
        assertEquals(0, mockFerry.getCargo().getContent().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.loadVehicle(new Volvo240(new Position(0, 0)));
        mockFerry.loadVehicle(new Scania(new Position(0, 0)));
        assertEquals(2, mockFerry.getCargo().getContent().size());
    }

    @Test
    public void shouldUseFifo() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.loadVehicle(new Volvo240(new Position(0, 0)));
        mockFerry.loadVehicle(new Saab95(new Position(0, 0)));
        mockFerry.unloadVehicle();
        assertEquals(mockFerry.getCargo().getContent().peek().getClass(), Saab95.class);
    }
}
