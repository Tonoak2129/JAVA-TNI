import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception101 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int number = 0;
        while (true) {
            try {
                System.out.print("Enter an integer: ");
                number = scn.nextInt();

               break;
            }
                catch (InputMismatchException err) {
                scn.next();  //แก้ infinite loop
                System.out.print("Invalid data!! ");
            }
            catch (Exception err) {
                scn.next();
                System.out.print("Nuh uh");
            }
        }
        System.out.println("You inputted number = " + number);
    }
}
