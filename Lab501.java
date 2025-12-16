import javax.swing.*;
import java.text.DecimalFormat;

public class Lab501 {
    public static double cal_bmi(double weight,double height_cm){
        double height_m = height_cm / 100;
        return weight / (height_m * height_m);
    }
    public static String check_bmi(double bmi){
        if (bmi<18.5) return "Underweight";
        if (bmi<24.9) return "Healthy Weight";
        if (bmi<29.9) return "Overweight";
        return "Obese";
    }
    public static void main (String[] args){
        DecimalFormat dcm = new DecimalFormat("##.##");
        int Yes_No = JOptionPane.showConfirmDialog(null,"Do you want to check BMI",
                "Check BMI",
                JOptionPane.YES_NO_OPTION);
        if (Yes_No==0) {
            double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight (kg.) :"));
            double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height (cm.) :"));
            JOptionPane.showMessageDialog(null,"Your BMI = " + dcm.format(cal_bmi(weight, height)) +
                    "\n Your BMI result = " + check_bmi(cal_bmi(weight,height)));
        }
        else JOptionPane.showMessageDialog(null,"END PROGRAM!!");
    }
}
