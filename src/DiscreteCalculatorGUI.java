package src;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscreteCalculatorGUI extends JFrame implements ActionListener {

    private JPanel ContentPanel;
    private JPanel middlePane;
    private JPanel screenPane;
    private JPanel changePanel;
    private JPanel Hypergeometric;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox operationComboBox;
    private JButton computeButton;
    private JRadioButton rBA;
    private JRadioButton rBB;
    private JRadioButton rBC;
    private JRadioButton rBD;
    private JRadioButton rBE;
    private JRadioButton rBF;
    private JPanel innerMiddlePane;
    private JPanel Choices;
    private JButton clearButton;
    private JScrollPane scrollPane;
    private JPanel scrollPaneLayout;


    public DiscreteCalculatorGUI(){
        setTitle("Discrete Calculator");
        setSize(500, 920);
        setLocationRelativeTo(null);
        BackgroundPanel bg = new BackgroundPanel("assets/mainFrame.png");
        bg.add(ContentPanel);
        setContentPane(bg);


        // setting scrollpane transparent
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        setResizable(false);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new DiscreteCalculatorGUI();
    }
}
