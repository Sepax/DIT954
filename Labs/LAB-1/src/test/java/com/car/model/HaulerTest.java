package com.car.model;

import com.car.model.Ramp.RampState;
import com.car.model.Vehicle.Facing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania vehicles.
 *
 */

public class HaulerTest {
    private Hauler mockHauler;

    @BeforeEach
    void setup() {
        mockHauler = new Hauler(new Position(0, 0));
    }

    @Test
    public void shouldIncreaseSpeed() {
        mockHauler.startEngine();
        double speedBefore = mockHauler.getCurrentSpeed();
        mockHauler.gas(1);
        assertTrue(speedBefore <= mockHauler.getCurrentSpeed());
    }

    @Test
    public void shouldDecreaseSpeed() {
        mockHauler.startEngine();
        double speedBefore = mockHauler.getCurrentSpeed();
        mockHauler.brake(1);
        assertTrue(speedBefore >= mockHauler.getCurrentSpeed());
    }

    @Test
    public void shouldTurnLeft() {
        Facing expectedFacing = null;
        switch (mockHauler.getFacing()) {
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

        mockHauler.turnLeft();
        assertSame(expectedFacing, mockHauler.getFacing());
    }

    @Test
    public void shouldTurnRight() {
        Facing expectedFacing = null;
        switch (mockHauler.getFacing()) {
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

        mockHauler.turnRight();
        assertSame(expectedFacing, mockHauler.getFacing());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockHauler.getX();
        double yBefore = mockHauler.getY();
        mockHauler.stopEngine();
        mockHauler.move();
        assertTrue(xBefore == mockHauler.getX() && yBefore == mockHauler.getY());
    }

    @Test
    public void shouldMove() {
        mockHauler.startEngine();
        double xBefore = mockHauler.getX();
        double yBefore = mockHauler.getY();
        mockHauler.move();
        assertTrue(xBefore != mockHauler.getX() || yBefore != mockHauler.getY());
    }

    @Test
    public void shouldStartEngine() {
        mockHauler.startEngine();
        assertTrue(mockHauler.getCurrentSpeed() > 0);
    }

    @Test
    public void shouldStopEngine() {
        mockHauler.startEngine();
        mockHauler.stopEngine();
        assertTrue(mockHauler.getCurrentSpeed() == 0);
    }

    @Test
    public void shouldNotHaveSpeedAboveMaxEnginePower() {
        mockHauler.startEngine();
        for (int i = 0; i < 100; i++) {
            mockHauler.gas(1);
        }
        assertTrue(mockHauler.getCurrentSpeed() <= mockHauler.getEnginePower());
    }

    @Test
    public void shouldNotHaveSpeedBelowZero() {
        mockHauler.startEngine();
        mockHauler.brake(1);
        assertTrue(mockHauler.getCurrentSpeed() >= 0);
    }

    @Test
    public void shouldToggleRampIfStopped() {
        RampState stateBefore = mockHauler.getRamp().getState();
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        assertNotSame(stateBefore, mockHauler.getRamp().getState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockHauler.getRamp().getState();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.lowerRamp();
        assertEquals(stateBefore, mockHauler.getRamp().getState());
    }

    @Test
    public void shouldNotRaiseRampIfMoving() {
        mockHauler.lowerRamp();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        assertEquals(RampState.LOWERED.toString(), mockHauler.getRamp().getState().toString());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockHauler.loadVehicle(new Volvo240(new Position(0, 0)));
        mockHauler.loadVehicle(new Saab95(new Position(0, 0)));
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        for (Vehicle car : mockHauler.getCargo().getContent()) {
            assertEquals(mockHauler.getX(), car.getX());
            assertEquals(mockHauler.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.loadVehicle(new Volvo240(new Position(0, 0)));
        assertEquals(0, mockHauler.getCurrentSpeed());
        assertEquals(1, mockHauler.getCargo().getContent().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.loadVehicle(new Volvo240(new Position(0, 0)));
        mockHauler.unloadVehicle();
        assertEquals(0, mockHauler.getCargo().getContent().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.loadVehicle(new Volvo240(new Position(0, 0)));
        mockHauler.loadVehicle(new Scania(new Position(0, 0)));
        assertEquals(1, mockHauler.getCargo().getContent().size());
    }
}
