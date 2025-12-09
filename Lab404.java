import java.util.Scanner;

public class Lab404 {
    public static void main(String[] args) {
        String input = "";
        String text = "";
        String previous = "";
        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.print("Enter word : ");
            input = scn.next();
            if(input.equalsIgnoreCase("stop")) break;
            text += input + " ";
        }
        System.out.print(text);
    }
}

