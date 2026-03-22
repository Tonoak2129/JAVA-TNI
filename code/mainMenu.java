package MiniGameParty;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu {

    private JPanel Main;
    private JLabel lbl_mainMenu;
    private JButton but_signIn;
    private JButton but_createAcc;
    private JFrame frame;

    public mainMenu() {
        lbl_mainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        but_signIn.setFont(new Font("Tahoma", Font.BOLD, 20));
        but_createAcc.setFont(new Font("Tahoma", Font.BOLD, 20));

        but_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new loginMenu();
            }
        });

        but_createAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new registerMenu();
            }
        });

        frame = new JFrame();
        frame.setContentPane(Main);
        frame.setTitle("Game Party");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new mainMenu();
    }
}