import java.util.Scanner;

public class Lab204 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Input hour : ");
        int hour = Integer.parseInt(scn.next());

        System.out.print("Input hour : ");
        int minute = Integer.parseInt(scn.next());

        int hour_to_min = hour * 60;
        int totalMin = hour_to_min + minute;

        System.out.print("Total time is " + totalMin + " minutes");
    }
}
