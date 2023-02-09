package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabriele Frattini
 * @since 2023-02-08
 * 
 */

public class DrawPanel extends JPanel {

  /**
   * A BufferedImage object represents an image of a Vehicle.
   */
  BufferedImage volvoImage;
  BufferedImage saabImage;
  BufferedImage scaniaImage;

  /**
   * A Point object represents a pair of (x,y) coordinates for a Vehicle.
   */
  Point volvoPoint = new Point();
  Point saabPoint = new Point();
  Point scaniaPoint = new Point();

  /**
   * Moves the Volvo vehicle to the specified coordinates
   */
  public void moveVolvo(int x, int y) {
    volvoPoint.x = x;
    volvoPoint.y = y;
  }

  /**
   * Moves the Saab vehicle to the specified coordinates
   */
  public void moveSaab(int x, int y) {
    saabPoint.x = x;
    saabPoint.y = y;
  }

  /**
   * Moves the Scania vehicle to the specified coordinates
   */
  public void moveScania(int x, int y) {
    scaniaPoint.x = x;
    scaniaPoint.y = y;
  }

  // Initializes the panel and reads the images
  public DrawPanel(int x, int y) {
    this.setDoubleBuffered(true);
    this.setPreferredSize(new Dimension(x, y));
    this.setBackground(Color.orange);
    // Print an error message in case file is not found with a try/catch block
    try {
      String assetsDir = System.getProperty("user.dir") + "/assets/";
      volvoImage = ImageIO.read(new FileInputStream(assetsDir + "Volvo240.jpg"));
      saabImage = ImageIO.read(new FileInputStream(assetsDir + "Saab95.jpg"));
      scaniaImage = ImageIO.read(new FileInputStream(assetsDir + "Scania.jpg"));

    } catch (IOException ex) {
      System.err.println("Image not found");
    }
  }

  /**
   * This method is called each time the panel updates/refreshes/repaints itself
   * It draws the images of the vehicles
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
    g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
    g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
  }
}
