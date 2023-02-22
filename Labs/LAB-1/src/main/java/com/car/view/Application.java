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

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        VehicleService vehicleService = new VehicleService(new ArrayList<Vehicle>());

        vehicleService.addCar(VehicleFactory.createVolvo240(0, 200));
        vehicleService.addCar(VehicleFactory.createSaab95(0, 300));
        vehicleService.addCar(VehicleFactory.createScania(0, 400));

        CarView view = new CarView("CarSim 1.0", vehicleService.getCars());

        CarController cc = new CarController(view, vehicleService.getCars());

        cc.frame.setVisible(true);

        cc.startController();

    }
}
