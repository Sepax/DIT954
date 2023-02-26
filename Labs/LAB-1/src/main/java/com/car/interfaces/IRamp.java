package com.car.interfaces;

import com.car.model.Ramp;

public interface IRamp extends IVehicle {

    public Ramp getRamp();

    public void raiseRamp();

    public void lowerRamp();

}
