import java.util.Scanner;

public class Lab303 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the value for X coordinate : ");
        int x = scn.nextInt();
        System.out.print("Enter the value for Y coordinate : ");
        int y = scn.nextInt();

        System.out.print("The coordinate point (" + x + "," + y + ")" + " lies in the ");
        if (x>0 && y>0) {
            System.out.print("First quadrant");
        }
        else if (x<0 && y>0) {
            System.out.print("Second quadrant");
        }
        else if (x<0 && y<0) {
            System.out.print("Third quadrant");
        }
        else if (x>0 && y<0) {
            System.out.print("Fourth quadrant");
        }
        else {
            System.out.print("Origin");
        }
    }
}
