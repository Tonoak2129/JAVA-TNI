package Customer;

import javax.swing.*;

public class RestaurantBill {
    public static void main(String[] args) {
        String customer_name = JOptionPane.showInputDialog("Enter customer's name:");

        double bill_amount = Double.parseDouble(JOptionPane.showInputDialog("Enter customer's bill:"));

        int is_member = JOptionPane.showConfirmDialog(null,
                "Do you have a member card?",
                "Member",
                JOptionPane.YES_NO_OPTION);

        if (is_member == 0){
            String member_level = JOptionPane.showInputDialog("Enter a member level (GOld/Premium):");
            Member bill = new Member(customer_name,bill_amount,member_level);
            JOptionPane.showMessageDialog(null,bill);
        }
        else {
            Regular bill = new Regular(customer_name,bill_amount);
            JOptionPane.showMessageDialog(null,bill);
        }
    }
}
