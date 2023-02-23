package com.car.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.car.models.Vehicle;

/**
 * This class shows the speed and type of vehicles in the program
 */

public class SpeedView extends JPanel{

    private JLabel speedLabel;

    public SpeedView() {
        speedLabel = new JLabel();
        this.add(speedLabel);
    }

    public void updateSpeed(Vehicle vehicle) {
        speedLabel.setText(vehicle.getModelName() + ": " + vehicle.getCurrentSpeed());
    }

    
}
