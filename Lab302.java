import javax.swing.*;
import java.text.DecimalFormat;

public class Lab302 {
    public static void main(String[] args) {
        DecimalFormat dec = new DecimalFormat("##.0");
        String name = JOptionPane.showInputDialog(null,"Enter your name :");
        int height = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your height(cm.) :"));
        int male = JOptionPane.showConfirmDialog(null,"Are your biological gender is Male?",
                "Gender",JOptionPane.YES_NO_OPTION);
        if (male == 0){
            int weight = height - 100;
            JOptionPane.showMessageDialog(null,"Hello, " + "Mr." + name +
                    "\nIf your height is " + dec.format(height) + " cm." + "\nYour weight should be " + dec.format(weight) + " kg.");
        }
        else {
            int female = JOptionPane.showConfirmDialog(null,"Are your biological gender is Female?",
                    "Gender",JOptionPane.YES_NO_OPTION);
            if (female == 0) {
                int weight = height - 110;
                JOptionPane.showMessageDialog(null,"Hello, " + "Ms." + name +
                        "\nIf your height is " + dec.format(height) + " cm." + "\nYour weight should be " + dec.format(weight) + " kg.");
            }
            else {
                JOptionPane.showMessageDialog(null,"You can use BMI to measure your weight and height");
            }
        }
    }
}
