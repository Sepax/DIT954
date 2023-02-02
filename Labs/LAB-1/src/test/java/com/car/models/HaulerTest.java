package com.car.models;

import com.car.models.Car.Dir;
import com.car.models.Hauler.RampState;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania cars.
 *
 */

public class HaulerTest {
    private Hauler mockHauler;

    @BeforeEach
    void setup() {
        mockHauler = new Hauler();
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
        mockHauler.turnLeft();
        assertSame(Dir.WEST, mockHauler.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        mockHauler.turnRight();
        assertSame(Dir.EAST, mockHauler.getDirection());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockHauler.getX();
        double yBefore = mockHauler.getY();
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
        mockHauler.toggleRamp();
        assertNotSame(stateBefore, mockHauler.getRampState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockHauler.getRampState();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.toggleRamp();
        assertEquals(stateBefore, mockHauler.getRampState());
    }

    @Test
    public void shouldRaiseRampIfMoving() {
        mockHauler.toggleRamp();
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        assertEquals(RampState.RAISED, mockHauler.getRampState());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockHauler.loadCar(new Volvo240());
        mockHauler.loadCar(new Saab95());
        mockHauler.startEngine();
        mockHauler.gas(1);
        mockHauler.move();
        for (Car car : mockHauler.getLoadedCars()) {
            assertEquals(mockHauler.getX(), car.getX());
            assertEquals(mockHauler.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockHauler.brake(1);
        mockHauler.toggleRamp();
        mockHauler.loadCar(new Volvo240());
        assertEquals(1, mockHauler.getLoadedCars().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockHauler.brake(1);
        mockHauler.toggleRamp();
        mockHauler.loadCar(new Volvo240());
        mockHauler.unloadCar();
        assertEquals(0, mockHauler.getLoadedCars().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockHauler.brake(1);
        mockHauler.toggleRamp();
        mockHauler.loadCar(new Volvo240());
        mockHauler.loadCar(new Scania());
        assertEquals(1, mockHauler.getLoadedCars().size());
    }
}
