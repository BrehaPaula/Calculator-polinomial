package org.example.INTERFACE;

import org.example.model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InterfaceGUI extends JFrame {

    private JTextField input1;
    private JTextField input2;
    private JTextField output;
    private JButton subtractBtn;
    private JButton derivativeBtn;
    private JButton integrateBtn;
    private JButton multiplyBtn;
    private JButton addBtn;

    public InterfaceGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        input1 = new JTextField();
        input2 = new JTextField();
        inputPanel.add(input1);
        inputPanel.add(input2);
        add(inputPanel, BorderLayout.NORTH);

        output = new JTextField();
        output.setEditable(false);
        add(output, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        subtractBtn = new JButton("Subtract");
        derivativeBtn = new JButton("Derivative");
        integrateBtn = new JButton("Integrate");
        multiplyBtn = new JButton("Multiply");
        addBtn = new JButton("Add");

        buttonPanel.add(subtractBtn);
        buttonPanel.add(derivativeBtn);
        buttonPanel.add(integrateBtn);
        buttonPanel.add(multiplyBtn);
        buttonPanel.add(addBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        addButtonListeners();

        pack();
        setSize(600, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtonListeners() {
        subtractBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = input1.getText();
                String p2 = input2.getText();
                HashMap<Integer, Double> result = Polynomial.substract(p1, p2);
                output.setText(Polynomial.convertToString(result));
            }
        });

        derivativeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = input1.getText();
                HashMap<Integer, Double> result = Polynomial.derivative(p1);
                output.setText(Polynomial.convertToString(result));
            }
        });

        integrateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = input1.getText();
                HashMap<Integer, Double> result = Polynomial.integrate(p1);
                output.setText(Polynomial.convertToString(result));
            }
        });

        multiplyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = input1.getText();
                String p2 = input2.getText();
                HashMap<Integer, Double> result = Polynomial.multiply(p1, p2);
                output.setText(Polynomial.convertToString(result));
            }
        });

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1 = input1.getText();
                String p2 = input2.getText();
                HashMap<Integer, Double> result = Polynomial.addPolynomials(p1, p2);
                output.setText(Polynomial.convertToString(result));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGUI();
            }
        });
    }
}