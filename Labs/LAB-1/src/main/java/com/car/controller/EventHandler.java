package com.car.controller;

import com.car.model.VehicleService;
import com.car.model.World;
import com.car.view.VehicleView;

public class EventHandler {

    VehicleController cc;
    VehicleService vehicleService;

    public EventHandler(VehicleController cc, World world) {
        this.cc = cc;
        this.initActionListeners();
        this.vehicleService = new VehicleService(world);
    }

    private void initActionListeners() {

        cc.gasButton.addActionListener(e -> vehicleService.gas(cc.getGasAmount()));

        cc.brakeButton.addActionListener(e -> vehicleService.brake(cc.getGasAmount()));

        cc.startButton.addActionListener(e -> vehicleService.start());

        cc.stopButton.addActionListener(e -> vehicleService.stop());

        cc.turboOnButton.addActionListener(e -> vehicleService.enableTurbo());

        cc.turboOffButton.addActionListener(e -> vehicleService.disableTurbo());

        cc.liftBedButton.addActionListener(e -> vehicleService.liftBed());

        cc.lowerBedButton.addActionListener(e -> vehicleService.lowerBed());

        cc.lowerBedButton.addActionListener(e -> vehicleService.disableTurbo());

        cc.addCarButton.addActionListener(e -> vehicleService.addRandomVehicle());

        cc.removeCarButton.addActionListener(e -> vehicleService.removeCar());

    }

}
