

package com.car.models;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void testScania() {
        Scania scania = new Scania();
        assertEquals(2, scania.getNrDoors());
        assertEquals(Color.CYAN, scania.getColor());
        assertEquals(200, scania.getEnginePower());
        assertEquals("Scania", scania.getModelName());
        assertEquals(0, scania.getFlatbedTilt());
    }

}

    

