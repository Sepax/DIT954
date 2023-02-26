package com.car.interfaces;

import com.car.model.Turbo;

public interface ITurbo extends IVehicle {

    public void enableTurbo();

    public void disableTurbo();

    public boolean getTurboState();

}
