package com.car.view;

import com.car.models.VehicleFactory;
import com.car.models.VehicleService;

import java.util.ArrayList;
import java.util.List;

import com.car.models.Position;
import com.car.models.Saab95;
import com.car.models.Scania;
import com.car.models.Vehicle;
import com.car.models.Volvo240;

public class Application {
    private static ArrayList<Vehicle> vehicles;
    private static CarController cc;

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {
        vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Volvo240(new Position(0, 0)));
        vehicles.add(new Saab95(new Position(0, 100)));
        vehicles.add(new Scania(new Position(0, 200)));
        
        CarView view = new CarView("CarSim 1.0");
        cc = new CarController(view, vehicles);

        // Start a new view and send a reference of self
        cc.frame.setVisible(true);
        cc.startController();
    }
}
