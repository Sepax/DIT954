package com.car.interfaces;

/**
 * The interface `Moveable` defines a contract for objects that can move.
 * The interface requires the implementation of methods to move, turn left, and turn right.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-01-31
 */
public interface Moveable {
  /**
   * Makes the object move.
   */
  void move();
  
  /**
   * Makes the object turn left.
   */
  void turnLeft();
  
  /**
   * Makes the object turn right.
   */
  void turnRight();
}
