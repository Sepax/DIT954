package com.car.view;

import com.car.models.VehicleFactory;
import com.car.models.VehicleService;

import java.util.ArrayList;
import java.util.List;

import com.car.models.Vehicle;

public class Application {

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.add(VehicleFactory.createVolvo240(0, 100));
        vehicles.add(VehicleFactory.createSaab95(0, 200));
        vehicles.add(VehicleFactory.createScania(0, 300));

        VehicleView view = new VehicleView("Grabbarna Grus <3", vehicles);
        VehicleController cc = new VehicleController(view, vehicles);

        cc.frame.setVisible(true);
        cc.startController();

    }
}
