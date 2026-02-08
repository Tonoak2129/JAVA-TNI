import java.util.Arrays;
import java.util.Scanner;

public class CakeOrder2 {
    public static Scanner scn = new Scanner(System.in);

    static String[] menu = {"Chocolate" , "Vanilla" , "Strawberry" , "Lemon" , "Red Velvet"};

    public static String selectFlavor(){
        for (int i = 0; i<menu.length; i++) {
            System.out.print("Press " + (i+1) + " for ");
            System.out.println(menu[i]);
        }
        System.out.print("Enter an option: ");
        String select = scn.nextLine();
        try {
            int flavor = Integer.parseInt(select);
            while (flavor>menu.length) {
                System.out.print("Enter an option: ");
                flavor = Integer.parseInt(scn.nextLine());
            }
            return menu[flavor-1];
        }
        catch (Exception e){
            String[] newMenu = new String[menu.length+1];
            for(int i = 0; i<menu.length; i++){
                newMenu[i] = menu[i];
            }
            menu = Arrays.copyOf(menu, menu.length + 1);
            menu[menu.length - 1] = select.substring(0, 1).toUpperCase() + select.substring(1);
            return menu[menu.length - 1];
        }
    }
    static void main() {
        System.out.println("Press 1 to order Birthday Cake");
        System.out.println("Press 2 to order Cup Cake");
        System.out.print("Enter an option: ");
        int option = Integer.parseInt(scn.nextLine());

        System.out.println(" ");
        if (option == 1) {
            String flavor = selectFlavor();

            System.out.println(" ");
            System.out.print("Enter a message on cake: ");
            String message = scn.nextLine();
            System.out.print("How many pound: ");
            double pound = Double.parseDouble(scn.nextLine());

            System.out.println(" ");
            BirthdayCake order1 = new BirthdayCake(message,pound,flavor,350);
            System.out.println(order1);
        }
        else if (option == 2) {
            String flavor = selectFlavor();

            System.out.println(" ");
            System.out.print("How many piece: ");
            int piece = Integer.parseInt(scn.nextLine());

            System.out.println(" ");
            CupCake order2 = new CupCake(piece,flavor,70);
            System.out.println(order2);
        }
        else if (option == 3){
            String flavor = selectFlavor();

            System.out.println(" ");
            System.out.print("Enter topping: ");
            String topping = scn.nextLine();
            System.out.print("How many scoop: ");
            int scoop = Integer.parseInt(scn.nextLine());

            System.out.println(" ");
            Tiramisu order3 = new Tiramisu(flavor, topping, scoop, 245);
            System.out.println(order3);
        }
        else System.out.println("Wrong option!! Try again!!");
    }
}
