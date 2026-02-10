package CoffeeShop;

import java.util.Scanner;

public class CoffeeShop {
    public static Scanner scn = new Scanner(System.in);

    public static Espresso orderEspresso(){
        System.out.print("Enter a size: ");
        String size = scn.next();

        System.out.print("Press 'y' or 'Y' for adding a shot: ");
        String addShot = scn.next();

        int shot = 0;
        if (addShot.equalsIgnoreCase("y")) {
            System.out.print("How many shots for adding in : ");
            shot = scn.nextInt();
        }
        Espresso espresso = new Espresso("Espresso",35,size,shot);

        System.out.println(espresso.toString());
        return espresso;
    }

    public static Frappuccino orderFrappuccino(){
        System.out.print("Enter a size: ");
        String size = scn.next();


        System.out.print("Do you would like to add whipped cream [y/Y]? ");
        String addWhip = scn.next();

        boolean whipped = false;
        if (addWhip.equalsIgnoreCase("y")) whipped = true;

        Frappuccino frappuccino = new Frappuccino("Frappuccino",40,size,whipped);

        System.out.println(frappuccino.toString());
        return frappuccino;
    }
    public static double calculateFinalPrice() {
        return orderEspresso().getBasePrice()+ orderFrappuccino().getBasePrice();
    }

    public static void main(String[] args) {
        int espresso = 0;
        int frappuccino = 0;
        while (true) {
            System.out.println("Press 1 for ordering Espresso");
            System.out.println("Press 2 for ordering Frappuccino");
            System.out.print("Enter an option: ");

            int option = scn.nextInt();
            if (option == 1) {
                orderEspresso();
                espresso += 1;
            }
            else if (option == 2) {
                orderFrappuccino();
                frappuccino += 1;
            }

            System.out.println();
            System.out.print("Do  you want to order more [y/Y]? ");
            String continueOrder = scn.next();
            if (continueOrder.equalsIgnoreCase("y")) continue;
            else break;
        }
        System.out.println("You ordered " + espresso + " Espresso");
        System.out.println("You ordered " + frappuccino + "Frappuccino");
        System.out.println("Total Price = " + calculateFinalPrice());
    }
}