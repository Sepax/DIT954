package com.car.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.car.interfaces.IVehicle;
import com.car.interfaces.Observer;
import com.car.model.World;
import java.awt.*;
import java.util.List;

/**
 * The view of the application
 */

public class VehicleView extends JFrame implements Observer {
    World world;
    DrawPanel drawPanel;

    public VehicleView(DrawPanel panel, World world) {
        this.drawPanel = panel;
        this.world = world;
        this.setVisible(true);
    }

    @Override
    public void notify(List<IVehicle> vehicles) {
        world.setVehicles(vehicles);
        drawPanel.repaint();
        this.drawPanel.repaint();
        this.drawPanel.revalidate();

    }

}
