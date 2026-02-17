import javax.swing.*;

public class Exception102 {
    public static void main(String[] args) {
        int number = 0;

        while (true) {
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer:"));

                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: " + e.getMessage(),
                        "Error Message",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,"Inputted number = " + number );
    }
}
