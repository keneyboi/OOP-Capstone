package src;

import src.BackgroundPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscreteCalculatorGUI extends JFrame implements ActionListener {

    private JPanel ContentPanel;
    private JButton button1;
    private JTextPane textPane1;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;


    public DiscreteCalculatorGUI(){
        setTitle("Discrete Calculator");
        setSize(500, 700);
        setLocationRelativeTo(null);
        BackgroundPanel bg = new BackgroundPanel("assets/TestCalc.png");
        bg.add(ContentPanel);
        setContentPane(bg);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new DiscreteCalculatorGUI();
    }
}
