package com.car.view;

import javax.swing.*;

import com.car.models.Position;
import com.car.models.Saab95;
import com.car.models.Scania;
import com.car.models.Vehicle;
import com.car.models.Volvo240;
import com.car.models.Vehicle.Facing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the Controller part in the MVC pattern.
 * It contains a Timer that updates the car's position.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 * @param frame The frame that represents this instance View of the MVC pattern
 * @param cars  A list of cars
 * @param delay The delay (ms) corresponds to 20 updates a sec (hz)
 * @param timer The timer is started with an listener that executes the
 *              statements
 * @param cc    A object of the CarController class
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

    cc.cars.add(new Volvo240(new Position(0,0)));
    cc.cars.add(new Saab95(new Position(0, 100)));
    cc.cars.add(new Scania(new Position(0, 200)));

    // Start a new view and send a reference of self
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.frame.setVisible(true);

    cc.timer.start();

  }

  /*
   * Each step the TimerListener moves all the cars in the list and tells the
   * view to update its images. Change this method to your needs.
   */


  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (Vehicle car : cars) {

        reverseFacingectionOnBump(car);
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

        // repaint() calls the paintComponent method of the panel
        frame.drawPanel.repaint();
        frame.drawPanel.revalidate();
      }

    }
  }

  void start() {
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
   * Enables turbo on Saab95
   */
  public void enableTurbo() {
    for (Vehicle car : cars) {
      if (car instanceof Saab95) {
        ((Saab95) car).setTurboOn();
      }
    }
  }

  /**
   * Disables turbo on Saab95
   */
  public void disableTurbo() {
    for (Vehicle car : cars) {
      if (car instanceof Saab95) {
        ((Saab95) car).setTurboOff();
      }
    }
  }

  /**
   * Lifts the flatbed on Scania
   */
  public void liftBed() {
    for (Vehicle car : cars) {
      if (car instanceof Scania) {
        ((Scania) car).raiseFlatbed(10);
      }
    }
  }

  /**
   * Lowers the flatbed on Scania
   */
  public void lowerBed() {
    for (Vehicle car : cars) {
      if (car instanceof Scania) {
        ((Scania) car).lowerFlatbed(10);
      }
    }
  }

  /**
   * Reverses direction of the vehicles
   */
  public void reverseFacingection(Vehicle car) {

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

  /**
   * Reverses direction of the vehicles when they bump into the border
   */
  private void reverseFacingectionOnBump(Vehicle car) {
    int imageWidth = frame.drawPanel.volvoImage.getWidth();
    int rightBorder = frame.getWidth();

    if (car.getX() <= 0 || car.getX() + imageWidth >= rightBorder) {
      reverseFacingection(car);
      car.move();
    }
  }
}
