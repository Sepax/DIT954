package com.car.models;

import com.car.models.Vehicle.Dir;
import com.car.models.Transporter.RampState;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania vehicles.
 *
 */

public class FerryTest {
    private Ferry mockFerry;

    @BeforeEach
    void setup() {
        mockFerry = new Ferry();
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
        mockFerry.turnLeft();
        assertSame(Dir.WEST, mockFerry.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        mockFerry.turnRight();
        assertSame(Dir.EAST, mockFerry.getDirection());
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
        RampState stateBefore = mockFerry.getRampState();
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        assertNotSame(stateBefore, mockFerry.getRampState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockFerry.getRampState();
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.lowerRamp();
        assertEquals(stateBefore, mockFerry.getRampState());
    }

    @Test
    public void shouldNotRaiseRampIfMoving() {
        mockFerry.lowerRamp();
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.move();
        assertEquals(RampState.LOWERED.toString(), mockFerry.getRampState().toString());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockFerry.getLoadable().loadCar(new Volvo240());
        mockFerry.getLoadable().loadCar(new Saab95());
        mockFerry.startEngine();
        mockFerry.gas(1);
        mockFerry.move();
        for (Vehicle car : mockFerry.getLoadable().getLoadedVehicles()) {
            assertEquals(mockFerry.getX(), car.getX());
            assertEquals(mockFerry.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.getLoadable().loadCar(new Volvo240());
        assertEquals(0, mockFerry.getCurrentSpeed());
        assertEquals(1, mockFerry.getLoadable().getLoadedVehicles().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.getLoadable().loadCar(new Volvo240());
        mockFerry.getLoadable().unloadCar();
        assertEquals(0, mockFerry.getLoadable().getLoadedVehicles().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.getLoadable().loadCar(new Volvo240());
        mockFerry.getLoadable().loadCar(new Scania());
        assertEquals(2, mockFerry.getLoadable().getLoadedVehicles().size());
    }


    @Test
    public void shouldUseFifo() {
        mockFerry.brake(1);
        mockFerry.lowerRamp();
        mockFerry.getLoadable().loadCar(new Volvo240());
        mockFerry.getLoadable().loadCar(new Saab95());
        mockFerry.unloadCar();
        assertEquals(mockFerry.getLoadable().getLoadedVehicles().peek().getClass(), Saab95.class);
    }
}
