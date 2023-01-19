import java.awt.*;

public class Car implements Moveable {
      protected int nrDoors; // Number of doors on the car
      protected double enginePower; // Engine power of the car
      protected double currentSpeed; // The current speed of the car
      protected Color color; // Color of the car
      protected String modelName; // The car model name

      protected Dir direction; // Direction of the car

      protected double x;
      protected double y;


      enum Dir {
        NORTH, EAST, SOUTH, WEST
      }


      public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = Dir.NORTH;
        stopEngine();
      }

      public int getNrDoors() {
        return nrDoors;
      }

      public double getEnginePower() {
        return enginePower;
      }

      public double getCurrentSpeed() {
        return currentSpeed;
      }

      public Color getColor() {
        return color;
      }

      public void setColor(Color clr) {
        color = clr;
      }

      public void startEngine() {
        currentSpeed = 0.1;
      }

      public void stopEngine() {
        currentSpeed = 0;
      }

      // TODO fix this method according to lab pm
      public void gas(double amount){
        incrementSpeed(amount);
      }

      // TODO fix this method according to lab pm
      public void brake(double amount){
        decrementSpeed(amount);
      }

      public void incrementSpeed(double amount){}

      public void decrementSpeed(double amount){}

      public void move() {
          switch (this.direction) {
              case NORTH:
                  this.y += currentSpeed;
              case EAST:
                  this.x += currentSpeed;
              case SOUTH:
                  this.y -= currentSpeed;
              case WEST:
                  this.x -= currentSpeed;
          }
      }

      public void turnLeft() {
          switch (this.direction) {
              case NORTH:
                  this.direction = Dir.WEST;
              case EAST:
                  this.direction = Dir.NORTH;
              case SOUTH:
                  this.direction = Dir.EAST;
              case WEST:
                  this.direction = Dir.SOUTH;
          }
      }

      public void turnRight() {
          switch (this.direction) {
              case NORTH:
                  this.direction = Dir.EAST;
              case EAST:
                  this.direction = Dir.SOUTH;
              case SOUTH:
                  this.direction = Dir.WEST;
              case WEST:
                  this.direction = Dir.NORTH;
          }
      }
}
