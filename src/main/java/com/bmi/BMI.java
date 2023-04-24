/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.bmi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author guser
 */
public class BMI extends JFrame implements ActionListener {

    // Instance variables
    private JButton jbtnSubmit;
    private JButton jbtnClear;
    private JButton jbtnExit;
    private JTextField jtfWeight;
    private JTextField jtfHeight;

    public BMI() {
        // Get attributes of the frame.
        this.setTitle("BMI Health Check");
        this.setSize(340, 115);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // Create a panel to hold labels and textfields
        JPanel panelOne = new JPanel(new GridLayout(2, 2));

        // Create a JLabel
        JLabel jlblWeight = new JLabel("Enter weight in kilograms:");

        // Create a TextField
        jtfWeight = new JTextField();

        // Create a JLabel
        JLabel jlblHeight = new JLabel("Enter height in centimeters:");

        // Create a TextField
        jtfHeight = new JTextField();

        // Add components to panel one
        panelOne.add(jlblWeight);
        panelOne.add(jtfWeight);
        panelOne.add(jlblHeight);
        panelOne.add(jtfHeight);

        // *********************************************************************
        // Create a panel to store three buttons
        JPanel panelTwo = new JPanel();

        // Create buttons and add action listener
        jbtnSubmit = new JButton("Sumbit");
        jbtnSubmit.addActionListener(this);

        jbtnClear = new JButton("Clear");
        jbtnClear.addActionListener(this);

        jbtnExit = new JButton("Exit");
        jbtnExit.addActionListener(this);

        panelTwo.add(jbtnSubmit);
        panelTwo.add(jbtnClear);
        panelTwo.add(jbtnExit);

        // *********************************************************************
        // Create a master panel to store my two panels
        JPanel panel3 = new JPanel(new BorderLayout());

        // Add child panels to master panel
        panel3.add(panelOne, BorderLayout.NORTH);
        panel3.add(panelTwo, BorderLayout.CENTER);

        // Add Maste Panel to the frame
        this.add(panel3, BorderLayout.CENTER);

        // Display the frame
        this.setVisible(true);

    }

    public static void main(String[] args) {
        BMI obj = new BMI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double weight = 0;
        double height = 0;

        if (e.getSource() == jbtnSubmit) {
            // take in the weight
            try {
                weight = Double.parseDouble(jtfWeight.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Weight must be entered as a number, not text. Do not leave blank.", "BMI Calculator", JOptionPane.ERROR_MESSAGE);
            }

            // takein the height
            try {
                height = Double.parseDouble(jtfHeight.getText());

                // This line will only be executed if both a valid weight and height are entered.
                calculateBMI(weight, height);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Height must be entered as a number, not text. Do not leave blank.", "BMI Calculator", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jbtnClear) {
            jtfWeight.setText("");
            jtfHeight.setText("");

        } else if (e.getSource() == jbtnExit) {
            System.exit(0);
        }
    }

    private void calculateBMI(double weight, double height) {
        double bmi = weight / (height - 100);
        String result;

        // Display the result
        result = "Your BMI is: " + new java.text.DecimalFormat("##.##").format(bmi) + "\n";

        // Dicplay a message
        if (bmi < 0.85) {
            JOptionPane.showMessageDialog(null, result += "Seriously underweight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        } else if (bmi < 0.95) {
            JOptionPane.showMessageDialog(null, result += "Underweight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        } else if (bmi < 1.05) {
            JOptionPane.showMessageDialog(null, result += "Normal weight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        } else if (bmi < 1.15) {
            JOptionPane.showMessageDialog(null, result += "Overweight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        } else if (bmi < 1.25) {
            JOptionPane.showMessageDialog(null, result += "Seriously overweight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, result += "Gravely overweight", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE);
        }
    } // method
} // class

