package com.car.view;

import com.car.model.VehicleFactory;
import com.car.model.World;

import com.car.controller.EventHandler;
import com.car.controller.VehicleController;

public class Application {

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        World world = new World();
        world.addVehicle(VehicleFactory.createVolvo240(0, 100));
        world.addVehicle(VehicleFactory.createSaab95(0, 200));
        world.addVehicle(VehicleFactory.createScania(0, 300));

        DrawPanel drawPanel = new DrawPanel(world, 800, 800 - 240);
        VehicleView view = new VehicleView(drawPanel, world);
        VehicleController cc = new VehicleController(drawPanel, "CarSim 1.0");

        world.addObserver(view);
        new EventHandler(cc, world);

        world.start();

    }
}
