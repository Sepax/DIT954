

package com.car.models;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {



    @Test
    void testRaiseFlatbed() {
        Scania scania = new Scania();
        scania.raiseFlatbed(10);
        assertEquals(10, scania.getFlatbedTilt());
        scania.raiseFlatbed(60);
        assertEquals(70, scania.getFlatbedTilt());
        scania.raiseFlatbed(10);
        assertEquals(70, scania.getFlatbedTilt());
    }

    @Test
    void testLowerFlatbed() {
        Scania scania = new Scania();
        scania.raiseFlatbed(70);
        scania.lowerFlatbed(10);
        assertEquals(60, scania.getFlatbedTilt());
        scania.lowerFlatbed(60);
        assertEquals(0, scania.getFlatbedTilt());
        scania.lowerFlatbed(10);
        assertEquals(0, scania.getFlatbedTilt());
    }

    @Test
    void testStartEngine() {
        Scania scania = new Scania();
        scania.startEngine();
        assertEquals(0.1, scania.getCurrentSpeed());
    }

    @Test
    void testDriveIfFlatbedIsTilted() {
        Scania scania = new Scania();
        scania.raiseFlatbed(70);
        scania.startEngine();
        scania.gas(1);
        assertEquals(0.1, scania.getCurrentSpeed());
    }

}

    

