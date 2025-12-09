import javax.swing.*;

public class Lab402 {
    public static void main(String[] args) {
        String stuID;
        String major = "Cannot found major";
        do {
            stuID = JOptionPane.showInputDialog("Enter student-id :");
        }while (stuID.length()!=10);
        if (stuID.substring(2,5).equals("131"))  major = "Information Technology (IT)";
        else if (stuID.substring(2,5).equals("132")) major = "Multimedia Technology (MT)";
        else if (stuID.substring(2,5).equals("133")) major = "Digital Business Information Technology (BI)";
        else if (stuID.substring(2,5).equals("134")) major = "Digital Technology in Mass Communication (DC)";
        else if (stuID.substring(2,5).equals("135")) major = "Data Science and Data Analytics (DS)";

        JOptionPane.showMessageDialog(null,"Student ID : "+ stuID + "\nMajor : " + major);
    }
}
