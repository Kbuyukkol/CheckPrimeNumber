package com.kb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeCheckerUI_Swing extends JFrame {
    private JTextField textField;
    private JButton checkButton;
    private JLabel resultLabel;

    public PrimeCheckerUI_Swing() {
        setTitle("Prime Number Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        add(textField);

        checkButton = new JButton("Check");
        checkButton.addActionListener(new CheckButtonListener());
        add(checkButton);

        resultLabel = new JLabel();
        add(resultLabel);
    }

    private class CheckButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = textField.getText();
            try {
                int number = Integer.parseInt(input);
                if (PrimeChecker.isPrime(number)) {
                    resultLabel.setText(number + " is prime.");
                } else {
                    resultLabel.setText(number + " is not prime.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter a valid integer.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrimeCheckerUI_Swing primeCheckerUI = new PrimeCheckerUI_Swing();
            primeCheckerUI.setVisible(true);
        });
    }
}

