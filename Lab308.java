import javax.swing.*;
import java.util.Scanner;

public class Lab308 {
    public static void main(String args[]){
        int max = 0;
        int min = 0;
        int even = 0 ;
        int odd = 0;
        Scanner scn = new Scanner(System.in);
        System.out.print("How many number to input : ");
        int loop = scn.nextInt();


        for (int i = 1; i <= loop; i++){
            System.out.print("Enter number " + i + " : ");
            int num = scn.nextInt();
            if (num>=max) max = num;
            if (i==1)min = max;
            if (num<min) min = num;
            if (num%2==0) even++;
            if (num%2!=0) odd++;
        }
        System.out.println(" ");
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Even = " + even);
        System.out.println("Odd = " + odd);
    }
}
