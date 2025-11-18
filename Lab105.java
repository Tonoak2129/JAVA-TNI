import javax.swing.*;

public class Lab105 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "Summation number = " + (2 + 5) +
                        "\nSubtraction number = " + (2 - 5) +
                        "\nMultiplication number = " + (2 * 5) +
                        "\nDivision number = " + (2 / 5f) +
                        "\nModulus number = " + (2 % 5),
                "Arithmetic Operators",
                JOptionPane.WARNING_MESSAGE);
    }
}
