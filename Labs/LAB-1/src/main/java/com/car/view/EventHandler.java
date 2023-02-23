package com.car.view;

import java.util.List;

import com.car.models.Vehicle;
import com.car.models.VehicleService;

public class EventHandler {

    VehicleView view;
    VehicleService vehicleService;

    public EventHandler(VehicleView view, List<Vehicle> vehicles) {
        this.view = view;
        this.initActionListeners();
        this.vehicleService = new VehicleService(vehicles);
    }

    private void initActionListeners() {

        view.gasButton.addActionListener(e -> vehicleService.gas(view.gasAmount));

        view.brakeButton.addActionListener(e -> vehicleService.brake(view.gasAmount));

        view.startButton.addActionListener(e -> vehicleService.start());

        view.stopButton.addActionListener(e -> vehicleService.stop());

        view.turboOnButton.addActionListener(e -> vehicleService.enableTurbo());

        view.turboOffButton.addActionListener(e -> vehicleService.disableTurbo());

        view.liftBedButton.addActionListener(e -> vehicleService.liftBed());

        view.lowerBedButton.addActionListener(e -> vehicleService.lowerBed());

        view.lowerBedButton.addActionListener(e -> vehicleService.disableTurbo());
        view.addCarButton.addActionListener(e -> vehicleService.addRandomCar());
        view.removeCarButton.addActionListener(e -> vehicleService.removeCar());

    }

}
