
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIVersion2 extends JFrame implements ActionListener {
    private JPanel contentPanel;
    private JPanel OpeningScreen;
    private JPanel MainMenu;
    private JButton solveButton;
    private JButton SETTINGSButton;
    private JPanel InnerCardPanel;
    private JPanel DashBoard;
    private JButton DashboardButton;
    private JButton hypergeometricButton;
    private JButton binomialButton;
    private JButton bernoulliButton;
    private JButton permutationButton;
    private JButton combinationButton;
    private JButton solveBtn;
    private JPanel combinationPane;
    private JPanel permutationPane;
    private JPanel bernoulliPane;
    private JPanel binomialPane;
    private JPanel hypergeometricPane;
    private JButton historyBtn;
    private JButton accountBtn;
    private JLabel logoLabel;
    private JPanel accountPane;
    private JPanel historyPane;
    CardLayout cardLayout;
    JButton[] solveButtons;

    public GUIVersion2(){

        cardLayout = (CardLayout)InnerCardPanel.getLayout();
        solveButtons = new JButton[]{combinationButton, permutationButton, bernoulliButton, binomialButton, hypergeometricButton};

        ImageIcon logo = new ImageIcon("assets/test.png");
        Image newLogo = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(newLogo));
        setTitle("Discrete Calculator");
        setSize(650, 380);
        setMinimumSize(new Dimension(250, 380));
        setResizable(true);
        add(contentPanel);
        solveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getHeight() < 530 && !combinationButton.isVisible()) setSize(getWidth(), 530);
                for(JButton b : solveButtons){
                    if(!b.isVisible()) b.setVisible(true);
                    else b.setVisible(false);
                }

            }
        });

        accountBtn.addActionListener(this);
        historyBtn.addActionListener(this);
        for(JButton b : solveButtons){
            b.addActionListener(this);
        }

        setVisible(true);
        DashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DashBoard.isVisible()) DashBoard.setVisible(false);
                else DashBoard.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b : solveButtons){
            if(((JButton)(e.getSource())).equals(b)){
                cardLayout.show(InnerCardPanel, b.getActionCommand());
            }
        }
        if(e.getSource() == accountBtn) cardLayout.show(InnerCardPanel, "Account");
        if(e.getSource() == historyBtn) cardLayout.show(InnerCardPanel, "History");
    }

    public static void main(String[] args) {
        new GUIVersion2();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
