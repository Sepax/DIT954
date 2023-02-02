package com.car.models;

import com.car.models.Car.Dir;
import com.car.models.Transporter.RampState;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Scania cars.
 *
 */

public class CarferryTest {
    private CarFerry mockCarrferry;

    @BeforeEach
    void setup() {
        mockCarrferry = new CarFerry();
    }

    @Test
    public void shouldIncreaseSpeed() {
        mockCarrferry.startEngine();
        double speedBefore = mockCarrferry.getCurrentSpeed();
        mockCarrferry.gas(1);
        assertTrue(speedBefore <= mockCarrferry.getCurrentSpeed());
    }

    @Test
    public void shouldDecreaseSpeed() {
        mockCarrferry.startEngine();
        double speedBefore = mockCarrferry.getCurrentSpeed();
        mockCarrferry.brake(1);
        assertTrue(speedBefore >= mockCarrferry.getCurrentSpeed());
    }

    @Test
    public void shouldTurnLeft() {
        mockCarrferry.turnLeft();
        assertSame(Dir.WEST, mockCarrferry.getDirection());
    }

    @Test
    public void shouldTurnRight() {
        mockCarrferry.turnRight();
        assertSame(Dir.EAST, mockCarrferry.getDirection());
    }

    @Test
    public void shouldNotMove() {
        double xBefore = mockCarrferry.getX();
        double yBefore = mockCarrferry.getY();
        mockCarrferry.move();
        assertTrue(xBefore == mockCarrferry.getX() && yBefore == mockCarrferry.getY());
    }

    @Test
    public void shouldMove() {
        mockCarrferry.startEngine();
        double xBefore = mockCarrferry.getX();
        double yBefore = mockCarrferry.getY();
        mockCarrferry.move();
        assertTrue(xBefore != mockCarrferry.getX() || yBefore != mockCarrferry.getY());
    }

    @Test
    public void shouldStartEngine() {
        mockCarrferry.startEngine();
        assertTrue(mockCarrferry.getCurrentSpeed() > 0);
    }

    @Test
    public void shouldStopEngine() {
        mockCarrferry.startEngine();
        mockCarrferry.stopEngine();
        assertTrue(mockCarrferry.getCurrentSpeed() == 0);
    }

    @Test
    public void shouldNotHaveSpeedAboveMaxEnginePower() {
        mockCarrferry.startEngine();
        for (int i = 0; i < 100; i++) {
            mockCarrferry.gas(1);
        }
        assertTrue(mockCarrferry.getCurrentSpeed() <= mockCarrferry.getEnginePower());
    }

    @Test
    public void shouldNotHaveSpeedBelowZero() {
        mockCarrferry.startEngine();
        mockCarrferry.brake(1);
        assertTrue(mockCarrferry.getCurrentSpeed() >= 0);
    }

    @Test
    public void shouldToggleRampIfStopped() {
        RampState stateBefore = mockCarrferry.getRampState();
        mockCarrferry.brake(1);
        mockCarrferry.lowerRamp();
        assertNotSame(stateBefore, mockCarrferry.getRampState());
    }

    @Test
    public void shouldNotToggleRampIfMoving() {
        RampState stateBefore = mockCarrferry.getRampState();
        mockCarrferry.startEngine();
        mockCarrferry.gas(1);
        mockCarrferry.lowerRamp();
        assertEquals(stateBefore, mockCarrferry.getRampState());
    }

    @Test
    public void shouldRaiseRampIfMoving() {
        mockCarrferry.lowerRamp();
        mockCarrferry.startEngine();
        mockCarrferry.gas(1);
        mockCarrferry.move();
        assertEquals(RampState.RAISED.toString(), mockCarrferry.getRampState().toString());
    }

    @Test
    public void loadedCarsShouldHaveSameCoordinatesAsHauler() {
        mockCarrferry.loadCar(new Volvo240());
        mockCarrferry.loadCar(new Saab95());
        mockCarrferry.startEngine();
        mockCarrferry.gas(1);
        mockCarrferry.move();
        for (Car car : mockCarrferry.getLoadedCars()) {
            assertEquals(mockCarrferry.getX(), car.getX());
            assertEquals(mockCarrferry.getY(), car.getY());
        }
    }

    @Test
    public void shouldLoadCar() {
        mockCarrferry.brake(1);
        mockCarrferry.lowerRamp();
        System.out.println(mockCarrferry.getRampState().toString());
        mockCarrferry.loadCar(new Volvo240());
        assertTrue(mockCarrferry.getCurrentSpeed() == 0);
        assertEquals(1, mockCarrferry.getLoadedCars().size());
    }

    @Test
    public void shouldUnloadCar() {
        mockCarrferry.brake(1);
        mockCarrferry.lowerRamp();
        mockCarrferry.loadCar(new Volvo240());
        mockCarrferry.unloadCar();
        assertEquals(0, mockCarrferry.getLoadedCars().size());
    }

    @Test
    public void shouldOnlyLoadHaulableCars() {
        mockCarrferry.brake(1);
        mockCarrferry.lowerRamp();
        mockCarrferry.loadCar(new Volvo240());
        mockCarrferry.loadCar(new Scania());
        assertEquals(1, mockCarrferry.getLoadedCars().size());
    }


    @Test
    public void shouldUseFifo() {
        mockCarrferry.brake(1);
        mockCarrferry.lowerRamp();
        mockCarrferry.loadCar(new Volvo240());
        mockCarrferry.loadCar(new Saab95());
        mockCarrferry.unloadCar();
        assertEquals(mockCarrferry.getLoadedCars().peek().getClass(), Saab95.class);
    }
}