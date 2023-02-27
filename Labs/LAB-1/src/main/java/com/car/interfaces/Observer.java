package com.car.interfaces;

import java.util.List;

public interface Observer {

    void notify(List<IVehicle> vehicles);
}
