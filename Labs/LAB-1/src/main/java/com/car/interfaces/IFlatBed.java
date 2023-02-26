package com.car.interfaces;

public interface IFlatBed extends IVehicle {

    public void raiseFlatbed(double degrees);

    public void lowerFlatbed(double degrees);

    public double getFlatbedTilt();
}
