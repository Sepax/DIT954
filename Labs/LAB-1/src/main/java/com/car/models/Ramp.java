package com.car.models;

public class Ramp {
    RampState ramp;

    public enum RampState {
        RAISED, LOWERED
    }

    public Ramp() {
        ramp = RampState.RAISED;
    }

    public void raiseRamp() {
        ramp = RampState.RAISED;
    }

    public void lowerRamp() {
        ramp = RampState.LOWERED;
    }

    public RampState getState() {
        return ramp;
    }
}
