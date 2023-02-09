package com.car.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the View part in the MVC pattern. It extends JFrame.
 * 
 * @author Kiril Curlinov, Sebastian Pålsson, Gabrielle Frattini
 * @since 2023-02-09
 * 
 * @param X An int object represents the width of the frame.
 * @param Y An int object represents the height of the frame.
 * @param carC A CarController object represents the controller part in the MVC pattern.
 * @param drawPanel A DrawPanel object represents the panel where the cars are drawn.
 * @param controlPanel A JPanel object represents the panel where the buttons are placed.
 * @param gasPanel A JPanel object represents the panel where the gaspanel is placed.
 * @param gasSpinner A JSpinner object represents the spinner where the user can choose the amount of gas.
 * @param gasAmount An int object represents the amount of gas.
 * @param gasLabel A JLabel object represents the label of the gas spinner.
 * @param gasButton A JButton object represents the button where the user can press to gas the car.
 * @param brakeButton A JButton object represents the button where the user can press to brake the car.
 * @param turboOnButton A JButton object represents the button where the user can press to turn the turbo on.
 * @param turboOffButton A JButton object represents the button where the user can press to turn the turbo off.
 * @param liftBedButton A JButton object represents the button where the user can press to lift the bed.
 * @param lowerBedButton A JButton object represents the button where the user can press to lower the bed.
 * @param startButton A JButton object represents the button where the user can press to start all cars.
 * @param stopButton A JButton object represents the button where the user can press to stop all cars.
 * 
 **/
public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;
    int gasAmount = 0;

    CarController carC;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    /**
     * Constructor for the CarView class.
     * @param framename
     * @param cc
     */
    public CarView(String framename, CarController cc){
        this.carC = cc;
        initComponents(framename);
    }

    /**
     * This method initializes the components of the frame.
     * 
     * @param title
     */
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);


        /**
         * This method creates a spinner where the user can choose the amount of gas.
         */
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        /**
         * Adds and actionlistener to the gas button.
         */
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        /**
         * Adds an actionlistener to the brake button.
         */
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        /**
         * Adds an actionlistener to the start button.
         */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.start();
            }
        });

        /**
         * Adds an actionlistener to the stop button.
         */
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stop();
            }
        });

        /**
         * Adds an actionlistener to the turbo on button for Saab95.
         */
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.enableTurbo();
            }
        });

        /**
         * Adds an actionlistener to the turbo off button for Saab95.
         */
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.disableTurbo();
            }
        });
        
        /**
         * Adds an actionlistener to the lift bed button for Scania truck.
         */
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftBed();
            }
        });
        
        /**
         * Adds an actionlistener to the lower bed button for Scania truck.
         */
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerBed();
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}