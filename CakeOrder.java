import java.util.Scanner;

public class CakeOrder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Birthday Cake's Details:");
        System.out.print("Enter a message on cake: ");
        String message = scn.nextLine();
        System.out.print("Enter flavor: ");
        String flavor = scn.next();
        System.out.print("How many pound: ");
        double pound = scn.nextDouble();

        BirthdayCake order1 = new BirthdayCake(message,pound,flavor,350);
        System.out.println(order1);

        System.out.println(" ");
        System.out.println("Cup Cake's Details:");
        System.out.print("Enter flavor: ");
        flavor = scn.next();
        System.out.print("How many piece: ");
        int piece = scn.nextInt();

        CupCake order2 = new CupCake(piece,flavor,65);
        System.out.println(order2);

        System.out.println(" ");
        System.out.println("Tiramisu's Details:");
        System.out.print("Enter flavor: ");
        flavor = scn.next();
        System.out.print("Enter topping: ");
        String topping = scn.next();
        System.out.print("How many scoop: ");
        int scoop = scn.nextInt();

        Tiramisu order3 = new Tiramisu(flavor, topping, scoop, 245);
        System.out.println(order3);

        System.out.println(" ");
        System.out.println("Total price = " +
                (
                (order1.calculatedTotalPrice()) +
                (order2.calculatedTotalPrice()) +
                (order3.calculatedTotalPrice())
                )
        );
    }
}