package Banking;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem1 {
    public static Scanner scn = new Scanner(System.in);

    public static String input_account_id(){
        String accId = "";

        while (true)
        {
            System.out.print("Enter account id: ");
            accId = scn.nextLine();
            if (accId.length()>=10)
            {
                break;
            }
        }
        return accId;
    }
    public static double input_initial_balance(){
        double deposit = 0;

        while (true)
        {
            try
            {
                System.out.print("Enter your initial deposit amount: ");
                deposit = scn.nextDouble();
                break;
            }
            catch (InputMismatchException err)
            {
                scn.next();
                System.out.print("Try again!! ");
            }
        }
        return deposit;
    }

    public static void main(String[] args) throws IOException {
        String account_bank = input_account_id();
        double initial_balance = input_initial_balance();
        OpenNewAccount account = new OpenNewAccount(account_bank,initial_balance);
        System.out.println();
        System.out.println(account.recordAccount());
    }
}