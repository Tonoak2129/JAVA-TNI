import java.util.Scanner;

public class Lab404 {
    public static void main(String[] args) {
        String input = "";
        String text = "";
        String previous = "";
        int i = 0;
        int j = 0;
        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.print("Enter word : ");
            input = scn.next();
            if (i==j) {
                previous=input;
                j++;
            }
            text = previous.concat(input);
            if(input.equalsIgnoreCase("stop")) break;
        }
        System.out.print(text);
    }
}
