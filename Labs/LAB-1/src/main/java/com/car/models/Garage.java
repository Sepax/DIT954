package com.car.models;

/**
 * The class `Garage` represents a garage. 
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-01
 * 
 * @param <TT>      The type of the transportables stored in the garage.
 * @param cars       The cars stored in the garage.
 * @param capacity   The capacity of the garage.
 */
public class Garage<T extends Transportable> {
  private int capacity;
  private Loadable<T> loadable;

  /**
   * Creates a new `Garage` object with specified capacity.
   */
  public Garage(int capacity) {
    this.capacity = capacity;
    loadable = new Loadable<>(capacity);
  }

  /**
   * Gets the list of loadables in the garage.
   */
  public Loadable<T> getLoadable() {
    return loadable;
  }
  /**
   * Gets the capacity of the garage.
   */
  public int getCapacity() {
    return capacity;
  }

}
