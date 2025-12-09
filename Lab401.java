import javax.swing.*;

public class Lab401 {
    public static void main(String[] args) {
        int space;
        String name;
        do {
            name = JOptionPane.showInputDialog("Enter your full name:");
            space = name.indexOf(' ');
        } while (space == -1);
        JOptionPane.showMessageDialog(null,"Welcome, " + name.substring(0,name.indexOf(" "))+ name.substring(name.indexOf(" ")).toUpperCase() );

    }
}