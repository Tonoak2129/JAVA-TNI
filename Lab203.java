import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab203 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DecimalFormat frm = new DecimalFormat("#,###.00");

        System.out.print("Enter product ID : ");
        String productID = scn.next();

        scn.nextLine();
        System.out.print("Enter product name : ");
        String productName = scn.nextLine();

        System.out.print("Enter product item : ");
        int productItem = Integer.parseInt(scn.next());

        System.out.print("Enter price per piece : ");
        double productPrice = Double.parseDouble(scn.next());

        double totalPrice = productItem * productPrice;
        System.out.println("----------------------------------");
        System.out.println("Product name : " + productName + " (" + productID + ')');
        System.out.println("Product item : " + productItem + " (" + frm.format(productPrice) + " baht/piece)");
        System.out.println("Total price : " + frm.format(totalPrice) + " baht");


    }
}
