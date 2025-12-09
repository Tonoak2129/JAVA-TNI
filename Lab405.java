import java.util.Scanner;

public class Lab405 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Input some sentence : ");
        String input = scn.nextLine();
        while (input.lastIndexOf('.')<0) {
            System.out.print("The sentence must end with full stop point : ");
            input = scn.nextLine();
        }
        System.out.print(" ");
        if (input.lastIndexOf('.')>0) {

                String cut = input.substring(0, input.indexOf(" "));
                System.out.println(cut);
                System.out.println(" ");

        }
    }
}
