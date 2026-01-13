import javax.swing.*;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        JOptionPane.showMessageDialog(null ,"Welcome to Product  Stock System");

        Product pd = new Product();
        pd.name = JOptionPane.showInputDialog(null ,"Enter product name :");

        pd.price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter product price :"));

        pd.quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter product stock :"));

        pd.showInfo();

        int addItem = JOptionPane.showConfirmDialog(null
                , "Do you want to add more items?"
                ,"Select an Option"
                , JOptionPane.YES_NO_CANCEL_OPTION);
        if (addItem==JOptionPane.YES_OPTION){
            pd.addStock(Integer.parseInt
                    (JOptionPane.showInputDialog(null, "How many items to add in stock?")));
        }

        int newPrice = JOptionPane.showConfirmDialog(null
                , "Do you want to change price?"
                ,"Select an Option"
                , JOptionPane.YES_NO_CANCEL_OPTION);
        if (newPrice==JOptionPane.YES_OPTION){
            pd.changePrice(Double.parseDouble
                    (JOptionPane.showInputDialog(null, "How much is the new price per item?")));
        }

        pd.showInfo();
    }
}
