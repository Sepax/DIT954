package com.car.models;

import com.car.models.Vehicle.Dir;
import com.car.models.Transporter.RampState;

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
        mockHauler = new Hauler(0,0);
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
        Dir expectedDirection = null;
        switch (mockHauler.direction) {
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

        mockHauler.turnLeft();
        assertSame(expectedDirection, mockHauler.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        Dir expectedDirection = null;
        switch (mockHauler.direction) {
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

        mockHauler.turnRight();
        assertSame(expectedDirection, mockHauler.getDirection());
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
        RampState stateBefore = mockHauler.getRampState();
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        assertNotSame(stateBefore, mockHauler.getRampState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockHauler.getRampState();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.lowerRamp();
        assertEquals(stateBefore, mockHauler.getRampState());
    }

    @Test
    public void shouldNotRaiseRampIfMoving() {
        mockHauler.lowerRamp();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        assertEquals(RampState.LOWERED.toString(), mockHauler.getRampState().toString());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockHauler.getLoadable().loadCar(new Volvo240(0,0));
        mockHauler.getLoadable().loadCar(new Saab95(0,0));
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        for (Vehicle car : mockHauler.getLoadable().getLoadedVehicles()) {
            assertEquals(mockHauler.getX(), car.getX());
            assertEquals(mockHauler.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.getLoadable().loadCar(new Volvo240(0,0));
        assertEquals(0, mockHauler.getCurrentSpeed());
        assertEquals(1, mockHauler.getLoadable().getLoadedVehicles().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.getLoadable().loadCar(new Volvo240(0,0));
        mockHauler.getLoadable().unloadCar();
        assertEquals(0, mockHauler.getLoadable().getLoadedVehicles().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockHauler.brake(1);
        mockHauler.lowerRamp();
        mockHauler.getLoadable().loadCar(new Volvo240(0,0));
        mockHauler.getLoadable().loadCar(new Scania(0,0));
        assertEquals(2, mockHauler.getLoadable().getNumberOfCars());
    }
}
