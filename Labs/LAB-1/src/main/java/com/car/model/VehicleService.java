package com.car.model;

import java.util.List;

import com.car.interfaces.IVehicle;
import com.car.model.Vehicle.Facing;

public class VehicleService {

    private double newCarY = 0;

    private World world;

    public VehicleService(World world) {
        this.world = world;
    }

    public void start() {
        for (IVehicle car : world.getAllVehicles()) {
            car.startEngine();
        }
    }

    public void stop() {
        for (IVehicle car : world.getAllVehicles()) {
            car.stopEngine();
        }
    }

    /**
     * Gas each vehicle
     * 
     * @param amount
     */

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : world.getAllVehicles()) {
            car.gas(gas);
        }
    }

    /**
     * Brake each vehicle
     * 
     * @param amount
     */
    public void brake(double amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle car : world.getAllVehicles()) {
            car.brake(brake);
        }
    }

    public void enableTurbo() {
        for (IVehicle car : world.getAllVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95) car).enableTurbo();
            }
        }
    }

    public void disableTurbo() {
        for (IVehicle car : world.getAllVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95) car).disableTurbo();
            }
        }
    }

    public void liftBed() {
        for (IVehicle car : world.getAllVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).raiseFlatbed(10);
            }
        }
    }

    public void lowerBed() {
        for (IVehicle car : world.getAllVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).lowerFlatbed(10);
            }
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

    public void addRandomCar() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                addCar(VehicleFactory.createVolvo240(0, newCarY));
                break;
            case 1:
                addCar(VehicleFactory.createSaab95(0, newCarY));
                break;
            case 2:
                addCar(VehicleFactory.createScania(0, newCarY));
                break;
            default:
                break;
        }
    }

    public void addCar(IVehicle car) {

        if (this.world.getAllVehicles().size() < 10) {
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
        if (world.getAllVehicles().size() > 1) {
            IVehicle first = world.getAllVehicles().get(0);
            world.removeVehicle(first);
        }

    }

    public List<IVehicle> getCars() {
        return world.getAllVehicles();
    }

}
