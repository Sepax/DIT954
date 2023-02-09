package com.car.view;

import javax.swing.*;

import com.car.models.Saab95;
import com.car.models.Scania;
import com.car.models.Vehicle;
import com.car.models.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the Controller part in the MVC pattern.
 * It contains a Timer that updates the car's position.
 *  
 * @author Kiril Curlinov, Sebastian Pålsson, Gabrielle Frattini
 * @since 2023-02-08
 * 
 * @param frame The frame that represents this instance View of the MVC pattern
 * @param cars A list of cars
 * @param delay The delay (ms) corresponds to 20 updates a sec (hz)
 * @param timer The timer is started with an listener that executes the statements
 * @param cc A object of the CarController class
 * 
 */
public class CarController {

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    CarView frame;
    ArrayList<Vehicle> cars = new ArrayList<>();

    /**
     * Main method that starts the program
     */
    public static void main(String[] args) {

        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0));
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.setVisible(true);
        
        cc.timer.start();
    }

    /**
     * Implements the actions for the program to be executed when the timer is started
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                
                car.move();
                
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (car instanceof Volvo240) {
                    frame.drawPanel.moveVolvo(x, y);
                } else if (car instanceof Saab95) {
                    frame.drawPanel.moveSaab(x, y);
                } else if (car instanceof Scania) {
                    frame.drawPanel.moveScania(x, y);
                }

                frame.drawPanel.repaint();
                frame.drawPanel.revalidate();
            }   
        }
    }

    /**
     * Start all cars
     */
    void start() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    /**
     * Stop all cars
     */
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

    void gas(int amount) {
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
    void brake(double amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Enables turbo for Saab95
     */
    public void enableTurbo() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    /**
     * Disables turbo for Saab95
     */
    public void disableTurbo() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    /**
     * Lifts the flatbed for Scania
     */
    public void liftBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseFlatbed(10);
            }
        }
    }

    /**
     * Lowers the flatbed for Scania
     */
    public void lowerBed() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerFlatbed(10);
            }
    }
}
}
