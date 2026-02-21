package Banking;

import java.io.IOException;
import java.util.Scanner;

public class BankSystem2 {

    static public Scanner scn = new Scanner(System.in);

    static void main() throws IOException {
        System.out.print("Enter your bank account: ");
        String accountID = scn.next();

        AccountTransaction account = new AccountTransaction(accountID);

        System.out.println();
        if (account.hasAccountId())
        {
            System.out.println("Press 1 to deposit");
            System.out.println("Press 2 to withdraw");
            System.out.println("Press 3 to check balance");
            System.out.println("Press 4 to exit");

            int money;
            boolean loop = true;

            while (loop) {
                System.out.println();
                System.out.print("Enter a menu: ");
                int menu = scn.nextInt();

                switch (menu) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        money = scn.nextInt();
                        account.deposit(money);
                        System.out.println("Your balance = " + account.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        money = scn.nextInt();
                        account.withdraw(money);
                        System.out.println("Your balance = " + account.checkBalance());
                        break;
                    case 3:
                        System.out.println("Your balance = " + account.checkBalance());
                        break;
                    case 4:
                        loop = false;
                        break;
                    default:
                }
            }
        }
        else System.out.println("Bank account not found...");
    }
}
