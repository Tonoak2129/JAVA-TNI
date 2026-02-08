import javax.swing.*;

public class CakeOrder3 {
    static void main() {
        double pound = Double.parseDouble(JOptionPane.showInputDialog("How many pounds do you want:"));
        String flavor = JOptionPane.showInputDialog("Enter a flavor birthday cake:");
        String message = JOptionPane.showInputDialog("Enter a message on cake:");

        BirthdayCake order1 = new BirthdayCake(message,pound,flavor,400);
        int confirm = JOptionPane.showConfirmDialog(null,
                order1 + "\n\nConfirm this order?",
                "Select an Option",
                JOptionPane.YES_NO_CANCEL_OPTION);

        while (true) {
            if (confirm == JOptionPane.YES_OPTION) {
                message = JOptionPane.showInputDialog("Enter a new message for changing:");
                order1.changeMessage(message);
                confirm = JOptionPane.showConfirmDialog(null,
                        order1 + "\n\nConfirm this order?",
                        "Select an Option",
                        JOptionPane.YES_NO_CANCEL_OPTION);

            } else {
                JOptionPane.showMessageDialog(null, order1);
                break;
            }
        }
    }
}
