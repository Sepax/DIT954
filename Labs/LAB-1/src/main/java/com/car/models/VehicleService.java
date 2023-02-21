package com.car.models;

import java.util.List;

import com.car.models.Vehicle.Facing;

public class VehicleService {

    private final List<Vehicle> cars;

    public VehicleService(List<Vehicle> vehicles) {
        this.cars = vehicles;
    }

    public void start() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    public void stop() {
        for (Vehicle car : cars) {
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
        for (Vehicle car : cars) {
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
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void enableTurbo() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).enableTurbo();
            }
        }
    }

    public void disableTurbo() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).disableTurbo();
            }
        }
    }

    public void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseFlatbed(10);
            }
        }
    }

    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerFlatbed(10);
            }
        }
    }

    public void reverseDirection(Vehicle car) {

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

    public void addCar() {
        return;
    }

    public void removeCar() {
        return;
    }

}