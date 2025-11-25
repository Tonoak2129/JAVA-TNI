import javax.swing.*;
import java.text.DecimalFormat;

public class Lab208 {
    public static void main(String[] args) {
        DecimalFormat frm = new DecimalFormat(":00");

        int startHour = Integer.parseInt(JOptionPane.showInputDialog("Input start time (hour) : "));
        int startMinute = Integer.parseInt(JOptionPane.showInputDialog("Input start time (minute) : "));

        int endHour = Integer.parseInt(JOptionPane.showInputDialog("Input end time (hour) : "));
        int endMinute = Integer.parseInt(JOptionPane.showInputDialog("Input end time (minute) : "));

        int totalHour  = endHour - startHour;
        int totalMinute = endMinute - startMinute;

        if (totalMinute<0) {
            totalMinute += 60;
            totalHour -= 1;
        }

        double payment = (totalHour * 50) + (totalMinute * 0.25);

        JOptionPane.showMessageDialog(null,"Start parking at " + startHour + frm.format(startMinute)
                + "\nEnd parking at " + endHour + frm.format(endMinute) + "\nTotal time is " + totalHour + " hour " + totalMinute + " minutes" + "\nParking payment is " + payment + " baht");
    }
}
