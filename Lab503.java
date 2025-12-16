import java.util.Scanner;

public class Lab503 {
    public static int count_vowel(String message,char letter){
        int vowel = 0;
        for (int i = 0; i<message.length();i++) {
            if (message.toLowerCase().charAt(i) == letter) {
               vowel++;
            }
        }
        return vowel;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Message : ");
        String message = scn.nextLine();

        System.out.println(" ");
        System.out.println("List of  vowel in \"" + message + "\"");
        System.out.println("The letter 'A' appears " + count_vowel(message,'a') + " time(s)");
        System.out.println("The letter 'E' appears " + count_vowel(message,'e') + " time(s)");
        System.out.println("The letter 'I' appears " + count_vowel(message,'i') + " time(s)");
        System.out.println("The letter 'O' appears " + count_vowel(message,'o') + " time(s)");
        System.out.println("The letter 'U' appears " + count_vowel(message,'u') + " time(s)");

    }
}
