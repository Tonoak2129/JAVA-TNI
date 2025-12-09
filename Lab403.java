import javax.swing.*;

public class Lab403 {
    public static void main(String[] args) {
        final String USERNAME = "admin";
        final String PASSWORD = "Admin1234";
        String userLogin = JOptionPane.showInputDialog("Enter username : ");
        String passLogin = JOptionPane.showInputDialog("Enter password : ");

        boolean userCheck = userLogin.equalsIgnoreCase(USERNAME);
        boolean passCheck = passLogin.equals(PASSWORD);

        if (userCheck && passCheck == true) JOptionPane.showMessageDialog(null,"Login Success!!");
        else JOptionPane.showMessageDialog(null,"Login Fail...", "Incorrect username or password",JOptionPane.WARNING_MESSAGE);
    }
}
