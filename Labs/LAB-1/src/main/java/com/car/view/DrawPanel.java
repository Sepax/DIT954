package com.car.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class represents the View part in the MVC pattern. It extends JPanel.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabrielle Frattini 
 * @since 2023-02-08
 * 
 * @param volvoImage A BufferedImage object represents an image of a Vehicle.
 * @param saabImage A BufferedImage object represents an image of a Vehicle.
 * @param scaniaImage A BufferedImage object represents an image of a Vehicle.
 * @param volvoPoint A Point object represents a pair of (x,y) coordinates for a Vehicle.
 * @param saabPoint A Point object represents a pair of (x,y) coordinates for a Vehicle.
 * @param scaniaPoint A Point object represents a pair of (x,y) coordinates for a Vehicle.
 */

public class DrawPanel extends JPanel{

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
     * Points the vehicles to the specified coordinates, updates the panel
     */
    public void moveVolvo(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }
    /**
     * Points the vehicles to the specified coordinates, updates the panel
     */
    public void moveSaab(int x, int y){
        saabPoint.x = x;
        saabPoint.y = y;
    }
    /**
     * Points the vehicles to the specified coordinates, updates the panel
     */
    public void moveScania(int x, int y){
        scaniaPoint.x = x;
        scaniaPoint.y = y;
    }

    /**
     * Constructor for the DrawPanel class
     * @param x The width of the panel
     * @param y The height of the panel
     */
    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.orange);

        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../assets/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../assets/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../assets/Scania.jpg"));
        } 
        catch (IOException ex) {
            System.err.println("Image not found");
        }
    }

    /**
     * Paints the vehicles on the panel
     * 
     * @param g The graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); 
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
