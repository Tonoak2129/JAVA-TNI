package MiniGameParty;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class loginMenu {
    private JPanel Login;
    private JTextField text_username;
    private JPasswordField text_password;
    private JLabel lbl_gameParty;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JButton but_confirm;
    private JButton but_back;
    private JFrame frame;

    public loginMenu(){

        lbl_gameParty.setFont(new Font("Tahoma", Font.BOLD, 20));

        text_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text_password.setFont(new Font("Tahoma", Font.PLAIN, 16));

        lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 18));

        but_confirm.setFont(new Font("Tahoma", Font.BOLD, 14));
        but_back.setFont(new Font("Tahoma", Font.BOLD, 14));

        but_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = text_username.getText();
                String password = text_password.getText();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter username!!");
                    return;
                }

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter password!!");
                    return;
                }

                LoginService userCheck = new LoginService(username, password);

                try {
                        if (userCheck.loginAccount()) {
                            UserAccount userInfo = new UserAccount(username , password);
                            JOptionPane.showMessageDialog(frame, "Welcome back, " + username);
                            frame.dispose();
                            new homeMenu(username , password);
                        }
                        else JOptionPane.showMessageDialog(frame, "Wrong username or password");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Login Fail");
                    return;
                }
            }
        });
        but_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new mainMenu();
            }
        });

        frame = new JFrame();
        frame.setContentPane(Login);
        frame.setTitle("Game Party");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new loginMenu();
    }
}