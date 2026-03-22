package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerMenu {
    private JPanel Register;
    private JTextField text_username;
    private JTextField text_password;
    private JTextField text_confirmPassword;
    private JButton but_confirm;
    private JButton but_back;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_confirmPassword;
    private JFrame frame;

    public registerMenu(){

        Register.setFont(new Font("Tahoma", Font.BOLD, 20));

        text_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        text_confirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));

        lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_confirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));

        but_confirm.setFont(new Font("Tahoma", Font.BOLD, 14));
        but_back.setFont(new Font("Tahoma", Font.BOLD, 14));

        but_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = text_username.getText();
                String password = text_password.getText();
                String confirmPassword = text_confirmPassword.getText();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter username!!");
                    return;
                }

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter password!!");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    text_password.setText("");
                    text_confirmPassword.setText("");
                    JOptionPane.showMessageDialog(frame, "Password not match!");
                    return;
                }

                RegisterService account = new RegisterService(username, password);

                if (account.recordAccount())
                {
                    JOptionPane.showMessageDialog(frame, "Created account successfully!!");
                    frame.dispose();
                    new homeMenu(username , password);
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "This username is already taken!");
                    text_username.setText("");
                    text_password.setText("");
                    text_confirmPassword.setText("");
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
        frame.setContentPane(Register);
        frame.setTitle("Game Party");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new registerMenu();
    }
}
