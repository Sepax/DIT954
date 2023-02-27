package com.car.model;

import java.util.List;

import com.car.interfaces.IFlatBed;
import com.car.interfaces.ITurbo;
import com.car.interfaces.IVehicle;
import com.car.model.Vehicle.Facing;

public class VehicleService {

    private double newCarY = 0;

    private World world;

    public VehicleService(World world) {
        this.world = world;
    }

    public void start() {
        for (IVehicle car : world.getVehicles()) {
            car.startEngine();
        }
    }

    public void stop() {
        for (IVehicle car : world.getVehicles()) {
            car.stopEngine();
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : world.getVehicles()) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle car : world.getVehicles()) {
            car.brake(brake);
        }
    }

    public void enableTurbo() {
        for (ITurbo vehicle : world.getVehicles(ITurbo.class)) {
            vehicle.enableTurbo();
        }
    }

    public void disableTurbo() {
        for (ITurbo vehicle : world.getVehicles(ITurbo.class)) {
            vehicle.disableTurbo();
        }
    }

    public void liftBed() {
        for (IFlatBed vehicle : world.getVehicles(IFlatBed.class)) {
            vehicle.raiseFlatbed(10);
        }
    }

    public void lowerBed() {
        for (IFlatBed vehicle : world.getVehicles(IFlatBed.class)) {
            vehicle.lowerFlatbed(10);
        }
    }

    public void reverseDirection(IVehicle car) {

        switch (car.getFacing()) {
            case EAST:
                car.setFacing(Facing.WEST);
                break;
            case WEST:
                car.setFacing(Facing.EAST);
                break;
            default:
                break;
        }
    }

    public boolean hasBumpedInWall(double carX, int imageWidth, int borderWidth) {
        return carX <= 0 || carX + imageWidth >= borderWidth;
    }

    public void addRandomVehicle() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                addVehicle(VehicleFactory.createVolvo240(0, newCarY));
                break;
            case 1:
                addVehicle(VehicleFactory.createSaab95(0, newCarY));
                break;
            case 2:
                addVehicle(VehicleFactory.createScania(0, newCarY));
                break;
            default:
                break;
        }
    }

    public void addVehicle(IVehicle car) {

        if (this.world.getVehicles().size() < 10) {
            this.world.addVehicle(car);
            if (car.getY() > newCarY) {
                newCarY = car.getY();
            } else {
                newCarY += 70;
            }
        }
        if (newCarY > 600) {
            newCarY = 0;
        }
    }

    public void removeCar() {
        if (world.getVehicles().size() > 1) {
            IVehicle first = world.getVehicles().get(0);
            world.removeVehicle(first);
        }

    }

    public List<IVehicle> getVehicles() {
        return world.getVehicles();
    }

}
