import javax.swing.*;
import java.text.DecimalFormat;

public class Lab207 {
    public static void main(String[] args) {
        DecimalFormat frm = new DecimalFormat("#,###.00");

        JOptionPane.showMessageDialog(null,"Welcome to  the payroll application","Message",JOptionPane.INFORMATION_MESSAGE);

        String employeeName = JOptionPane.showInputDialog(null,"Enter employee name : ");
        int totalHour = Integer.parseInt((JOptionPane.showInputDialog("Enter total hour for this employee")));

        final double wageRate = 7.50;
        final double taxRate = 0.15;
        double totalWage = totalHour * wageRate;
        double totalTax = totalWage * taxRate;
        double earning = totalWage - totalTax;

        JOptionPane.showMessageDialog(null,"Employee name : " + employeeName + "\nHour worked : " + totalHour +
                "\nHourly wage : $" + frm.format(wageRate) + "\nGross earnings : $" + frm.format(totalWage) + "\nTax rate : " + taxRate
                        + "\nTax : $" + frm.format(totalTax) + "\nNet earnings : $" + frm.format(earning)
                ,"Message",JOptionPane.INFORMATION_MESSAGE);
    }
}
