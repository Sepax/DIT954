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
    public void shouldNotMoveIfFlatbedIsUp() {
        mockScania.setFlatbedTilt(70);
        mockScania.move();
        assertEquals(0, mockScania.getX());
        assertEquals(0, mockScania.getY());
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


    

