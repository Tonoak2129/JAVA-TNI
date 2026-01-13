import java.util.Scanner;

public class ProductMain4 {
    public static void setting_product(Product... products) {
        String[] names = {"Pens", "Pencils", "Markers", "Highlighters"};
        double[] prices = {25.5, 17.25, 30, 35};
        int[] quantities = {20, 35, 10, 40};
        for (int i=0; i<products.length; i++) {
            products[i] = new Product();
            products[i].name = names[i];
            products[i].price = prices[i];
            products[i].quantity = quantities[i];
        }
    }
    public static void main(String[] args) {
        Product[] products = new Product[4];
        setting_product(products);

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome  to MINI SHOP!!");
        System.out.println("-----------------------------------------");
        System.out.println("Press 1 to buy Pens (items=" + products[0].quantity + ")");
        System.out.println("Press 2 to buy Pencils (items=" + products[1].quantity + ")");
        System.out.println("Press 3 to buy Markers (items=" + products[2].quantity + ")");
        System.out.println("Press 4 to buy Highlighters (items=" + products[3].quantity + ")");
        System.out.println("-----------------------------------------");

        System.out.print("Enter a number : ");
        int choice = scn.nextInt();
        while(choice<1 || choice>4){
            System.out.print("Invalid number! Enter a number, again : ");
            choice = scn.nextInt();
        }
        System.out.println("-----------------------------------------");
        System.out.print("How many " + products[choice-1].name + " do you want to buy? ");
        products[choice-1].sell(scn.nextInt());
        System.out.println(" ");
        products[choice-1].showInfo();


    }
}
