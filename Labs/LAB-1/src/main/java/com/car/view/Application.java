package com.car.view;

import com.car.model.VehicleFactory;
import com.car.model.World;

import java.util.ArrayList;
import java.util.List;

import com.car.controller.VehicleController;
import com.car.model.Vehicle;

public class Application {

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        World world = new World();

        world.addVehicle(VehicleFactory.createVolvo240(0, 100));
        world.addVehicle(VehicleFactory.createSaab95(0, 200));
        world.addVehicle(VehicleFactory.createScania(0, 300));

        VehicleView view = new VehicleView("Grabbarna Grus <3", world);
        VehicleController cc = new VehicleController(view, world);

        cc.getVehicleView().setVisible(true);
        cc.startController();

    }
}
