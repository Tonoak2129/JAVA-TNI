import java.util.Scanner;

public class Lab405 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Input some sentence : ");
        String input = scn.nextLine();

        while (!input.endsWith(".")) {
            System.out.print("The sentence must end with full stop point : ");
            input = scn.nextLine();
        }

        Scanner wordScan = new Scanner(input);

        System.out.println(" ");
        while (wordScan.hasNext()) {
            String word = wordScan.next();
            System.out.println(word);
        }
    }
}
